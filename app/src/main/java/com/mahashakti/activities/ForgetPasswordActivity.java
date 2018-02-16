package com.mahashakti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mahashakti.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPasswordActivity extends AppCompatActivity {


    @BindView(R.id.imageBackForget)
    ImageView imageBackForget;
    @BindView(R.id.edEmailForget)
    EditText edEmailForget;
    @BindView(R.id.btnSubmitForget)
    Button btnSubmitForget;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_new_activity);

        context = this;


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }


    @OnClick({R.id.imageBackForget, R.id.btnSubmitForget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageBackForget:

                finish();

                break;
            case R.id.btnSubmitForget:
                break;
        }
    }
}
