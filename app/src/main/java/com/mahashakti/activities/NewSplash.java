package com.mahashakti.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.mahashakti.R;
import com.mahashakti.sharedPreferences.UserDataUtility;

public class NewSplash extends AppCompatActivity {

    private volatile boolean interrupt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        hidingStatusBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_new);


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    if (!interrupt) {

                        if (UserDataUtility.getLogin(NewSplash.this)) {  //true

                            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                            startActivity(intent);
                            finish();
                            return;

                        } else {  //false

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        };
        timer.start();


    }


    private void hidingStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        interrupt = true;
    }
}
