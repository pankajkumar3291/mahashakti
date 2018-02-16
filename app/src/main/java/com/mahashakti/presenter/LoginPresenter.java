package com.mahashakti.presenter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import com.mahashakti.AppConstants;
import com.mahashakti.R;
import com.mahashakti.activities.DashboardActivity;
import com.mahashakti.activities.LoginActivity;
import com.mahashakti.di.modules.SharedPrefsHelper;
import com.mahashakti.manager.GitApiInterface;
import com.mahashakti.response.LoginUserResponse.LoginUserSuccess;
import com.taishi.flipprogressdialog.FlipProgressDialog;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dharamveer on 25/1/18.
 */

public class LoginPresenter extends BasePresenter {


    private CompositeDisposable compositeDisposable;

    public LoginPresenter(final LoginPresenter.View view, GitApiInterface apiService, SharedPrefsHelper sharedPrefsHelper, String email, String pass) {
        super((LoginActivity) view);



        compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(apiService.loginUser(email,pass)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginUserSuccess>() {
                    @Override
                    public void accept(LoginUserSuccess loginUserSuccess) throws Exception {

                        compositeDisposable.dispose();


                        if(loginUserSuccess.getSuccess()){



                            sharedPrefsHelper.put(AppConstants.USER_ID,loginUserSuccess.getPayload().getId());
                            sharedPrefsHelper.put(AppConstants.USER_NAME,loginUserSuccess.getPayload().getName());
                            sharedPrefsHelper.put(AppConstants.EMAIL,loginUserSuccess.getPayload().getEmail());
                            sharedPrefsHelper.put(AppConstants.PHONE_NUMBER,loginUserSuccess.getPayload().getPhone());
                            sharedPrefsHelper.put(AppConstants.USER_SEX,loginUserSuccess.getPayload().getSex());
                            sharedPrefsHelper.put(AppConstants.PROFILE_PIC,loginUserSuccess.getPayload().getUserpic());

                            view.loginSuccessful("Success");

                        }
                        else {


                            alertDialog.setMessage("Password is wrong.");
                            alertDialog.show();
                        }


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {


                        view.loginFailed(throwable);
                        compositeDisposable.dispose();
                    }
                }));



    }

    public interface View {
        void loginSuccessful(String message);
        void loginFailed(Throwable t);
    }





}
