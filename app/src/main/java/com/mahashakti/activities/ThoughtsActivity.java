package com.mahashakti.activities;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
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

import com.mahashakti.adapters.AdapterThought;
import com.mahashakti.AppConstants;
import com.mahashakti.R;
import com.mahashakti.response.CreateThought.CreateThoughtSuccess;
import com.mahashakti.response.GetThoughtsResponse.GetAllThoughtPayload;
import com.mahashakti.response.GetThoughtsResponse.GetAllThoughtSuccess;
import com.mahashakti.response.GetThoughtsResponse.PayLoad;
import com.mahashakti.utils.FileUtils;
import com.sdsmdg.tastytoast.TastyToast;
import com.taishi.flipprogressdialog.FlipProgressDialog;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.enums.EPickType;
import com.vansuita.pickimage.listeners.IPickResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.supercharge.shimmerlayout.ShimmerLayout;

import com.mahashakti.baseactivity.BaseActivity;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ThoughtsActivity extends BaseActivity {

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

    @BindView(R.id.thoughtsRelative)
    RelativeLayout thoughtsRelative;

    @BindView(R.id.no_thought_layout)
    RelativeLayout noThoughtLayout;


    private TextView toolbar_title;
    private Uri imagePath;
    private Context context;
    public Toolbar topToolBar;

    private AdapterThought adapterThought;

    ArrayList<PayLoad> getAllThoughtPayloadArrayList = new ArrayList<>();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoughts);

        rootView = findViewById(R.id.rootView);

        context = this;

        topToolBar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);

        setSupportActionBar(topToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar_title.setText("THOUGHTS");


        shimmerLayout.startShimmerAnimation();

        thoughtRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);

        thoughtRecyclerView.setLayoutManager(mLayoutManager);
        thoughtRecyclerView.setItemAnimator(new DefaultItemAnimator());

        GetAllThoughtAPi();

    }


    private void GetAllThoughtAPi() {


        compositeDisposable.add(apiService.getallthought()
                .subscribeOn(io.reactivex.schedulers.Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GetAllThoughtSuccess>() {
                               @Override
                               public void accept(GetAllThoughtSuccess getAllThoughtSuccess) throws Exception {


                                   if (getAllThoughtSuccess.isSuccess) {


                                       getAllThoughtPayloadArrayList = new ArrayList<>(getAllThoughtSuccess.payLoad);

                                       adapterThought = new AdapterThought(ThoughtsActivity.this, getAllThoughtPayloadArrayList);


                                       thoughtRecyclerView.setAdapter(adapterThought);

                                       shimmerLayout.setVisibility(View.GONE);
                                       thoughtRecyclerView.setVisibility(View.VISIBLE);


                                   } else {
                                       shimmerLayout.setVisibility(View.GONE);
                                       noThoughtLayout.setVisibility(View.VISIBLE);

                                   }
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {

                                   //throwable.getMessage();
                                   compositeDisposable.dispose();

                               }
                           }
                ));
    }

    @OnClick({R.id.imageBackaroow, R.id.imageAttachment, R.id.relativeSendChat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageBackaroow:
                finish();
                break;

            case R.id.imageAttachment:


                onImageViewClick();

                break;
            case R.id.relativeSendChat:

                if (edEnterThoughts.getText().toString().isEmpty()) {

                    TastyToast.makeText(getApplicationContext(), "Share your thoughts", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS).show();
                } else {

                    flipProgress();

                    String userid = String.valueOf(sharedPrefsHelper.get(AppConstants.USER_ID, 0));
                    String attachmentPic = (sharedPrefsHelper.get(AppConstants.PROFILE_PIC, ""));



                    System.out.println("ThoughtsActivity.onViewClicked - - " + imagePath);
                    System.out.println("ThoughtsActivity.onViewClicked userIDS " + userid);
                    savingProfile(userid, edEnterThoughts.getText().toString().trim(), imagePath);
                }

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

        RequestBody user = RequestBody.create(MediaType.parse("text/plain"), userId);
        RequestBody thoug = RequestBody.create(MediaType.parse("text/plain"), thought);
        System.out.println("ThoughtsActivity.savingProfile"   + user);
        System.out.println("ThoughtsActivity.savingProfile"   + thoug);

        compositeDisposable.add(apiService.createThought(user, thoug, imagePath == null ? null : prepareFilePart("attachment", imagePath))
                .subscribeOn(io.reactivex.schedulers.Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CreateThoughtSuccess>() {
                    @Override
                    public void accept(CreateThoughtSuccess createThoughtSuccess) throws Exception {

                        if (createThoughtSuccess.isSuccess) {

                            fpd.dismiss();

                            showSuccessDialog("Thoughts Created");

                            edEnterThoughts.setText("");


                        } else {

                            fpd.dismiss();
                            showAlertDialog("retry", "Something went wrong");
                            edEnterThoughts.setText("");
                        }


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        fpd.dismiss();
                        compositeDisposable.dispose();

                        throw new RuntimeException("I'm a cool exception and I crashed the main thread!");


                        //  showAlertDialog("retry","Something went wrong");


                    }
                }));

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
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
    }


}
