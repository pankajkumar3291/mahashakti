package com.mahashakti.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mahashakti.Adapters.ParticularServiceInfoAdapter;
import com.mahashakti.R;
import com.mahashakti.response.createParticularServiceInfo.PayLoad;

import java.util.ArrayList;

public class ParticularServiceInformationActivity extends AppCompatActivity {

    RecyclerView rvParticularService;
    RecyclerView.LayoutManager mLayoutManager;
    ParticularServiceInfoAdapter serviceInfoAdapter;

    ArrayList<PayLoad> payLoadArrayList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.particular_service_information_activity);


        if (getIntent() != null) {

            if (getIntent().hasExtra("creatingServiceForParticularOne")) {

                payLoadArrayList = (ArrayList<PayLoad>) getIntent().getSerializableExtra("creatingServiceForParticularOne");
            }
        }


        findingIdsHere();
        recyclerviewInitializationHere();

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
