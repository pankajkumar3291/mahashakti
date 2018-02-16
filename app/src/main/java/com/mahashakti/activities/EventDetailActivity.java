package com.mahashakti.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kogitune.activity_transition.ActivityTransition;
import com.kogitune.activity_transition.ExitActivityTransition;
import com.mahashakti.R;
import com.mahashakti.baseactivity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventDetailActivity extends BaseActivity {


    String title, des, startDate, endDate, location;
    int seats, perprice;
    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageEvent)
    ImageView imageEvent;
    @BindView(R.id.txtEventTitle)
    TextView txtEventTitle;
    @BindView(R.id.txtEventDes)
    TextView txtEventDes;
    @BindView(R.id.txtEventStartDate)
    TextView txtEventStartDate;
    @BindView(R.id.txtEventEndDate)
    TextView txtEventEndDate;
    @BindView(R.id.txtEventSeats)
    TextView txtEventSeats;
    @BindView(R.id.txtEventPricePerson)
    TextView txtEventPricePerson;
    @BindView(R.id.txtEventLocation)
    TextView txtEventLocation;

    Context context;
    private ExitActivityTransition exitTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);
        //exitTransition = ActivityTransition.with(getIntent()).to(imageEvent).start(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            exitTransition = ActivityTransition
                    .with(getIntent())
                    .enterListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            Log.d("TAG", "onEnterAnimationEnd!!");
                        }

                        @Override
                        public void onAnimationStart(Animator animation) {
                            Log.d("TAG", "onEnterAnimationStart!!");
                        }
                    })
                    .to(findViewById(R.id.imageEvent))
                    .start(savedInstanceState);

        }


        context = this;


        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("EVENT DETAIL");

        Intent intent = getIntent();


        if (intent != null) {


            title = intent.getStringExtra("title");
            des = intent.getStringExtra("des");
            startDate = intent.getStringExtra("startDate");
            endDate = intent.getStringExtra("endDate");
            seats = intent.getIntExtra("seats", 0);
            perprice = intent.getIntExtra("perprice", 0);
            location = intent.getStringExtra("location");
        }


        txtEventTitle.setText(title);
        txtEventDes.setText(des);
        txtEventStartDate.setText(startDate);
        txtEventEndDate.setText(endDate);
        txtEventSeats.setText(String.valueOf(seats));
        txtEventPricePerson.setText(String.valueOf(perprice));
        txtEventLocation.setText(location);


    }


    @Override
    public void onBackPressed() {

        if (exitTransition != null) {
            exitTransition.exit(this);
        }
        finish();

    }


    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {

        if (exitTransition != null) {
            exitTransition.exit(this);
        }

        finish();
/*
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
*/
        exitTransition.exit(this);

    }



}
