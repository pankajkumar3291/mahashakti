package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mahashakti.mahashakti.Adapters.AdapterProgram;
import com.mahashakti.R;
import com.mahashakti.Response.EventResponse.EventPayload;
import com.mahashakti.Response.EventResponse.EventSuccess;
import com.mahashakti.RetrofitLibrary.RestClient1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.cybersapien.recyclerele.RecyclerELEAdapter;

public class ProgramActivity extends AppCompatActivity {


    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.programRecyclerView)
    RecyclerView programRecyclerView;


    private AdapterProgram adapterProgram;
    ArrayList<EventPayload> eventSuccessArrayList = new ArrayList<>();

    Context context;
    NoInternetDialog noInternetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        ButterKnife.bind(this);


        context = this;

        noInternetDialog = new NoInternetDialog.Builder(context).build();

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

    private void GetAllEventAPi() {


        final RestClient1.GitApiInterface restClient = RestClient1.getClient();

        restClient.getallevent().enqueue(new Callback<EventSuccess>() {
            @Override
            public void onResponse(Call<EventSuccess> call, Response<EventSuccess> response) {

                if(response.isSuccessful()){


                    if(response.body().getSuccess()){



                        eventSuccessArrayList = new ArrayList<>(response.body().getPayload());


                        adapterProgram = new AdapterProgram(ProgramActivity.this, eventSuccessArrayList);


                        programRecyclerView.setAdapter(adapterProgram);

                        adapterProgram.setOnItemClickListener(new AdapterProgram.AdapterProgramListener() {
                            @Override
                            public void onChatButtonClik(View view, int position) {


                                startActivity(new Intent(ProgramActivity.this, ChatActivity.class));
                                overridePendingTransition(R.anim.enter, R.anim.exit);


                            }

                            @Override
                            public void onBookingButtonClicked(View view, int position) {

                                startActivity(new Intent(ProgramActivity.this, PaymentActivity.class));
                                overridePendingTransition(R.anim.enter, R.anim.exit);


                            }
                        });



                        adapterProgram.setOnRowClickListener(new AdapterProgram.EventListenerActivity() {
                            @Override
                            public void onRowClick(String title, String des, String startDate, String endDate, int seats, int perprice, String location) {



                                Intent intent = new Intent(context,EventDetailActivity.class);
                                intent.putExtra("title", title);
                                intent.putExtra("des", des);
                                intent.putExtra("startDate", startDate);
                                intent.putExtra("endDate", endDate);
                                intent.putExtra("seats", seats);
                                intent.putExtra("perprice", perprice);
                                intent.putExtra("location", location);
                                startActivity(intent);
                                overridePendingTransition(R.anim.enter, R.anim.exit);




                            }
                        });



                    }
                    else {


                    }
                }
                else {

                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(context, "server broken", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(context, "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }


            }

            @Override
            public void onFailure(Call<EventSuccess> call, Throwable t) {

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {

        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }
}
