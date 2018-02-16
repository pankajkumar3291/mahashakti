package com.mahashakti.presenter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.mahashakti.R;

/**
 * Created by dharamveer on 25/1/18.
 */

public class BasePresenter extends AppCompatActivity{


    protected ProgressDialog pDialog;

    protected AlertDialog alertDialog;

    public BasePresenter(Context context) {

        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(true);


        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton(
                "Ok",
                (dialog, id) -> dialog.cancel());
        alertDialog = alertDialogBuilder.create();


    }


    public void showErrorDialog(String title){

        new AwesomeErrorDialog(this)
                .setTitle(title)
                .setColoredCircle(R.color.dialogErrorBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
                .setCancelable(true).setButtonText(getString(R.string.dialog_ok_button))
                .setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setErrorButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        // click
                    }
                })
                .show();


    }




}
