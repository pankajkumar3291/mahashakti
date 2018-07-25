package com.mahashakti.response.userInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserInfo implements Serializable{

    @SerializedName("isSuccess")
    @Expose
    public Boolean isSuccess;

    @SerializedName("isError")
    @Expose
    public Boolean isError;

    @SerializedName("message")
    @Expose
    public String message;

    // we are putting alternate here to capture or to take the other feilds as an alternative of corresponding value
    @SerializedName(value="payLoad ", alternate={"payLoad", "payload"})
    @Expose
    public PayLoad payLoad;


}
