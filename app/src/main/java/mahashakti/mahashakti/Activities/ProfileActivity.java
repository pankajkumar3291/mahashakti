package mahashakti.mahashakti.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.LinearLayout.LayoutParams;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeInfoDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;
import com.taishi.flipprogressdialog.FlipProgressDialog;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.enums.EPickType;
import com.vansuita.pickimage.listeners.IPickResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;
import mahashakti.mahashakti.Hawk.HawkUserUtility;
import com.mahashakti.R;
import com.mahashakti.Response.ProfileUpdateResponse.ProfileUpdateSuccess;
import com.mahashakti.RetrofitLibrary.RestClient1;
import mahashakti.mahashakti.SharedPreferences.UserDataUtility;
import mahashakti.mahashakti.Utils.FileUtils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity implements IPickResult {


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
    private static final int CAMERA_REQUEST = 1888;
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
    private String userId, email, fullname, phone, sex;

    private Uri imagePath;

    FlipProgressDialog fpd;
    NoInternetDialog noInternetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);


        context = this;
        Hawk.init(context).build();


        noInternetDialog = new NoInternetDialog.Builder(context).build();
        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle.setText("PROFILE");

        //UserDataUtility userDataUtility = new UserDataUtility(context);
        HawkUserUtility hawkUserUtility = new HawkUserUtility(context);

        String fullname = hawkUserUtility.getUserName();
        String emailId = hawkUserUtility.getUserEmail();
        String phoneNo = hawkUserUtility.getPhoneNo();
        String sex = hawkUserUtility.getSex();
        String userPic = hawkUserUtility.getUserPic();

        edUserNameProfile.setText(fullname);
        edEmailAddressProfile.setText(emailId);
        edPhoneNumber.setText(phoneNo);


        Picasso.with(context)
                .load("http://mahashaktiradiance.com/" + userPic)
                .error(R.drawable.user)
                .into(imageProfile);
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
        noInternetDialog.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }



    @OnClick({R.id.imageBackaroow, R.id.imageCamera, R.id.txtUpdate})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.imageBackaroow:


                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

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


                //UserDataUtility userDataUtility = new UserDataUtility(context);
                HawkUserUtility hawkUserUtility = new HawkUserUtility(context);


                userId = String.valueOf(hawkUserUtility.getUserId());
                email = edEmailAddressProfile.getText().toString();
                phone = edPhoneNumber.getText().toString().trim();
                sex = String.valueOf(radioSexButton.getText());


                updateProfileApi(userId, email, phone, sex, imagePath);



                break;

        }
    }


    public void showSuccessDialog(){

        new AwesomeSuccessDialog(this)
                .setTitle("Profile")
                .setMessage("updated successfully")
                .setColoredCircle(R.color.signinbtncolor)
                .setDialogIconAndColor(R.drawable.checkwhite, R.color.white)
                .setCancelable(true)
                .setPositiveButtonText(getString(R.string.dialog_yes_button))
                .setPositiveButtonbackgroundColor(R.color.signinbtncolor)
                .setPositiveButtonTextColor(R.color.white)
                .setPositiveButtonClick(new Closure() {
                    @Override
                    public void exec() {


                    }
                }).show();

    }


    public void flipProgress(){

        // Set imageList
        List<Integer> imageList = new ArrayList<Integer>();
        imageList.add(R.drawable.loader);


        fpd = new FlipProgressDialog();

        fpd.setImageList(imageList);                              // *Set a imageList* [Have to. Transparent background png recommended]
        fpd.setCanceledOnTouchOutside(true);                      // If true, the dialog will be dismissed when user touch outside of the dialog. If false, the dialog won't be dismissed.
        fpd.setDimAmount(0.0f);                                   // Set a dim (How much dark outside of dialog)

        // About dialog shape, color
        fpd.setBackgroundColor(Color.parseColor("#e0e0e0"));      // Set a background color of dialog
        fpd.setBackgroundAlpha(0.2f);                             // Set a alpha color of dialog
        fpd.setBorderStroke(0);                                   // Set a width of border stroke of dialog
        fpd.setBorderColor(-1);                                   // Set a border stroke color of dialog
        fpd.setCornerRadius(16);                                  // Set a corner radius

        // About image
        fpd.setImageSize(200);                                    // Set an image size
        fpd.setImageMargin(10);                                   // Set a margin of image

        // About rotation
        fpd.setOrientation("rotationY");                          // Set a flipping rotation
        fpd.setDuration(600);                                     // Set a duration time of flipping ratation
        fpd.setStartAngle(0.0f);                                  // Set an angle when flipping ratation start
        fpd.setEndAngle(180.0f);                                  // Set an angle when flipping ratation end
        fpd.setMinAlpha(0.0f);                                    // Set an alpha when flipping ratation start and end
        fpd.setMaxAlpha(1.0f);                                    // Set an alpha while image is flipping


        fpd.show(getFragmentManager(),"");                        // Show flip-progress-dialg


    }




    private void updateProfileApi(String userId, String email, String phone, String sex, Uri imagePath) {

        final RestClient1.GitApiInterface restClient = RestClient1.getClient();

        RequestBody userID = RequestBody.create(MediaType.parse("text/plain"), userId);
        RequestBody emailID = RequestBody.create(MediaType.parse("text/plain"), email);
        RequestBody phoNE = RequestBody.create(MediaType.parse("text/plain"), phone);
        RequestBody seX = RequestBody.create(MediaType.parse("text/plain"), sex);



        restClient.updateProfile(userID, emailID, phoNE, imagePath == null ? null : prepareFilePart("userpic", imagePath), seX).enqueue(new Callback<ProfileUpdateSuccess>() {
            @Override
            public void onResponse(Call<ProfileUpdateSuccess> call, Response<ProfileUpdateSuccess> response) {


                if(response.isSuccessful()) {



                    if (response.body().getSuccess()) {


                        fpd.dismiss();

                        showSuccessDialog();

                        UserDataUtility utility = new UserDataUtility(context);

                        utility.setUserId(response.body().getPayload().getId());
                        utility.setUserName(response.body().getPayload().getName());
                        utility.setUserEmail(response.body().getPayload().getEmail());
                        utility.setPhoneNo(response.body().getPayload().getPhone());
                        utility.setSex(response.body().getPayload().getSex());
                        utility.setUserPic(response.body().getPayload().getUserpic());



                        HawkUserUtility hawkUserUtility = new HawkUserUtility(context);

                        hawkUserUtility.setUserPic(response.body().getPayload().getUserpic());


                        // Hawk.put("userpic",response.body().getPayload().getUserpic());


                    } else {

                        fpd.dismiss();
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setMessage("Not");
                        builder1.setCancelable(true);

                        builder1.setPositiveButton(
                                "Retry",


                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                });


                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }


                }
                else {

                    // error case
                    switch (response.code()) {
                        case 404:
                            fpd.dismiss();
                            Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            fpd.dismiss();
                            Toast.makeText(context, "server broken", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            fpd.dismiss();
                            Toast.makeText(context, "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }


                }




            }

            @Override
            public void onFailure(Call<ProfileUpdateSuccess> call, Throwable t) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setMessage(t.getMessage());
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

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
