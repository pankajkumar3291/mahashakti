package com.mahashakti.presenter;

import android.content.Context;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.mahashakti.R;
import com.mahashakti.activities.SignUpActivity;
import com.mahashakti.di.modules.SharedPrefsHelper;
import com.mahashakti.manager.GitApiInterface;
import com.mahashakti.response.CreateUserSuccess.CreateUserSuccess;
import com.mahashakti.response.CreateUserSuccess.PayLoad;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by dharamveer on 25/1/18.
 */

public class RegisterPresenter extends BasePresenter {

    private ArrayList<PayLoad> payLoadArrayList = new ArrayList<>();
    private RegisterPresenter.View view;

    private CompositeDisposable compositeDisposable;

    public RegisterPresenter(Context context, final RegisterPresenter.View view, GitApiInterface apiService, SharedPrefsHelper sharedPrefsHelper,
                              String email, String pass ,String username) {
        super((SignUpActivity) view);

        this.view = view;

        compositeDisposable = new CompositeDisposable();


        compositeDisposable.add(apiService.createUser(email, pass , username)
                .subscribeOn(io.reactivex.schedulers.Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CreateUserSuccess>() {
                    @Override
                    public void accept(CreateUserSuccess createUserSuccess) throws Exception {

                        pDialog.dismiss();
                        compositeDisposable.dispose();

                        // it was dharmveer code commented by shahzeb
//                        if(createUserSuccess.getSuccess()){
//
//                            System.out.println("RegisterPresenter.accept - -  check success ");
//
////                            view.registerSuccessful(createUserSuccess.getMessage()); // it was dharmveer code commented by shahzeb
//                        }

                        if (createUserSuccess.isSuccess) {


                            view.registerSuccessful(createUserSuccess.message);

                            int UserId = createUserSuccess.payLoad.id;
                            String UserEmail = createUserSuccess.payLoad.email;
                            String UserName = createUserSuccess.payLoad.name;
                            String UserSex = String.valueOf(createUserSuccess.payLoad.sex);
                            String UserTel = String.valueOf(createUserSuccess.payLoad.phone);





                        } else {

                            System.out.println("RegisterPresenter.accept" + createUserSuccess.message);
                            new AwesomeErrorDialog(context)
                                    .setTitle("Error")
                                    .setMessage(createUserSuccess.message)
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
                        System.out.println("RegisterPresenter.accept - -check exception    " + throwable);

                    }
                }));

    }


    public interface View {
        void registerSuccessful(String message);

        void registerFailed(Throwable t);
    }


}

