package com.mahashakti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mahashakti.R;
import com.mahashakti.httpNet.HttpModule;
import com.mahashakti.response.forgetPassword.ForgetPassword;
import com.sdsmdg.tastytoast.TastyToast;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


                    TastyToast.makeText(getApplicationContext(), "Please enter a valid emailid", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                } else {

                    HttpModule.provideRepositoryService().forgetPasswordAPI(edEmailForget.getText().toString()).enqueue(new Callback<ForgetPassword>() {
                        @Override
                        public void onResponse(Call<ForgetPassword> call, Response<ForgetPassword> response) {

                            if (response.body() != null) {

                                if (response.body().isSuccess) {

//                                    edEmailForget.setText("");
                                    edEmailForget.setText(null);


                                    TastyToast.makeText(getApplicationContext(), response.body().message, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                                } else {

                                    TastyToast.makeText(getApplicationContext(), response.body().message, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<ForgetPassword> call, Throwable t) {

                            System.out.println("ForgetPasswordActivity.onFailure " + t);

                        }
                    });
                }
                break;
        }

    }

}
