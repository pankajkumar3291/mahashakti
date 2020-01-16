package com.mahashakti.response.ProfileUpdateResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayLoad {

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("phone")
    @Expose
    public String phone;

    @SerializedName("sex")
    @Expose
    public String sex;

    @SerializedName("image")
    @Expose
    public String image;

}
