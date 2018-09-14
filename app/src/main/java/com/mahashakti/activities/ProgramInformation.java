package com.mahashakti.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahashakti.R;
import com.mahashakti.response.EventResponse.PayLoad;

import java.util.ArrayList;

public class ProgramInformation extends AppCompatActivity {


    private TextView tvPrice, tvSeat, tvVenue, tvDescription, tvTitle;
    PayLoad eventSuccessArrayList;
    ImageView backArrow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_information);


        if (getIntent() != null) {

            if (getIntent().hasExtra("eventArrayInfo")) {
                eventSuccessArrayList = (PayLoad) getIntent().getSerializableExtra("eventArrayInfo");
            }
        }


        findingIdsHere();
        settingUpValuesHere();


    }

    private void settingUpValuesHere() {


        tvPrice.setText(eventSuccessArrayList.price);

//        tvDescription.setText(eventSuccessArrayList.description);
        tvDescription.setMovementMethod(new ScrollingMovementMethod());
        String mHtmlString = eventSuccessArrayList.description;

        tvDescription.setText(Html.fromHtml(Html.fromHtml(mHtmlString).toString()));


        tvVenue.setText(eventSuccessArrayList.location);
        tvTitle.setText(eventSuccessArrayList.name);


    }


    private void findingIdsHere() {


        tvPrice = findViewById(R.id.tvPrice);
        tvSeat = findViewById(R.id.tvSeat);
        tvVenue = findViewById(R.id.tvVenue);
        tvDescription = findViewById(R.id.tvDescription);

        tvTitle = findViewById(R.id.tvTitle);

        tvSeat.setText(eventSuccessArrayList.totalSeat);

        backArrow = findViewById(R.id.backArrow);


        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();
            }
        });


    }
}
