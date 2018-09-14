package com.mahashakti.response.EventResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PayLoad implements Serializable{


//    @SerializedName("id")
//    @Expose
//    public Integer id;
//
//    @SerializedName("eventname")
//    @Expose
//    public String eventname;
//
//    @SerializedName("eventlocation")
//    @Expose
//    public String eventlocation;
//
//    @SerializedName("eventcreator")
//    @Expose
//    public Integer eventcreator;
//
//    @SerializedName("eventdesc")
//    @Expose
//    public String eventdesc;
//
//    @SerializedName("eventpriceperperson")
//    @Expose
//    public Integer eventpriceperperson;
//
//    @SerializedName("eventstartdate")
//    @Expose
//    public String eventstartdate;
//
//    @SerializedName("eventenddate")
//    @Expose
//    public String eventenddate;
//
//    @SerializedName("eventseats")
//    @Expose
//    public Integer eventseats;
//
//    @SerializedName("eventpic")
//    @Expose
//    public String eventpic;
//
//    @SerializedName("eventexpirestatus")
//    @Expose
//    public Integer eventexpirestatus;
//
//    @SerializedName("showonhomepage")
//    @Expose
//    public Integer showonhomepage;
//
//    @SerializedName("created_at")
//    @Expose
//    public String createdAt;
//
//    @SerializedName("updated_at")
//    @Expose
//    public String updatedAt;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getEventname() {
//        return eventname;
//    }
//
//    public void setEventname(String eventname) {
//        this.eventname = eventname;
//    }
//
//    public String getEventlocation() {
//        return eventlocation;
//    }
//
//    public void setEventlocation(String eventlocation) {
//        this.eventlocation = eventlocation;
//    }
//
//    public Integer getEventcreator() {
//        return eventcreator;
//    }
//
//    public void setEventcreator(Integer eventcreator) {
//        this.eventcreator = eventcreator;
//    }
//
//    public String getEventdesc() {
//        return eventdesc;
//    }
//
//    public void setEventdesc(String eventdesc) {
//        this.eventdesc = eventdesc;
//    }
//
//    public Integer getEventpriceperperson() {
//        return eventpriceperperson;
//    }
//
//    public void setEventpriceperperson(Integer eventpriceperperson) {
//        this.eventpriceperperson = eventpriceperperson;
//    }
//
//    public String getEventstartdate() {
//        return eventstartdate;
//    }
//
//    public void setEventstartdate(String eventstartdate) {
//        this.eventstartdate = eventstartdate;
//    }
//
//    public String getEventenddate() {
//        return eventenddate;
//    }
//
//    public void setEventenddate(String eventenddate) {
//        this.eventenddate = eventenddate;
//    }
//
//    public Integer getEventseats() {
//        return eventseats;
//    }
//
//    public void setEventseats(Integer eventseats) {
//        this.eventseats = eventseats;
//    }
//
//    public String getEventpic() {
//        return eventpic;
//    }
//
//    public void setEventpic(String eventpic) {
//        this.eventpic = eventpic;
//    }
//
//    public Integer getEventexpirestatus() {
//        return eventexpirestatus;
//    }
//
//    public void setEventexpirestatus(Integer eventexpirestatus) {
//        this.eventexpirestatus = eventexpirestatus;
//    }
//
//    public Integer getShowonhomepage() {
//        return showonhomepage;
//    }
//
//    public void setShowonhomepage(Integer showonhomepage) {
//        this.showonhomepage = showonhomepage;
//    }
//
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }

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
    public String  totalSeat;   // it was an integer i have changed it to String

    @SerializedName("eventShow")
    @Expose
    public Integer eventShow;

    @SerializedName("status")
    @Expose
    public Integer status;

    @SerializedName("imagePath")
    @Expose
    public String imagePath;


}
