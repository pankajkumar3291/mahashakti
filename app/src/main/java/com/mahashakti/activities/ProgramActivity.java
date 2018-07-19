package com.mahashakti.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kogitune.activity_transition.ActivityTransitionLauncher;
import com.mahashakti.R;
import com.mahashakti.response.EventResponse.EventSuccess;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import com.mahashakti.adapters.AdapterProgram;
import com.mahashakti.baseactivity.BaseActivity;
import com.mahashakti.response.EventResponse.EventPayload;
import com.mahashakti.response.EventResponse.PayLoad;
import com.sdsmdg.tastytoast.TastyToast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ProgramActivity extends BaseActivity {


    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.programRecyclerView)
    RecyclerView programRecyclerView;


    private AdapterProgram adapterProgram;
    ArrayList<PayLoad> eventSuccessArrayList = new ArrayList<>();

    Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        context = this;

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("PROGRAM");

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ProgramActivity.this);

        programRecyclerView.setHasFixedSize(true);

        programRecyclerView.setLayoutManager(mLayoutManager);
        programRecyclerView.setItemAnimator(new DefaultItemAnimator());


        GetAllEventAPi();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();

    }

    private void GetAllEventAPi() {

        compositeDisposable.add(apiService.getallevent()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<EventSuccess>() {
                    @Override
                    public void accept(EventSuccess eventSuccess) throws Exception {


                        if(eventSuccess.isSuccess){
                            eventSuccessArrayList = new ArrayList<>(eventSuccess.payLoad);

                            TastyToast.makeText(getApplicationContext() , eventSuccess.message , TastyToast.LENGTH_SHORT , TastyToast.SUCCESS).show();

                            adapterProgram = new AdapterProgram(ProgramActivity.this, eventSuccessArrayList);


                            programRecyclerView.setAdapter(adapterProgram);

                            adapterProgram.setOnItemClickListener(new AdapterProgram.AdapterProgramListener() {
                                @Override
                                public void onChatButtonClik(View view, int position) {


                                    startActivity(new Intent(ProgramActivity.this, ChatActivity.class));


                                }

                                @Override
                                public void onBookingButtonClicked(View view, int position) {

                                    startActivity(new Intent(ProgramActivity.this, PaymentActivity.class));


                                }
                            });



                            adapterProgram.setOnRowClickListener(new AdapterProgram.EventListenerActivity() {
                                @Override
                                public void onRowClick(View image, String title, String des, String startDate, String endDate, int seats, int perprice, String location) {


                                    Intent intent = new Intent(context,EventDetailActivity.class);
                                    Bundle transitionBundle = ActivityTransitionLauncher
                                            .with(ProgramActivity.this)
                                            .from(image)
                                            .createBundle();
                                    intent.putExtras(transitionBundle);

                                    // ActivityTransitionLauncher.with(ProgramActivity.this).from(image).launch(intent);
                                    intent.putExtra("title", title);
                                    intent.putExtra("des", des);
                                    intent.putExtra("startDate", startDate);
                                    intent.putExtra("endDate", endDate);
                                    intent.putExtra("seats", seats);
                                    intent.putExtra("perprice", perprice);
                                    intent.putExtra("location", location);
                                    startActivity(intent);
                                    //overridePendingTransition(R.anim.enter, R.anim.exit);
                                    overridePendingTransition(0, 0);




                                }
                            });
                        }
                        else {

                            showAlertDialog("Retry","Events Not");
                        }




                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        compositeDisposable.dispose();
                        throw new RuntimeException("I'm a cool exception and I crashed the main thread!");
                       // showAlertDialog("Retry",throwable.getMessage());


                    }
                }));


    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }


    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {

        finish();

    }
}
