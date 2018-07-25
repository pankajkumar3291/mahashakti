package com.mahashakti.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mahashakti.R;
import com.mahashakti.response.GetGallery.PayLoad;
import com.mahashakti.response.GetGallery.Payload;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dharamveer on 2/2/18.
 */

public class CustomGrid extends BaseAdapter {



    private Context mContext;
//    private  ArrayList<PayLoad> payloadGalleryArrayList = new ArrayList<>();
    private  ArrayList<Payload> payloadGalleryArrayList = new ArrayList<>();


    public CustomGrid(Context mContext,ArrayList<Payload> payloadGalleryArrayList) {
        this.mContext = mContext;
        this.payloadGalleryArrayList = payloadGalleryArrayList;

    }

    @Override
    public int getCount() {
        return payloadGalleryArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        PayLoad payloadGallery = payloadGalleryArrayList.get(position);

        Payload payloadGallery = payloadGalleryArrayList.get(position);


        if(convertView ==null){

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item,null);

           // TextView textView = grid.findViewById(R.id.txtGalleryTitle);
            ImageView imageView = grid.findViewById(R.id.grid_item_iv);


           // textView.setText(payloadGallery.getImagedesc());

            /*Picasso.with(mContext)
                    .load("http://mahashaktiradiance.com/" + getYoutubeThumbnailUrlFromVideoUrl(payloadGallery.getVideourl()))
                    .error(R.drawable.user)
                    .into(imageView);*/


            Picasso.with(mContext)
                    .load(getYoutubeThumbnailUrlFromVideoUrl("http://softwareering.com/mahashakti/public/api/api/" +payloadGallery.getVideoPath()))
                    .error(R.drawable.user)
                    .into(imageView);

        }
        else {

            grid = convertView;
        }
        return grid;
    }



    public static String getYoutubeThumbnailUrlFromVideoUrl(String videoUrl) {
        String imgUrl = "http://img.youtube.com/vi/"+getYoutubeVideoIdFromUrl(videoUrl) + "/0.jpg";
        return imgUrl;
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





    public static Bitmap retriveVideoFrameFromVideo(String videoPath)
            throws Throwable
    {
        Bitmap bitmap = null;
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try
        {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 14)
                mediaMetadataRetriever.setDataSource(videoPath, new HashMap<String, String>());
            else
                mediaMetadataRetriever.setDataSource(videoPath);
            //   mediaMetadataRetriever.setDataSource(videoPath);
            bitmap = mediaMetadataRetriever.getFrameAtTime();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Throwable(
                    "Exception in retriveVideoFrameFromVideo(String videoPath)"
                            + e.getMessage());

        }
        finally
        {
            if (mediaMetadataRetriever != null)
            {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }



}
