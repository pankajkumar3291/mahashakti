package com.mahashakti.response.GetGallery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayloadGallery {

    @Expose
    @SerializedName("updated_at")
    private String updated_at;

    @Expose
    @SerializedName("created_at")
    private String created_at;

    @Expose
    @SerializedName("approved")
    private String approved;

    @Expose
    @SerializedName("imagedesc")
    private String imagedesc;

    @Expose
    @SerializedName("image")
    private String image;

    @Expose
    @SerializedName("videodesc")
    private String videodesc;

    @Expose
    @SerializedName("videourl")
    private String videourl;

    @Expose
    @SerializedName("user_id")
    private String user_id;

    @Expose
    @SerializedName("id")
    private int id;

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getImagedesc() {
        return imagedesc;
    }

    public void setImagedesc(String imagedesc) {
        this.imagedesc = imagedesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideodesc() {
        return videodesc;
    }

    public void setVideodesc(String videodesc) {
        this.videodesc = videodesc;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
