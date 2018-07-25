package mahashakti.mahashakti.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.taishi.flipprogressdialog.FlipProgressDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import am.appwise.components.ni.NoInternetDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mahashakti.R;
import com.mahashakti.Response.CreateUserSuccess.CreateUserSuccess;
import com.mahashakti.RetrofitLibrary.RestClient1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.imageBack)
    ImageView imageBack;
    @BindView(R.id.edUserName)
    EditText edUserName;
    @BindView(R.id.edEmail)
    EditText edEmail;
    @BindView(R.id.edPsword)
    EditText edPsword;
    @BindView(R.id.edConfirmPsw)
    EditText edConfirmPsw;
    @BindView(R.id.btnSignup)
    Button btnSignup;
    @BindView(R.id.tvSignIn)
    TextView tvSignIn;

    private String fullname,emailid,password;
    private Context context;

    FlipProgressDialog fpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);


        context = this;

        NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(context).build();
    }



    public void showSuccessDialog(){

        new AwesomeSuccessDialog(this)
                .setTitle("You")
                .setMessage("Register Successfully")
                .setColoredCircle(R.color.signinbtncolor)
                .setDialogIconAndColor(R.drawable.checkwhite, R.color.white)
                .setCancelable(true)
                .setPositiveButtonText("OK")
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


    @OnClick({R.id.imageBack, R.id.btnSignup, R.id.tvSignIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageBack:

                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);


                break;
            case R.id.btnSignup:


                flipProgress();

                fullname = edUserName.getText().toString().trim();
                emailid = edEmail.getText().toString().trim();
                password = edPsword.getText().toString().trim();

                createUserApi();


                break;
            case R.id.tvSignIn:

                startActivity(new Intent(context,LoginActivity.class));
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

                break;
        }
    }

    private void createUserApi() {


        if(edUserName.getText().toString().length()==0){
            edUserName.setError("Enter Full Name");
        }
        else if(edEmail.getText().toString().length()==0){
            edEmail.setError("Enter Email");

        }
        else if(edPsword.getText().toString().length()==0){
            edPsword.setError("Enter Password");

        }
        else if(edConfirmPsw.getText().toString().length()==0){
            edConfirmPsw.setError("Enter Confirm Password ");

        }
        else if(!edPsword.getText().toString().equals(edConfirmPsw.getText().toString())) {
            Toast.makeText(context,"Password Not matching", Toast.LENGTH_SHORT).show();

        }

        else {

            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("email", emailid);
            stringStringHashMap.put("fullname", fullname);
            stringStringHashMap.put("password", password);

            final RestClient1.GitApiInterface restClient = RestClient1.getClient();


            restClient.createUser(stringStringHashMap).enqueue(new Callback<CreateUserSuccess>() {
                @Override
                public void onResponse(Call<CreateUserSuccess> call, Response<CreateUserSuccess> response) {


                    if(response.isSuccessful()) {


                        if (response.body().getSuccess()) {


                            fpd.dismiss();
                            showSuccessDialog();

                            startActivity(new Intent(context, LoginActivity.class));
                            overridePendingTransition(R.anim.enter, R.anim.exit);


                        } else {

                            AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                            builder1.setMessage("This email already exist, please login");
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
                public void onFailure(Call<CreateUserSuccess> call, Throwable t) {

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


}
