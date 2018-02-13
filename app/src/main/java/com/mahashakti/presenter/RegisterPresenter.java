package com.mahashakti.presenter;

import android.content.Context;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.mahashakti.R;
import com.mahashakti.activities.SignUpActivity;
import com.mahashakti.di.modules.SharedPrefsHelper;
import com.mahashakti.manager.GitApiInterface;
import com.mahashakti.response.CreateUserSuccess.CreateUserSuccess;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by dharamveer on 25/1/18.
 */

public class RegisterPresenter extends BasePresenter {


    private RegisterPresenter.View view;

    private CompositeDisposable compositeDisposable;

    public RegisterPresenter(Context context,final RegisterPresenter.View view, GitApiInterface apiService, SharedPrefsHelper sharedPrefsHelper,
                             String username, String email, String pass) {
        super((SignUpActivity) view);
        this.view = view;

        compositeDisposable = new CompositeDisposable();


        compositeDisposable.add(apiService.createUser(email,username,pass)
                .subscribeOn(io.reactivex.schedulers.Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CreateUserSuccess>() {
                    @Override
                    public void accept(CreateUserSuccess createUserSuccess) throws Exception {

                        pDialog.dismiss();
                        compositeDisposable.dispose();

                        if(createUserSuccess.getSuccess()){


                            view.registerSuccessful(createUserSuccess.getMessage());
                        }
                        else {

                            new AwesomeErrorDialog(context)
                                    .setTitle("Error")
                                    .setMessage(createUserSuccess.getMessage())
                                    .setColoredCircle(R.color.dialogErrorBackgroundColor)
                                    .setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
                                    .setCancelable(true).setButtonText(String.valueOf(R.string.dialog_ok_button))
                                    .setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
                                    .setButtonText("OK")
                                    .setErrorButtonClick(new Closure() {
                                        @Override
                                        public void exec() {
                                            // click
                                        }
                                    })
                                    .show();

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        view.registerFailed(throwable);
                        compositeDisposable.dispose();

                    }
                }));

    }


    public interface View {
        void registerSuccessful(String message);
        void registerFailed(Throwable t);
    }


}

