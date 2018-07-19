package com.mahashakti.response.createParticularServiceInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PayLoad implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("serviceId")
    @Expose
    public Integer serviceId;

    @SerializedName("imageId")
    @Expose
    public Integer imageId;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("contents")
    @Expose
    public String contents;

    @SerializedName("imagePath")
    @Expose
    public String imagePath;

}
