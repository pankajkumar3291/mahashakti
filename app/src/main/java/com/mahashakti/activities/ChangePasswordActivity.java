package com.mahashakti.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahashakti.R;
import com.mahashakti.httpNet.HttpModule;
import com.mahashakti.response.changePassword.ChangePassword;
import com.sdsmdg.tastytoast.TastyToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edEmailId, edOldPsw, edNewPsw, edConfirmPsw;
    private Button btnChange;
    private TextView tvSignIn;
    private ImageView imgBack;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password_activity);


        findingIdsHere();
        clickListener();


    }

    private void clickListener() {
        btnChange.setOnClickListener(this);
        tvSignIn.setOnClickListener(this);
        imgBack.setOnClickListener(this);


    }

    private void findingIdsHere() {


        edEmailId = findViewById(R.id.edEmailId);
        edOldPsw = findViewById(R.id.edOldPsw);
        edNewPsw = findViewById(R.id.edNewPsw);
        edConfirmPsw = findViewById(R.id.edConfirmPsw);

        btnChange = findViewById(R.id.btnChange);

        tvSignIn = findViewById(R.id.tvSignIn);

        imgBack = findViewById(R.id.imgBack);


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {


            case R.id.btnChange:


                if (edEmailId.getText().toString().trim().length() > 0 && edOldPsw.getText().toString().trim().length() > 0 && edNewPsw.getText().toString().trim().length() > 0 && edConfirmPsw.getText().toString().trim().length() > 0) {

                    changePassword();

                } else {


                    TastyToast.makeText(getApplicationContext(), "Please fill the fields", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();

                }


                break;


            case R.id.tvSignIn:

                Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

                break;

            case R.id.imgBack:

                finish();

                break;


        }


    }

    private void changePassword() {


        HttpModule.provideRepositoryService().changePasswordAPI(edEmailId.getText().toString(), edOldPsw.getText().toString(), edNewPsw.getText().toString()).enqueue(new Callback<ChangePassword>() {
            @Override
            public void onResponse(Call<ChangePassword> call, Response<ChangePassword> response) {


                if (response.body() != null) {


                    if (response.body().isSuccess) {


                        TastyToast.makeText(getApplicationContext(), response.body().message, TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                    } else {

                        TastyToast.makeText(getApplicationContext(), "Incorrect Old Password", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                    }


                }

            }

            @Override
            public void onFailure(Call<ChangePassword> call, Throwable t) {

                System.out.println("ChangePasswordActivity.onFailure " + t);


            }
        });


    }
}
