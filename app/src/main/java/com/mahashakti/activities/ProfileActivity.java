package com.mahashakti.activities;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mahashakti.R;
import com.mahashakti.ApplicationClass.AppController;
import com.mahashakti.events.ImageProfileEvent;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.enums.EPickType;
import com.vansuita.pickimage.listeners.IPickResult;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

import com.mahashakti.AppConstants;
import com.mahashakti.baseactivity.BaseActivity;
import com.mahashakti.response.ProfileUpdateResponse.ProfileUpdateSuccess;
import com.mahashakti.sharedPreferences.UserDataUtility;
import com.mahashakti.utils.FileUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ProfileActivity extends BaseActivity implements IPickResult {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageProfile)
    CircleImageView imageProfile;
    @BindView(R.id.edUserNameProfile)
    EditText edUserNameProfile;
    @BindView(R.id.edEmailAddressProfile)
    EditText edEmailAddressProfile;
    @BindView(R.id.edPhoneNumber)
    EditText edPhoneNumber;


    @BindView(R.id.txtUpdate)
    TextView txtUpdate;
    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.imageCamera)
    ImageView imageCamera;
    @BindView(R.id.rootView)
    RelativeLayout rootView;
    @BindView(R.id.profileTop)
    ConstraintLayout profileTop;
    @BindView(R.id.radioMale)
    RadioButton radioMale;
    @BindView(R.id.radioFemale)
    RadioButton radioFemale;
    @BindView(R.id.radioSex)
    RadioGroup radioSex;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private Context context;
    private RadioButton radioSexButton;
    private String userId, email, phone, sex;

    private Uri imagePath;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        context = this;
        Hawk.init(context).build();

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("PROFILE");


        String fullname = sharedPrefsHelper.get(AppConstants.USER_NAME, "username");
        String emailId = sharedPrefsHelper.get(AppConstants.EMAIL, "email");
        String phoneNo = sharedPrefsHelper.get(AppConstants.PHONE_NUMBER, "phonenumber"); // Shahzeb editted the phone number default value
        String sex = sharedPrefsHelper.get(AppConstants.USER_SEX, "sex");
        String userPic = sharedPrefsHelper.get(AppConstants.PROFILE_PIC, "");


