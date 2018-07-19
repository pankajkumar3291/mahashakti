package com.mahashakti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mahashakti.adapters.AdapterNotifications;
import com.mahashakti.arraysdummy.NotificationCollection;
import com.mahashakti.Models.NotificationModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.mahashakti.R;
import com.mahashakti.baseactivity.BaseActivity;

public class NotificationActivity extends BaseActivity {

    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.NotificationRecyclerView)
    RecyclerView NotificationRecyclerView;

    private AdapterNotifications adapterNotifications;
    private ArrayList<NotificationModel> notificationModelArrayList = new ArrayList<>();

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);

        context = this;

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText("NOTIFICATION");


        NotificationRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(NotificationActivity.this);
        NotificationRecyclerView.setLayoutManager(mLayoutManager);
        NotificationRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterNotifications = new AdapterNotifications(NotificationActivity.this, NotificationCollection.getNotificationList());
        NotificationRecyclerView.setAdapter(adapterNotifications);


    }

    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
