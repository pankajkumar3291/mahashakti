package com.mahashakti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

import com.mahashakti.R;
import com.mahashakti.baseactivity.BaseActivity;

public class ServiceActivity extends BaseActivity {


    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageMoney)
    ImageView imageMoney;
    @BindView(R.id.imageHealth)
    ImageView imageHealth;
    @BindView(R.id.imageLove)
    ImageView imageLove;
    @BindView(R.id.imageSpriti)
    ImageView imageSpriti;
    @BindView(R.id.imageNeagive)
    ImageView imageNeagive;
    @BindView(R.id.txtGetStarted)
    TextView txtGetStarted;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);


        context = this;


        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("SERVICE");


    }


    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {

        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }




    @OnClick({R.id.imageMoney, R.id.imageHealth, R.id.imageLove, R.id.imageSpriti, R.id.imageNeagive, R.id.txtGetStarted})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageMoney:

                didTapButton(imageMoney);


                break;
            case R.id.imageHealth:
                didTapButton(imageHealth);

                break;
            case R.id.imageLove:

                didTapButton(imageLove);

                break;
            case R.id.imageSpriti:
                didTapButton(imageSpriti);


                break;
            case R.id.imageNeagive:

                didTapButton(imageNeagive);



                break;
            case R.id.txtGetStarted:


                break;
        }
    }
}
