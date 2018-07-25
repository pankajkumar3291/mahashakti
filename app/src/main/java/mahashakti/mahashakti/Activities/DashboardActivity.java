package mahashakti.mahashakti.Activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.droidbyme.dialoglib.AnimUtils;
import com.droidbyme.dialoglib.DroidDialog;

import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import mahashakti.mahashakti.Animations.MyBounceInterpolator;
import mahashakti.mahashakti.Dialogs.LogoutConfirmDialog;
import mahashakti.mahashakti.Hawk.HawkUserUtility;
import com.mahashakti.R;
import mahashakti.mahashakti.SharedPreferences.UserDataUtility;
import qiu.niorgai.StatusBarCompat;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar topToolBar;


    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.card_view_service)
    CardView card_view_service;
    @BindView(R.id.card_view_thoughts)
    CardView cardViewThoughts;
    @BindView(R.id.card_view_gallery)
    CardView cardViewGallery;
    @BindView(R.id.card_view_program)
    CardView cardViewProgram;
    @BindView(R.id.card_view_booking)
    CardView cardViewBooking;
    @BindView(R.id.card_view_profile)
    CardView cardViewProfile;
    @BindView(R.id.card_view_chat)
    CardView cardViewChat;


    TextView notifications;
    private CircleImageView profile_image;
    private TextView tvEmpName, tvDesignation;

    private Context context;
    NoInternetDialog noInternetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        context =this;
        Hawk.init(context).build();

        topToolBar = findViewById(R.id.toolbar);

        setSupportActionBar(topToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        imageBackaroow.setVisibility(View.GONE);

        noInternetDialog = new NoInternetDialog.Builder(context).build();

        navigationDrawerCode();


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }

    private void navigationDrawerCode() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, topToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);

        profile_image = hView.findViewById(R.id.profile_image);
        tvEmpName = hView.findViewById(R.id.tvEmpName);
        tvDesignation = hView.findViewById(R.id.tvDesignation);


        //UserDataUtility userDataUtility = new UserDataUtility(context);


        HawkUserUtility hawkUserUtility = new HawkUserUtility(context);

        String fullname = hawkUserUtility.getUserName();
        String userPic = hawkUserUtility.getUserPic();
        String emailId = hawkUserUtility.getUserEmail();


        tvEmpName.setText(fullname);
        tvDesignation.setText(emailId);

        Picasso.with(context)
                .load("http://mahashaktiradiance.com/" + userPic)
                .error(R.drawable.user)
                .into(profile_image);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        notifications = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.notification_frag));

        //This method will initialize the count value
        initializeCountDrawer();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initializeCountDrawer() {

        //Gravity property aligns the text
        notifications.setGravity(Gravity.CENTER_VERTICAL);
        notifications.setTypeface(null, Typeface.BOLD);
        notifications.setTextColor(getResources().getColor(R.color.colorAccent));
        notifications.setText("99+");


    }



    public void gotoNextActivity(Class cla){

        startActivity(new Intent(DashboardActivity.this, cla));
        overridePendingTransition(R.anim.enter, R.anim.exit);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile_frag) {


            gotoNextActivity(ProfileActivity.class);

        } else if (id == R.id.notification_frag) {



            gotoNextActivity(NotificationActivity.class);


        } else if (id == R.id.chat_frag) {



            gotoNextActivity(ChatActivity.class);



        } else if (id == R.id.settings_frag) {

        } else if (id == R.id.addbank_frag) {

        } else if (id == R.id.help_frag) {

        } else if (id == R.id.log_out_frag) {



            new DroidDialog.Builder(context)
                    .icon(R.drawable.ic_action_tick)
                    .title("Logout")
                    .content(getString(R.string.areyousuretologout))
                    .cancelable(true, true)
                    .positiveButton("YES", new DroidDialog.onPositiveListener() {
                        @Override
                        public void onPositive(Dialog droidDialog) {
                            droidDialog.dismiss();
                            // Toast.makeText(context, "YES", Toast.LENGTH_SHORT).show();

                            UserDataUtility.setLogin(false,context);

                            startActivity(new Intent(DashboardActivity.this, MainActivity.class));
                            overridePendingTransition(R.anim.enter, R.anim.exit);
                            finish();


                        }
                    })
                    .negativeButton("No", new DroidDialog.onNegativeListener() {
                        @Override
                        public void onNegative(Dialog droidDialog) {
                            droidDialog.dismiss();
                            //Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .neutralButton("SKIP", new DroidDialog.onNeutralListener() {
                        @Override
                        public void onNeutral(Dialog droidDialog) {
                            droidDialog.dismiss();
                            // Toast.makeText(context, "Skip", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .typeface("regular.ttf")
                    .animation(AnimUtils.AnimZoomInOut)
                    .color(ContextCompat.getColor(context, R.color.signinbtncolor), ContextCompat.getColor(context, R.color.white),
                            ContextCompat.getColor(context, R.color.dark_indigo))
                    .divider(true, ContextCompat.getColor(context, R.color.orange))
                    .show();




        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @OnClick({R.id.card_view_chat,R.id.card_view_service,R.id.card_view_thoughts, R.id.card_view_gallery, R.id.card_view_program, R.id.card_view_booking, R.id.card_view_profile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_view_thoughts:


                navigateToNextActivity(ThoughtsActivity.class,cardViewThoughts);

                break;
            case R.id.card_view_gallery:


                navigateToNextActivity(GalleryActivity.class,cardViewGallery);


                break;
            case R.id.card_view_program:



                navigateToNextActivity(ProgramActivity.class,cardViewProgram);



                break;
            case R.id.card_view_booking:

                navigateToNextActivity(BookingActivity.class,cardViewBooking);




                break;
            case R.id.card_view_profile:

                navigateToNextActivity(ProfileActivity.class,cardViewProfile);

                break;

            case R.id.card_view_service:


                navigateToNextActivity(ServiceActivity.class,card_view_service);

                break;

            case R.id.card_view_chat:

                navigateToNextActivity(ChatActivity.class,cardViewChat);


                break;

        }
    }
    private void navigateToNextActivity(final Class aClass,CardView cardView){

        bounceButton(cardView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(DashboardActivity.this, aClass));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        },300);


    }


    public void bounceButton(View view){

        ObjectAnimator animY = ObjectAnimator.ofFloat(view, "translationY", 10f, 0f);
        animY.setDuration(1000);//1sec
        animY.setInterpolator(new BounceInterpolator());
        int numRepeats = 0;
        animY.setRepeatCount(numRepeats);
        animY.start();
    }



}