// Actually if you want your entire layout pan up than you should use :
        // this will keep the keyboard closed and when opened it'll push your entire activity up.
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        if (userPic.contains("facebook")) {

            Picasso.with(context)
                    .load(userPic)
                    .error(R.drawable.user)
                    .into(imageProfile);
        } else {

            Picasso.with(context)
                    .load("http://mahashaktiradiance.com/" + userPic)
                    .error(R.drawable.user)
                    .into(imageProfile);

        }


        edUserNameProfile.setText(fullname);
        edEmailAddressProfile.setText(emailId);
        edPhoneNumber.setText(phoneNo);


        progressBar.setVisibility(View.GONE);


        if (sex.equalsIgnoreCase("Male")) {

            radioMale.setChecked(true);
        } else {

            radioFemale.setChecked(true);
        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    @OnClick({R.id.imageBackaroow, R.id.imageCamera, R.id.txtUpdate})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.imageBackaroow:


                finish();
                break;
            case R.id.imageCamera:

                onImageViewClick();

                break;

            case R.id.txtUpdate:

                flipProgress();
                // get selected radio button from radioGroup
                int selectedId = radioSex.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = findViewById(selectedId);


                userId = String.valueOf(sharedPrefsHelper.get(AppConstants.USER_ID, 1));
                email = edEmailAddressProfile.getText().toString();
                phone = edPhoneNumber.getText().toString().trim();
                sex = String.valueOf(radioSexButton.getText());

                System.out.println("ProfileActivity.onViewClicked - Phone number check  - -" + phone);

                updateProfileApi(userId, email, phone, sex, imagePath);


                break;

        }
    }


    private void updateProfileApi(String userId, String email, String phone, String sex, Uri imagePath) {

        RequestBody userID = RequestBody.create(MediaType.parse("text/plain"), userId);
        RequestBody emailID = RequestBody.create(MediaType.parse("text/plain"), email);
        RequestBody phoNE = RequestBody.create(MediaType.parse("text/plain"), phone);
        RequestBody seX = RequestBody.create(MediaType.parse("text/plain"), sex);

        System.out.println("ProfileActivity.updateProfileApi - - -" + userID);
        System.out.println("ProfileActivity.updateProfileApi - - -" + emailID);
        System.out.println("ProfileActivity.updateProfileApi - - -" + phoNE);
        System.out.println("ProfileActivity.updateProfileApi - - -" + seX);


        compositeDisposable.add(apiService.updateProfile(userID, emailID, phoNE, imagePath == null ? null : prepareFilePart("userpic", imagePath), seX)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProfileUpdateSuccess>() {
                    @Override
                    public void accept(ProfileUpdateSuccess profileUpdateSuccess) throws Exception {


                        if (profileUpdateSuccess.isSuccess) {

                            fpd.dismiss();

//                            showSuccessDialog("Profile Updated");
                            showSuccessDialog(profileUpdateSuccess.message);

                            UserDataUtility utility = new UserDataUtility(context);

                            utility.setUserId(profileUpdateSuccess.payLoad.id);
                            utility.setUserName(profileUpdateSuccess.payLoad.name);
                            utility.setUserEmail(profileUpdateSuccess.payLoad.email);
                            utility.setPhoneNo(profileUpdateSuccess.payLoad.phone);
                            System.out.println("ProfileActivity.accept - - -" + profileUpdateSuccess.payLoad.phone);

                            utility.setSex(profileUpdateSuccess.payLoad.sex);
                            utility.setUserPic(profileUpdateSuccess.payLoad.image);


//                            utility.setUserPic(profileUpdateSuccess.getPayLoad().getUpdatedAt());
//                            utility.setUserPic(profileUpdateSuccess.getPayLoad().getCreatedAt());
//                            utility.setUserPic(profileUpdateSuccess.getPayLoad().getaOrC());


                            sharedPrefsHelper.put(AppConstants.IMAGE_URL, profileUpdateSuccess.payLoad.image);

                            ((AppController) getApplication()).bus().send(new ImageProfileEvent(profileUpdateSuccess.payLoad.image));


                        } else {

                            fpd.dismiss();

                            showAlertDialog("Retry", "Profile Not Updated");

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        fpd.dismiss();
                        compositeDisposable.dispose();
                        throw new RuntimeException("I'm a cool exception and I crashed the main thread!");
                        // showAlertDialog("Retry",throwable.getMessage());


                    }
                }));


    }


    private void onImageViewClick() {


        PickSetup setup = new PickSetup()
                .setTitle("Choose")
                .setTitleColor(Color.BLACK)
                .setBackgroundColor(Color.WHITE)
                .setCancelText("Cancel")
                .setCancelTextColor(Color.BLUE)
                .setButtonTextColor(Color.BLACK)
                .setMaxSize(500)
                .setPickTypes(EPickType.GALLERY, EPickType.CAMERA)
                .setCameraButtonText("Camera")
                .setGalleryButtonText("Gallery")
                .setIconGravity(Gravity.LEFT)
                .setButtonOrientation(LinearLayoutCompat.VERTICAL)
                .setSystemDialog(false)
                .setGalleryIcon(R.drawable.gallerypicker)
                .setCameraIcon(R.drawable.camerapicker)
                .setSystemDialog(false);

        //If you don't have an Activity, you can set the FragmentManager
        PickImageDialog.build(setup).show(this);


    }


    @NonNull
    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        File file = FileUtils.getFile(context, fileUri);

        File compressedImageFile = null;
        try {
            compressedImageFile = new Compressor(context).compressToFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"),
                        compressedImageFile
                );

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, compressedImageFile.getName(), requestFile);
    }


    @Override
    public void onPickResult(PickResult pickResult) {
        if (pickResult.getError() == null) {


            pickResult.getBitmap();
            pickResult.getError();


            imagePath = pickResult.getUri();

            Log.e("RESULT", pickResult.getPath());


            imageProfile.setImageBitmap(pickResult.getBitmap());

            //r.getPath();
        } else {
            //Handle possible errors
            //TODO: do what you have to do with r.getError();
            Toast.makeText(this, pickResult.getError().getMessage(), Toast.LENGTH_LONG).show();
        }


    }
}
