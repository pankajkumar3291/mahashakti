package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mahashakti.mahashakti.Adapters.SimpleFragmentPagerAdapter;
import com.mahashakti.R;

public class PaymentActivity extends AppCompatActivity {


    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.sliding_tabs)
    TabLayout slidingTabs;

    Context context;
    NoInternetDialog noInternetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        context = this;

         noInternetDialog = new NoInternetDialog.Builder(context).build();

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("PAYMENT");


        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewpager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        slidingTabs.setupWithViewPager(viewpager);

        createTabIcons();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }

    private void createTabIcons() {


        View headerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.custom_tab, null, false);


        LinearLayout linearLayoutOne =  headerView.findViewById(R.id.ll);
        LinearLayout linearLayout2 =  headerView.findViewById(R.id.ll2);
        LinearLayout linearLayout3 =  headerView.findViewById(R.id.ll3);

        slidingTabs.getTabAt(0).setCustomView(linearLayoutOne);
        slidingTabs.getTabAt(1).setCustomView(linearLayout2);
        slidingTabs.getTabAt(2).setCustomView(linearLayout3);
    }



    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {

        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }
}
