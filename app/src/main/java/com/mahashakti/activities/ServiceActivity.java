package com.mahashakti.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.mahashakti.Adapters.ServiceAdapter;
import com.mahashakti.R;
import com.mahashakti.baseactivity.BaseActivity;
import com.mahashakti.httpNet.HttpModule;
import com.mahashakti.interfaces.ItemClickListener;
import com.mahashakti.response.createParticularServiceInfo.CreateParticularServiceInfo;
import com.mahashakti.response.createServices.PayLoad;
import com.sdsmdg.tastytoast.TastyToast;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener, ItemClickListener {


    private RelativeLayout imageBackaroow;
    private TextView toolbarTitle;
    private Toolbar toolbar;
    private Context context;


    private RecyclerView serviceRecyclerView;
    ArrayList<PayLoad> eventSuccessArrayList = new ArrayList<>();




    ArrayList<com.mahashakti.response.createParticularServiceInfo.PayLoad> payLoadArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bhaisalman);


        if (getIntent() != null) {
            if (getIntent().hasExtra("serviceList")) {
                eventSuccessArrayList = (ArrayList<PayLoad>) getIntent().getSerializableExtra("serviceList");
                System.out.println("ServiceActivity.onCreate - -- " + eventSuccessArrayList.size());
            }
        }


        context = this;

        findingIdsHere();
        initializeAdapterHere();


        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        toolbarTitle.setText("SERVICE");


    }

    private void initializeAdapterHere() {

        System.out.println("ServiceActivity.initializeAdapterHere - - - " + eventSuccessArrayList.size());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        serviceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        serviceRecyclerView.setLayoutManager(gridLayoutManager);
        ServiceAdapter serviceAdapter = new ServiceAdapter(ServiceActivity.this, eventSuccessArrayList);
        serviceRecyclerView.setAdapter(serviceAdapter);
        serviceAdapter.setClickListener(this);
    }


    private void findingIdsHere() {
        serviceRecyclerView = findViewById(R.id.serviceRecyclerView);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtGetStarted:
                TastyToast.makeText(getApplicationContext(), "Getting Services ", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                break;

            case R.id.imageBackaroow:

                finish();
                break;

        }
    }

    @Override
    public void onClick(View view, int position) {

        HttpModule.provideRepositoryService().creatingparticularService(eventSuccessArrayList.get(position).id).enqueue(new Callback<CreateParticularServiceInfo>() {
            @Override
            public void onResponse(Call<CreateParticularServiceInfo> call, Response<CreateParticularServiceInfo> response) {

                if (response.body().isSuccess != null) {

                    if (response.body().isSuccess) {

                        Intent intent = new Intent(ServiceActivity.this, ParticularServiceInformationActivity.class);
                        intent.putExtra("creatingServiceForParticularOne" , (Serializable) response.body().payLoad);
                        startActivity(intent);

                    } else {
                        TastyToast.makeText(getApplicationContext(), "SOMETHING WENT WRONG", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<CreateParticularServiceInfo> call, Throwable t) {

                System.out.println("ServiceActivity.onFailure " + t);

            }
        });

    }
}
