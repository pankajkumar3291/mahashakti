package com.mahashakti.response.GetGallery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {


    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("videoId")
    @Expose
    public Integer videoId;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("videoPath")
    @Expose
    public String videoPath;

    public Integer getId() {
        return id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoPath() {
        return videoPath;
    }




}
