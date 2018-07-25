package mahashakti.mahashakti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mahashakti.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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


    }

    @OnClick({R.id.btnLoginIn, R.id.btnSignup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLoginIn:

                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                break;
            case R.id.btnSignup:
                break;
        }
    }
}
