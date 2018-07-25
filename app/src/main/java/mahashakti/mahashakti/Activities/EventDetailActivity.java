package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mahashakti.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class EventDetailActivity extends AppCompatActivity {


    String title, des, startDate, endDate, location;
    int seats, perprice;
    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageEvent)
    ImageView imageEvent;
    @BindView(R.id.txtEventTitle)
    TextView txtEventTitle;
    @BindView(R.id.txtEventDes)
    TextView txtEventDes;
    @BindView(R.id.txtEventStartDate)
    TextView txtEventStartDate;
    @BindView(R.id.txtEventEndDate)
    TextView txtEventEndDate;
    @BindView(R.id.txtEventSeats)
    TextView txtEventSeats;
    @BindView(R.id.txtEventPricePerson)
    TextView txtEventPricePerson;
    @BindView(R.id.txtEventLocation)
    TextView txtEventLocation;

    Context context;
    NoInternetDialog noInternetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);

        context = this;

        noInternetDialog = new NoInternetDialog.Builder(context).build();

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("EVENT DETAIL");

        Intent intent = getIntent();


        if (intent != null) {


            title = intent.getStringExtra("title");
            des = intent.getStringExtra("des");
            startDate = intent.getStringExtra("startDate");
            endDate = intent.getStringExtra("endDate");
            seats = intent.getIntExtra("seats", 0);
            perprice = intent.getIntExtra("perprice", 0);
            location = intent.getStringExtra("location");
        }



        txtEventTitle.setText(title);
        txtEventDes.setText(des);
        txtEventStartDate.setText(startDate);
        txtEventEndDate.setText(endDate);
        txtEventSeats.setText(String.valueOf(seats));
        txtEventPricePerson.setText(String.valueOf(perprice));
        txtEventLocation.setText(location);


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

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {

        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }



}
