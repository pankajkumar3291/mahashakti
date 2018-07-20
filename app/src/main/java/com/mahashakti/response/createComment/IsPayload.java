package com.mahashakti.response.createComment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IsPayload {

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("userId")
    @Expose
    public String userId;

    @SerializedName("blogId")
    @Expose
    public String blogId;

    @SerializedName("id")
    @Expose
    public Integer id;

}
