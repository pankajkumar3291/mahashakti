package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mahashakti.mahashakti.Adapters.AdapterBooking;
import mahashakti.mahashakti.Adapters.AdapterProgram;
import mahashakti.mahashakti.ArraysDummy.BookingCollection;
import mahashakti.mahashakti.ArraysDummy.ProgramCollection;
import mahashakti.mahashakti.Dialogs.BookingCancelDialog;
import mahashakti.mahashakti.Models.BookingModel;
import mahashakti.mahashakti.Models.ProgramModel;
import com.mahashakti.R;

public class BookingActivity extends AppCompatActivity {


    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bookingRecyclerView)
    RecyclerView bookingRecyclerView;

    private Context context;

    private AdapterBooking adapterBooking;
    ArrayList<BookingModel> bookingModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        ButterKnife.bind(this);

        context = this;


        NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(context).build();


        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("BOOKING");




        bookingRecyclerView.setHasFixedSize(true);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(BookingActivity.this);

        bookingRecyclerView.setLayoutManager(mLayoutManager);
        bookingRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapterBooking = new AdapterBooking(BookingActivity.this, BookingCollection.getBookingList());

        bookingRecyclerView.setAdapter(adapterBooking);





      adapterBooking.setOnItemClickListener(new AdapterBooking.AdapterBookingClickListener() {
          @Override
          public void onCancelButtonClik(View view, int position) {

              BookingCancelDialog bookingCancelDialog = new BookingCancelDialog(BookingActivity.this);
              bookingCancelDialog.show();


          }

          @Override
          public void onBookedButtonClicked(View view, int position) {

              startActivity(new Intent(BookingActivity.this, PaymentActivity.class));
              overridePendingTransition(R.anim.enter, R.anim.exit);


          }
      });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {



        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);


    }
}
