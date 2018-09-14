package com.mahashakti.response.forgetPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgetPassword {


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
