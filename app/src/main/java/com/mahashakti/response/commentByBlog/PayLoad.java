package com.mahashakti.response.commentByBlog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PayLoad implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("userId")
    @Expose
    public Integer userId;

    @SerializedName("blogId")
    @Expose
    public Integer blogId;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("blogTitle")
    @Expose
    public String blogTitle;

    @SerializedName("userName")
    @Expose
    public String userName;


}
