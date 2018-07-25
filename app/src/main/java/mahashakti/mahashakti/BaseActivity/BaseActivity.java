package mahashakti.mahashakti.BaseActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import am.appwise.components.ni.NoInternetDialog;

/**
 * Created by dharamveer on 20/1/18.
 */

public class BaseActivity extends AppCompatActivity {



    Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;


    }




}
