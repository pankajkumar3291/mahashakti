package com.mahashakti.response.EventResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dharamveer on 23/1/18.
 */

public class EventSuccess {


//    @SerializedName("Success")
//    private boolean Success;
//    @SerializedName("Error")
//    private boolean Error;
//    @SerializedName("payload")
//    private List<EventPayload> payload;
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
//    public List<EventPayload> getPayload() {
//        return payload;
//    }
//
//    public void setPayload(List<EventPayload> payload) {
//        this.payload = payload;
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
    @SerializedName("payLoad")
    @Expose
    public List<PayLoad> payLoad = null;

}
