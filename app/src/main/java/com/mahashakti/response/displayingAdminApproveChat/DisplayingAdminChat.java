package com.mahashakti.response.displayingAdminApproveChat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisplayingAdminChat {

    @SerializedName("isSuccess")
    @Expose
    public Boolean isSuccess;

    @SerializedName("isError")
    @Expose
    public Boolean isError;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("payload")
    @Expose
    public Payload payload;

}
