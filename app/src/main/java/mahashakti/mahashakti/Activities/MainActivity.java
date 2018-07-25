package mahashakti.mahashakti.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.taishi.flipprogressdialog.FlipProgressDialog;

import java.util.ArrayList;
import java.util.List;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mahashakti.R;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btnLoginIn)
    Button btnLoginIn;
    @BindView(R.id.btnSignup)
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


       NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(MainActivity.this).build();

    }

    @OnClick({R.id.btnLoginIn, R.id.btnSignup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLoginIn:

                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);

                break;
            case R.id.btnSignup:


                 startActivity(new Intent(MainActivity.this,SignUpActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;
        }
    }



}
