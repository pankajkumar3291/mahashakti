package com.mahashakti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mahashakti.adapters.AdapterBooking;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import com.mahashakti.arraysdummy.BookingCollection;
import com.mahashakti.R;
import com.mahashakti.baseactivity.BaseActivity;
import com.mahashakti.dialogs.BookingCancelDialog;
import com.mahashakti.Models.BookingModel;

public class BookingActivity extends BaseActivity {


    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bookingRecyclerView)
    RecyclerView bookingRecyclerView;

    private Context context;

    private AdapterBooking adapterBooking;
    ArrayList<BookingModel> bookingModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        context = this;

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("BOOKING");


        bookingRecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(BookingActivity.this);

        bookingRecyclerView.setLayoutManager(mLayoutManager);
        bookingRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterBooking = new AdapterBooking(BookingActivity.this, BookingCollection.getBookingList());

        bookingRecyclerView.setAdapter(adapterBooking);





      adapterBooking.setOnItemClickListener(new AdapterBooking.AdapterBookingClickListener() {
          @Override
          public void onCancelButtonClik(View view, int position) {

              BookingCancelDialog bookingCancelDialog = new BookingCancelDialog(BookingActivity.this);
              bookingCancelDialog.show();


          }

          @Override
          public void onBookedButtonClicked(View view, int position) {


              navigateToNextActivity(PaymentActivity.class);



          }
      });

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
