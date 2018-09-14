package com.mahashakti.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import com.mahashakti.AppConstants;
import com.mahashakti.R;
import com.mahashakti.adapters.CustomGrid;
import com.mahashakti.baseactivity.BaseActivity;
import com.mahashakti.response.GetGallery.GetGallerySuccess;
import com.mahashakti.response.GetGallery.PayLoad;
import com.mahashakti.response.GetGallery.Payload;

public class GalleryActivity extends BaseActivity {


    public Toolbar topToolBar;
    @BindView(R.id.imageBackaroow)
    RelativeLayout imageBackaroow;
    @BindView(R.id.grid)
    GridView grid;
    private TextView toolbar_title;

//    private ArrayList<PayLoad> payloadGalleryArrayList;
    private ArrayList<Payload> payloadGalleryArrayList;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Context context;

    CustomGrid adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        topToolBar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);

        context = this;

        setSupportActionBar(topToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar_title.setText("VIDEO");


        compositeDisposable.add(apiService.getgalleryitems()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GetGallerySuccess>() {

                    @Override
                    public void accept(GetGallerySuccess getGallerySuccess) throws Exception {

                        if (getGallerySuccess.isSuccess) {

                            payloadGalleryArrayList = new ArrayList<>(getGallerySuccess.getPayload());

                            adapter = new CustomGrid(context, payloadGalleryArrayList);
                            grid.setAdapter(adapter);


                            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    String videoURl = payloadGalleryArrayList.get(position).getVideoPath();

//                                    String videoTitle = payloadGalleryArrayList.get(position).d;
                                    String imageTitle = payloadGalleryArrayList.get(position).getDescription();
                                    String plainText = Html.fromHtml(imageTitle).toString();
//                                    String imageurl = payloadGalleryArrayList.get(position).getImage();

                                    sharedPrefsHelper.put(AppConstants.VIDEO_URL, videoURl);
//                                    sharedPrefsHelper.put(AppConstants.VIDEO_TITLE, videoTitle);
                                    sharedPrefsHelper.put(AppConstants.IMAGE_TITLE, plainText);
//                                    sharedPrefsHelper.put(AppConstants.IMAGE_URL, imageurl);

                                    startActivity(new Intent(context, GalleryDetailActivity.class));


                                }
                            });

                        } else {


                            showAlertDialog("Retry", "Success false");
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        compositeDisposable.dispose();
                        throw new RuntimeException("I'm a cool exception and I crashed the main thread!");

                        // showAlertDialog("Retry",throwable.getMessage());
                    }
                }));


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }


    @OnClick(R.id.imageBackaroow)
    public void onViewClicked() {

        finish();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }


}
