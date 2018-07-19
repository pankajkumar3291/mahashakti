package com.mahashakti.response.LoginUserResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dharamveer on 17/1/18.
 */

public class LoginUserSuccess {


//    @SerializedName("isSuccess")
//    private boolean isSuccess;
//
//    @SerializedName("isError")
//    private boolean isError;
//
//    @SerializedName("message")
//    @Expose
//    public String message;
//
//    public PayLoad getPayLoad() {
//        return payLoad;
//    }
//
//    public void setPayLoad(PayLoad payLoad) {
//        this.payLoad = payLoad;
//    }
//
//    @SerializedName("payLoad")
//    @Expose
//    public PayLoad payLoad;
//
//    public boolean isSuccess() {
//        return isSuccess;
//    }
//
//    public void setSuccess(boolean success) {
//        isSuccess = success;
//    }
//
//    public boolean isError() {
//        return isError;
//    }
//
//    public boolean getError() {
//        return isError;
//    }
//
//    public void setError(boolean Error) {
//        this.isError = Error;
//    }
//
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

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
