package com.mahashakti.response.GetGallery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dharamveer on 2/2/18.
 */

public class GetGallerySuccess {

//    @Expose
//    @SerializedName("payload")
//    private List<PayloadGallery> payload;
//    @Expose
//    @SerializedName("Error")
//    private boolean Error;
//    @Expose
//    @SerializedName("Success")
//    private boolean Success;
//
//    public List<PayloadGallery> getPayload() {
//        return payload;
//    }
//
//    public void setPayload(List<PayloadGallery> payload) {
//        this.payload = payload;
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
//    public boolean getSuccess() {
//        return Success;
//    }
//
//    public void setSuccess(boolean Success) {
//        this.Success = Success;
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
//    public List<PayLoad> payLoad = null;
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
//    public List<PayLoad> getPayLoad() {
//        return payLoad;
//    }
//
//    public void setPayLoad(List<PayLoad> payLoad) {
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

    @SerializedName("payload")
    @Expose
    public List<Payload> payload = null;


    public Boolean getSuccess() {
        return isSuccess;
    }

    public Boolean getError() {
        return isError;
    }

    public String getMessage() {
        return message;
    }

    public List<Payload> getPayload() {
        return payload;
    }


}
