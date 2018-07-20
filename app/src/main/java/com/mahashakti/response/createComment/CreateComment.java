package com.mahashakti.response.createComment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateComment {


    @SerializedName("isSuccess")
    @Expose
    public Boolean isSuccess;

    @SerializedName("isError")
    @Expose
    public Boolean isError;

    @SerializedName("isMessage")
    @Expose
    public String isMessage;

    @SerializedName("isPayload")
    @Expose
    public IsPayload isPayload;



}
