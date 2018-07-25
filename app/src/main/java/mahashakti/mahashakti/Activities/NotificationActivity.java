package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mahashakti.mahashakti.Adapters.AdapterBooking;
import mahashakti.mahashakti.Adapters.AdapterNotifications;
import mahashakti.mahashakti.ArraysDummy.BookingCollection;
import mahashakti.mahashakti.ArraysDummy.NotificationCollection;
import mahashakti.mahashakti.Models.NotificationModel;
import com.mahashakti.R;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.NotificationRecyclerView)
    RecyclerView NotificationRecyclerView;

    private AdapterNotifications adapterNotifications;
    private ArrayList<NotificationModel> notificationModelArrayList = new ArrayList<>();

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);

        context = this;

        NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(context).build();


        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("NOTIFICATION");




        NotificationRecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(NotificationActivity.this);

        NotificationRecyclerView.setLayoutManager(mLayoutManager);
        NotificationRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterNotifications = new AdapterNotifications(NotificationActivity.this, NotificationCollection.getNotificationList());

        NotificationRecyclerView.setAdapter(adapterNotifications);




    }

    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {


        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }

}
