package com.mahashakti.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.mahashakti.R;
import com.sdsmdg.tastytoast.TastyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dharamveer on 12/1/18.
 */

public class BookingCancelDialog extends Dialog {


    Context context;
    public myOnClickListener myListener;

    @BindView(R.id.btnYes)
    Button btnYes;

    @BindView(R.id.btnNo)
    Button btnNo;

    @BindView(R.id.txtNameofFest)
    TextView txtNameofFest;

    public BookingCancelDialog(@NonNull Context context) {
        super(context);
        this.context = context;


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setCanceledOnTouchOutside(false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog_cancel_booking);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btnYes, R.id.btnNo})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnYes:
                TastyToast.makeText(getContext(), "Your booking has been cancelled now ", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                dismiss();

                break;
            case R.id.btnNo:
                TastyToast.makeText(getContext(), "Thanks for shwoing the intrest ", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                dismiss();
                break;
        }
    }

    public interface myOnClickListener {
        void onButtonClick(View view);
    }


}
