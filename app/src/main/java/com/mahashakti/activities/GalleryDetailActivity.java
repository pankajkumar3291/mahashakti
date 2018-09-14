package com.mahashakti.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mahashakti.AppConstants;
import com.mahashakti.R;
import com.mahashakti.baseactivity.BaseActivity;
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GalleryDetailActivity extends BaseActivity {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.youtube_player_view)
    YouTubePlayerView youTubePlayerView;


    Context context;

    @BindView(R.id.txtVideoTitle)
    TextView txtVideoTitle;

    @BindView(R.id.txtImageTitle)
    TextView txtImageTitle;

    @BindView(R.id.imageGallery)
    ImageView imageGallery;


    private RelativeLayout imageBackaroow;


    private @Nullable
    YouTubePlayer initializedYouTubePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        ButterKnife.bind(this);

        context = this;

        this.getLifecycle().addObserver(youTubePlayerView);

        imageBackaroow = findViewById(R.id.imageBackaroow);
        imageBackaroow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });


        txtVideoTitle.setText("Video:- " + sharedPrefsHelper.get(AppConstants.VIDEO_TITLE, ""));
        txtImageTitle.setText(sharedPrefsHelper.get(AppConstants.IMAGE_TITLE, ""));


//        Picasso.with(context)
//                .load("http://softwareering.com/mahashakti/public/api/api/" + sharedPrefsHelper.get(AppConstants.IMAGE_URL, "")) // .load("http://mahashaktiradiance.com/" + sharedPrefsHelper.get(AppConstants.IMAGE_URL, ""))
//                .error(R.drawable.user)
//                .into(imageGallery);


        youTubePlayerView.initialize(initializedYouTubePlayer -> {

            initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady() {
                    GalleryDetailActivity.this.initializedYouTubePlayer = initializedYouTubePlayer;

                    String videoId = getYoutubeVideoIdFromUrl(sharedPrefsHelper.get(AppConstants.VIDEO_URL, ""));

                    initializedYouTubePlayer.loadVideo(videoId, 0);
                }
            });

        }, true);

    }


    public static String getYoutubeVideoIdFromUrl(String inUrl) {
        if (inUrl.toLowerCase().contains("youtu.be")) {
            return inUrl.substring(inUrl.lastIndexOf("/") + 1);
        }
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(inUrl);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }


    @Override
    public void onPause() {
        super.onPause();
        if (initializedYouTubePlayer != null)
            initializedYouTubePlayer.pause();
    }

    @Override
    public void onBackPressed() {
        if (youTubePlayerView.isFullScreen())
            youTubePlayerView.exitFullScreen();
        else
            super.onBackPressed();
    }


}
