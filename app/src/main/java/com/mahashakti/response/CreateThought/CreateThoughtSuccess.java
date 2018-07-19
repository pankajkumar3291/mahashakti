package com.mahashakti.response.CreateThought;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dharamveer on 18/1/18.
 */

public class CreateThoughtSuccess {


//    @SerializedName("Success")
//    private boolean Success;
//
//    @SerializedName("Error")
//    private boolean Error;
//
//    @SerializedName("message")
//    private String message;
//
//    public boolean getSuccess() {
//        return Success;
//    }
//
//    public void setSuccess(boolean Success) {
//        this.Success = Success;
//    }
//
//    public boolean getError() {
//        return Error;
//    }
//
//    public void setError(boolean Error) {
//        this.Error = Error;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }


//    @SerializedName("isSuccess")
//    @Expose
//    public Boolean isSuccess;
//
//    @SerializedName("isError")
//    @Expose
//    public Boolean isError;
//
//    @SerializedName("message")
//    @Expose
//    public String message;
//
//    @SerializedName("payLoad")
//    @Expose
//    public PayLoad payLoad;
//
//    public Boolean getSuccess() {
//        return isSuccess;
//    }
//
//    public void setSuccess(Boolean success) {
//        isSuccess = success;
//    }
//
//    public Boolean getError() {
//        return isError;
//    }
//
//    public void setError(Boolean error) {
//        isError = error;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public PayLoad getPayLoad() {
//        return payLoad;
//    }
//
//    public void setPayLoad(PayLoad payLoad) {
//        this.payLoad = payLoad;
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
