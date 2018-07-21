package com.mahashakti.response.displayingUserChat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Payload implements Serializable{

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("adminId")
    @Expose
    public Integer adminId;

    @SerializedName("userId")
    @Expose
    public Integer userId;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("role")
    @Expose
    public String role;

    @SerializedName("created_at")
    @Expose
    public String createdAt;

    @SerializedName("updated_at")
    @Expose
    public String updatedAt;


}
