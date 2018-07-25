package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mahashakti.R;

public class ForgetPasswordActivity extends AppCompatActivity {


    @BindView(R.id.imageBackForget)
    ImageView imageBackForget;
    @BindView(R.id.edEmailForget)
    EditText edEmailForget;
    @BindView(R.id.btnSubmitForget)
    Button btnSubmitForget;

    private Context context;

    NoInternetDialog noInternetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);

        context = this;

        noInternetDialog = new NoInternetDialog.Builder(context).build();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


    @OnClick({R.id.imageBackForget, R.id.btnSubmitForget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageBackForget:

                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

                break;
            case R.id.btnSubmitForget:
                break;
        }
    }
}
