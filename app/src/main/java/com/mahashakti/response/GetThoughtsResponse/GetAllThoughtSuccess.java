package com.mahashakti.response.GetThoughtsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dharamveer on 19/1/18.
 */

public class GetAllThoughtSuccess {


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


//    @Expose
//    @SerializedName("payload")
//    private List<GetAllThoughtPayload> payload ;
//
//    @Expose
//    @SerializedName("Error")
//    private boolean Error;
//
//    @Expose
//    @SerializedName("Success")
//    private boolean Success;
//
//    // setter and getter
//
//    public List<GetAllThoughtPayload> getPayload() {
//        return payload;
//    }
//
//    public void setPayload(List<GetAllThoughtPayload> payload) {
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
