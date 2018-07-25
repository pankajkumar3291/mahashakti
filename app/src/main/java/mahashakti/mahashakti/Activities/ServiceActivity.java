package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mahashakti.mahashakti.Animations.MyBounceInterpolator;
import com.mahashakti.R;

public class ServiceActivity extends AppCompatActivity {

//
//    @BindView(R.id.imageBackaroow)
//    RelativeLayout imageBackaroow;
//    @BindView(R.id.toolbar_title)
//    TextView toolbarTitle;
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;
//
//    TextView txtGetStarted;
//
//    private Context context;
//    NoInternetDialog noInternetDialog;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_service);
//        ButterKnife.bind(this);
//
//
//        context = this;
//
//        noInternetDialog = new NoInternetDialog.Builder(context).build();
//
//        toolbar = findViewById(R.id.toolbar);
//        toolbarTitle = findViewById(R.id.toolbar_title);
//
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//
//        toolbarTitle.setText("SERVICE");
//
//
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        noInternetDialog.onDestroy();
//    }
//
//    @OnClick(R.id.imageBackaroow)
//    public void onViewClicked() {
//
//        finish();
//        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
//
//    }
//
//    public void didTapButton(View view) {
//        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
//
//        // Use bounce interpolator with amplitude 0.2 and frequency 20
//        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.02, 20);
//        myAnim.setInterpolator(interpolator);
//
//
//        view.startAnimation(myAnim);
//
//    }
//
//
//    @OnClick({R.id.imageMoney, R.id.imageHealth, R.id.imageLove, R.id.imageSpriti, R.id.imageNeagive, R.id.txtGetStarted})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.imageMoney:
//
//                didTapButton(imageMoney);
//
//
//                break;
//            case R.id.imageHealth:
//                didTapButton(imageHealth);
//
//                break;
//            case R.id.imageLove:
//
//                didTapButton(imageLove);
//
//                break;
//            case R.id.imageSpriti:
//                didTapButton(imageSpriti);
//
//
//                break;
//            case R.id.imageNeagive:
//
//                didTapButton(imageNeagive);
//
//
//
//                break;
//            case R.id.txtGetStarted:
//
//
//                break;
//        }
//    }
}
