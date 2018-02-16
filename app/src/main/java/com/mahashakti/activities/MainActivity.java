package com.mahashakti.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

import com.mahashakti.R;
import com.mahashakti.baseactivity.BaseActivity;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btnLoginIn)
    Button btnLoginIn;
    @BindView(R.id.btnSignup)
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_main_activity);


    }

    @OnClick({R.id.btnLoginIn, R.id.btnSignup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLoginIn:


                navigateToNextActivity(LoginActivity.class);


                break;
            case R.id.btnSignup:


                navigateToNextActivity(SignUpActivity.class);

                break;
        }
    }



}
