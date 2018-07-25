package mahashakti.mahashakti.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
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
import io.supercharge.shimmerlayout.ShimmerLayout;
import mahashakti.mahashakti.Adapters.AdapterThought;
import com.mahashakti.R;
import com.mahashakti.Response.CreateThought.CreateThoughtSuccess;
import com.mahashakti.Response.GetThoughtsResponse.GetAllThoughtPayload;
import com.mahashakti.Response.GetThoughtsResponse.GetAllThoughtSuccess;
import com.mahashakti.RetrofitLibrary.RestClient1;
import mahashakti.mahashakti.SharedPreferences.UserDataUtility;
import mahashakti.mahashakti.Utils.FileUtils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThoughtsActivity extends AppCompatActivity {

    public Toolbar topToolBar;
    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.thoughtRecyclerView)
    RecyclerView thoughtRecyclerView;
    @BindView(R.id.imageAttachment)
    ImageView imageAttachment;
    @BindView(R.id.relativeSendChat)
    RelativeLayout relativeSendChat;
    @BindView(R.id.linearBottom)
    LinearLayout linearBottom;


    @BindView(R.id.edEnterThoughts)
    EditText edEnterThoughts;
    @BindView(R.id.rootView)
    RelativeLayout rootView;
    @BindView(R.id.imageSelect)
    CircleImageView imageSelect;
    @BindView(R.id.shimmer_layout)
    ShimmerLayout shimmerLayout;

    FlipProgressDialog fpd;
    @BindView(R.id.thoughtsRelative)
    RelativeLayout thoughtsRelative;
    @BindView(R.id.no_thought_layout)
    RelativeLayout noThoughtLayout;


    private TextView toolbar_title;

    private AdapterThought adapterThought;
    ArrayList<GetAllThoughtPayload> getAllThoughtPayloadArrayList = new ArrayList<>();

    private Uri imagePath;

    private Context context;

    NoInternetDialog noInternetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoughts);
        ButterKnife.bind(this);

        rootView = findViewById(R.id.rootView);

        context = this;

        topToolBar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);

        setSupportActionBar(topToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar_title.setText("THOUGHTS");

        noInternetDialog = new NoInternetDialog.Builder(context).build();

        //blankSpace = new BlankSpace(getBaseContext(), R.layout.layout_no_comment);

        shimmerLayout.startShimmerAnimation();

        GetAllThoughtAPi();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        noInternetDialog.onDestroy();
    }


    public void showSuccessDialog() {

        new AwesomeSuccessDialog(this)
                .setTitle("Thought")
                .setMessage("Created Successfully")
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

    public void flipProgress() {

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


        fpd.show(getFragmentManager(), "");                        // Show flip-progress-dialg


    }


    private void GetAllThoughtAPi() {


        final RestClient1.GitApiInterface restClient = RestClient1.getClient();


        restClient.getallthought().enqueue(new Callback<GetAllThoughtSuccess>() {
            @Override
            public void onResponse(Call<GetAllThoughtSuccess> call, Response<GetAllThoughtSuccess> response) {

                if(response.isSuccessful()) {


                    if (response.body().getSuccess()) {


                        getAllThoughtPayloadArrayList = new ArrayList<>(response.body().getPayload());


                        adapterThought = new AdapterThought(ThoughtsActivity.this, getAllThoughtPayloadArrayList);

                        thoughtRecyclerView.setHasFixedSize(true);

                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);

                        thoughtRecyclerView.setLayoutManager(mLayoutManager);
                        thoughtRecyclerView.setItemAnimator(new DefaultItemAnimator());

                        thoughtRecyclerView.setAdapter(adapterThought);

                        shimmerLayout.setVisibility(View.GONE);
                        thoughtRecyclerView.setVisibility(View.VISIBLE);


                    } else {

                        shimmerLayout.setVisibility(View.GONE);
                        noThoughtLayout.setVisibility(View.VISIBLE);

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
            public void onFailure(Call<GetAllThoughtSuccess> call, Throwable t) {


                noInternetDialog.show();


            }
        });

    }



    @OnClick({R.id.imageBackaroow, R.id.imageAttachment, R.id.relativeSendChat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageBackaroow:
                finish();
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                break;

            case R.id.imageAttachment:


                onImageViewClick();

                break;
            case R.id.relativeSendChat:

                flipProgress();

                UserDataUtility utility = new UserDataUtility(context);


                savingProfile(String.valueOf(utility.getUserId()), edEnterThoughts.getText().toString().trim(), imagePath);


                break;
        }
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
        PickImageDialog.build(setup, new IPickResult() {
            @Override
            public void onPickResult(PickResult r) {


                Log.e("RESULT", r.getPath());
                if (r.getError() == null) {

                    r.getBitmap();
                    r.getError();


                    imagePath = r.getUri();

                    Log.e("RESULT", r.getPath());
                    //If you want the Bitmap.
                    imageSelect.setImageBitmap(r.getBitmap());

                } else {
                    //Handle possible errors
                    Toast.makeText(context, r.getError().getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }).show(getSupportFragmentManager());

    }


    void savingProfile(String userId, String thought, Uri imagePath) {

        final RestClient1.GitApiInterface restClient = RestClient1.getClient();

        RequestBody user = RequestBody.create(MediaType.parse("text/plain"), userId);
        RequestBody thoug = RequestBody.create(MediaType.parse("text/plain"), thought);


        restClient.createThought(user, thoug, imagePath == null ? null : prepareFilePart("attachment", imagePath)).enqueue(new Callback<CreateThoughtSuccess>() {
            @Override
            public void onResponse(Call<CreateThoughtSuccess> call, Response<CreateThoughtSuccess> response) {


                if(response.isSuccessful()) {


                    if (response.body().getSuccess()) {

                        fpd.dismiss();

                        showSuccessDialog();

                        edEnterThoughts.setText("");


                    } else {

                        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                        builder1.setMessage("thought not created successfully");
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
            public void onFailure(Call<CreateThoughtSuccess> call, Throwable t) {
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
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);

    }


}
