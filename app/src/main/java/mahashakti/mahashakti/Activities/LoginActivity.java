package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.Login;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;
import com.taishi.flipprogressdialog.FlipProgressDialog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mahashakti.mahashakti.BaseActivity.BaseActivity;
import mahashakti.mahashakti.Hawk.HawkUserUtility;
import com.mahashakti.R;
import com.mahashakti.Response.LoginUserResponse.LoginUserSuccess;
import com.mahashakti.RetrofitLibrary.RestClient1;
import mahashakti.mahashakti.SharedPreferences.UserDataUtility;
import mahashakti.mahashakti.UserProfile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginActivity extends BaseActivity {


    @BindView(R.id.imgBack)
    ImageView imgBack;
    @BindView(R.id.edPsw)
    EditText edPsw;
    @BindView(R.id.tvForgetPsw)
    TextView tvForgetPsw;
    @BindView(R.id.btnSignIn)
    Button btnSignIn;
    @BindView(R.id.login_button)
    LoginButton loginButton;
    @BindView(R.id.edEmailId)
    EditText edEmailId;
    private CallbackManager callbackManager;


    private String emailId,password;
    private Context context;
    private FlipProgressDialog fpd;
    private NoInternetDialog noInternetDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        context =this;
        Hawk.init(context).build();


        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("email");

        noInternetDialog = new NoInternetDialog.Builder(context).build();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getUserDetails(loginResult);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }

    @OnClick({R.id.imgBack, R.id.tvForgetPsw, R.id.btnSignIn, R.id.login_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgBack:

                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

                break;
            case R.id.tvForgetPsw:

                startActivity(new Intent(context, ForgetPasswordActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);

                break;
            case R.id.btnSignIn:

                flipProgress();

                emailId = edEmailId.getText().toString().trim();
                password = edPsw.getText().toString().trim();

                loginUserApi();


                break;
            case R.id.login_button:


                break;
        }
    }


    public void showSuccessDialog(){

        new AwesomeSuccessDialog(this)
                .setTitle("Login")
                .setMessage("Successfully")
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

    private void loginUserApi() {


        if(edEmailId.getText().toString().length()==0){
            fpd.dismiss();
            edEmailId.setError("Email required");
        }
        else if(edPsw.getText().toString().length()==0){
            fpd.dismiss();
            edPsw.setError("Password required");
        }
        else {
            HashMap<String, String> stringStringHashMap = new HashMap<>();

            stringStringHashMap.put("email", emailId);
            stringStringHashMap.put("password", password);

            final RestClient1.GitApiInterface restClient = RestClient1.getClient();

            restClient.loginUser(stringStringHashMap).enqueue(new Callback<LoginUserSuccess>() {
                @Override
                public void onResponse(Call<LoginUserSuccess> call, Response<LoginUserSuccess> response) {


                    if(response.isSuccessful()) {


                        if (response.body().getSuccess()) {


                            fpd.dismiss();

                            showSuccessDialog();

                            HawkUserUtility hawkUserUtility = new HawkUserUtility(context);

                            hawkUserUtility.setUserId(response.body().getPayload().getId());
                            hawkUserUtility.setUserName(response.body().getPayload().getName());
                            hawkUserUtility.setUserEmail(response.body().getPayload().getEmail());
                            hawkUserUtility.setPhoneNo(response.body().getPayload().getPhone());
                            hawkUserUtility.setSex(response.body().getPayload().getSex());
                            hawkUserUtility.setUserPic(response.body().getPayload().getUserpic());


                            // hawkUserUtility.setUserPic(response.body().getPayload().getUserpic());

                            startActivity(new Intent(context, DashboardActivity.class));
                            UserDataUtility.setLogin(true, context);
                            finish();
                            overridePendingTransition(R.anim.enter, R.anim.exit);


                        } else {

                            fpd.dismiss();

                            AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginActivity.this);
                            builder1.setMessage("Email or password may be wrong.");
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


                    }  else{

                            // error case
                            switch (response.code()) {
                                case 404:
                                    Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show();
                                    break;
                                case 500:
                                    Toast.makeText(context, "server broken", Toast.LENGTH_SHORT).show();
                                    break;
                                default:
                                    Toast.makeText(context, "unknown error", Toast.LENGTH_SHORT).show();
                                    break;
                            }


                        }




                }

                @Override
                public void onFailure(Call<LoginUserSuccess> call, Throwable t) {

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
    }

    protected void getUserDetails(LoginResult loginResult) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject json_object, GraphResponse response)
                    {

                        showSuccessDialog();

                        Intent intent = new Intent(LoginActivity.this, UserProfile.class);
                        intent.putExtra("userProfile", json_object.toString());
                        startActivity(intent);


                    }

                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id,name,email,picture.width(120).height(120)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();

    }

    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
