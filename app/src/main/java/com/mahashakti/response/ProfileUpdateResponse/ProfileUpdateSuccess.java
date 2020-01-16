package com.mahashakti.response.ProfileUpdateResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dharamveer on 19/1/18.
 */

public class ProfileUpdateSuccess {

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
