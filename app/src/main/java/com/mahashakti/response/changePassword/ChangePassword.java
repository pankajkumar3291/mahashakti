package com.mahashakti.response.changePassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangePassword {

    @SerializedName("isSuccess")
    @Expose
    public Boolean isSuccess;

    @SerializedName("isError")
    @Expose
    public Boolean isError;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("payLoad")
    @Expose
    public PayLoad payLoad;

}
