package mahashakti.mahashakti.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import am.appwise.components.ni.NoInternetDialog;
import com.mahashakti.R;
import mahashakti.mahashakti.SharedPreferences.UserDataUtility;
import qiu.niorgai.StatusBarCompat;

public class SplashActivity extends AppCompatActivity {


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;
    private Context context;
    NoInternetDialog noInternetDialog;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = SplashActivity.this;


        //translucent status bar
        StatusBarCompat.translucentStatusBar(activity);

        //should hide status bar background (default black background) when SDK >= 21
        StatusBarCompat.translucentStatusBar(activity, false);



        context = this;



         noInternetDialog = new NoInternetDialog.Builder(context).build();
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {



                if(UserDataUtility.getLogin(context)){  //true

                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    return;
                }
                else {  //false

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                }



            }
        }, SPLASH_TIME_OUT);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }


}
