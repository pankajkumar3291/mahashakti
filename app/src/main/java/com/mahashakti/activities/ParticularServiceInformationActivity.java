package com.mahashakti.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.mahashakti.Adapters.ParticularServiceInfoAdapter;
import com.mahashakti.R;
import com.mahashakti.response.createParticularServiceInfo.PayLoad;

import java.util.ArrayList;

public class ParticularServiceInformationActivity extends AppCompatActivity {

    RecyclerView rvParticularService;
    RecyclerView.LayoutManager mLayoutManager;
    ParticularServiceInfoAdapter serviceInfoAdapter;

    ArrayList<PayLoad> payLoadArrayList = new ArrayList<>();

    KProgressHUD hud;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hidingStatusBar();

        setContentView(R.layout.particular_service_information_activity);


        if (getIntent() != null) {

            if (getIntent().hasExtra("creatingServiceForParticularOne")) {

                payLoadArrayList = (ArrayList<PayLoad>) getIntent().getSerializableExtra("creatingServiceForParticularOne");
            }
        }



        hud = new KProgressHUD(this);
        hud.dismiss();

        findingIdsHere();
        recyclerviewInitializationHere();

    }

    private void hidingStatusBar() {


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }


    private void recyclerviewInitializationHere() {

        rvParticularService.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rvParticularService.setLayoutManager(mLayoutManager);

        rvParticularService.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvParticularService.setItemAnimator(new DefaultItemAnimator());

        serviceInfoAdapter = new ParticularServiceInfoAdapter(ParticularServiceInformationActivity.this, payLoadArrayList);
        rvParticularService.setAdapter(serviceInfoAdapter);


    }


    private void findingIdsHere() {
        rvParticularService = findViewById(R.id.rvParticularService);
    }


}
