package com.mahashakti.response.displayingAdminApproveChat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Payload implements Serializable {


    @SerializedName("userId")
    @Expose
    public String userId;

    @SerializedName("adminId")
    @Expose
    public Integer adminId;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("role")
    @Expose
    public String role;

    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

    @SerializedName("created_at")
    @Expose
    public String createdAt;

    @SerializedName("id")
    @Expose
    public Integer id;

}
