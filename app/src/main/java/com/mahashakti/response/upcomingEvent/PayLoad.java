package com.mahashakti.response.upcomingEvent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayLoad {

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("imageId")
    @Expose
    public Integer imageId;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("location")
    @Expose
    public String location;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("price")
    @Expose
    public String price;

    @SerializedName("startDate")
    @Expose
    public String startDate;

    @SerializedName("startTime")
    @Expose
    public String startTime;

    @SerializedName("endDate")
    @Expose
    public String endDate;

    @SerializedName("endTime")
    @Expose
    public String endTime;

    @SerializedName("totalSeat")
    @Expose
    public Integer totalSeat;

    @SerializedName("eventShow")
    @Expose
    public Integer eventShow;

    @SerializedName("imagePath")
    @Expose
    public String imagePath;


}
