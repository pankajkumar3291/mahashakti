package com.mahashakti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mahashakti.R;
import com.sdsmdg.tastytoast.TastyToast;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener {


    //    @BindView(R.id.imageBackForget)
    private ImageView imageBackForget;

    //    @BindView(R.id.edEmailForget)
    private EditText edEmailForget;

    //    @BindView(R.id.btnSubmitForget)
    private Button btnSubmitForget;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_new_activity);

        context = this;
        findingIdsHere();
        clcikListener();


    }

    private void clcikListener() {
        imageBackForget.setOnClickListener(this);
        edEmailForget.setOnClickListener(this);
        btnSubmitForget.setOnClickListener(this);

    }

    private void findingIdsHere() {
        imageBackForget = findViewById(R.id.imageBackForget);
        edEmailForget = findViewById(R.id.edEmailForget);
        btnSubmitForget = findViewById(R.id.btnSubmitForget);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }


//    @OnClick({R.id.imageBackForget, R.id.btnSubmitForget})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.imageBackForget:
//                finish();
//
//                break;
//            case R.id.btnSubmitForget:
//
//
//                TastyToast.makeText(getApplicationContext(), "Checking...", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
//
//                break;
//        }
//    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageBackForget:
                finish();

                break;
            case R.id.btnSubmitForget:

                if (edEmailForget.getText().toString().isEmpty()) {
                    TastyToast.makeText(getApplicationContext(), "Please enter the emailid", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                } else {
                    TastyToast.makeText(getApplicationContext(), "Checking...", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                }
                break;
        }


    }
}
