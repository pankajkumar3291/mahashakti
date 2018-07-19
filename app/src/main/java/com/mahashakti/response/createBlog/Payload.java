package com.mahashakti.response.createBlog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {


    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("userId")
    @Expose
    public Integer userId;

    @SerializedName("imageId")
    @Expose
    public Integer imageId;

    @SerializedName("catagoryId")
    @Expose
    public Integer catagoryId;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("slug")
    @Expose
    public String slug;

    @SerializedName("created_at")
    @Expose
    public String createdAt;

    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    @SerializedName("imagePath")
    @Expose
    public String imagePath;


}
