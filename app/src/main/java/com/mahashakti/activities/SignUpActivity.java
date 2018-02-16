package com.mahashakti.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mahashakti.R;
import com.mahashakti.baseactivity.BaseActivity;
import com.mahashakti.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity implements RegisterPresenter.View {

    @BindView(R.id.imageBack)
    ImageView imageBack;
    @BindView(R.id.edUserName)
    EditText edUserName;
    @BindView(R.id.edEmail)
    EditText edEmail;
    @BindView(R.id.edPsword)
    EditText edPsword;
    @BindView(R.id.edConfirmPsw)
    EditText edConfirmPsw;
    @BindView(R.id.btnSignup)
    Button btnSignup;
    @BindView(R.id.tvSignIn)
    TextView tvSignIn;
    @BindView(R.id.mainRegisterLayout)
    RelativeLayout mainRegisterLayout;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_new_activity);
        ButterKnife.bind(this);


        context = this;

    }


    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }


    @OnClick({R.id.imageBack, R.id.btnSignup, R.id.tvSignIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageBack:

                finish();


                break;
            case R.id.btnSignup:




                if (TextUtils.isEmpty(edUserName.getText().toString()) || !isValidEmail(edEmail.getText().toString()) || TextUtils.isEmpty(edPsword.getText().toString())
                        || TextUtils.isEmpty(edConfirmPsw.getText().toString()) || !edPsword.getText().toString().equals(edConfirmPsw.getText().toString())) {


                    if (TextUtils.isEmpty(edUserName.getText().toString())) {
                        Snackbar.make(mainRegisterLayout, "Username cant be empty", Snackbar.LENGTH_SHORT).show();

                    } else if (TextUtils.isEmpty(edEmail.getText().toString())) {
                        Snackbar.make(mainRegisterLayout, "Email can't be empty", Snackbar.LENGTH_SHORT).show();

                    } else if (!isValidEmail(edEmail.getText().toString())) {
                        Snackbar.make(mainRegisterLayout, "Use valid email address", Snackbar.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(edPsword.getText().toString())) {
                        Snackbar.make(mainRegisterLayout, "Password can't be empty", Snackbar.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(edConfirmPsw.getText().toString())) {
                        Snackbar.make(mainRegisterLayout, "Confirm Password can't be empty", Snackbar.LENGTH_SHORT).show();
                    }

                    else if (!edPsword.getText().toString().equals(edConfirmPsw.getText().toString())) {
                        Snackbar.make(mainRegisterLayout, "Password doesn't match", Snackbar.LENGTH_SHORT).show();
                    }



                }
                else {

                    flipProgress();


                    View view1 = this.getCurrentFocus();

                    if(view1 !=null){

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view1.getWindowToken(),0);
                    }
                    new RegisterPresenter(getApplicationContext(),SignUpActivity.this,apiService,sharedPrefsHelper,edUserName.getText().toString().trim(),edEmail.getText().toString().trim(),
                            edPsword.getText().toString().trim());
                }



                break;
            case R.id.tvSignIn:

                startActivity(new Intent(context, LoginActivity.class));

                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();

    }


    @Override
    public void registerSuccessful(String message) {


        fpd.dismiss();
        showSuccessDialog(message);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        }, 1000);





    }

    @Override
    public void registerFailed(Throwable t) {

        fpd.dismiss();
        showErrorDialog(t.getMessage());

        // Snackbar.make(mainRegisterLayout, t.getLocalizedMessage(), Snackbar.LENGTH_SHORT).show();


    }
}
