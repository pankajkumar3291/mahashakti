package com.mahashakti.response.UpcomingEventSuccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayloadUpcomingEvent {
    @Expose
    @SerializedName("updated_at")
    private String updated_at;
    @Expose
    @SerializedName("created_at")
    private String created_at;
    @Expose
    @SerializedName("showonhomepage")
    private int showonhomepage;
    @Expose
    @SerializedName("eventexpirestatus")
    private int eventexpirestatus;
    @Expose
    @SerializedName("eventpic")
    private String eventpic;
    @Expose
    @SerializedName("eventseats")
    private int eventseats;
    @Expose
    @SerializedName("eventenddate")
    private String eventenddate;
    @Expose
    @SerializedName("eventstartdate")
    private String eventstartdate;
    @Expose
    @SerializedName("eventpriceperperson")
    private int eventpriceperperson;
    @Expose
    @SerializedName("eventdesc")
    private String eventdesc;
    @Expose
    @SerializedName("eventcreator")
    private int eventcreator;
    @Expose
    @SerializedName("eventlocation")
    private String eventlocation;
    @Expose
    @SerializedName("eventname")
    private String eventname;
    @Expose
    @SerializedName("id")
    private int id;

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getShowonhomepage() {
        return showonhomepage;
    }

    public void setShowonhomepage(int showonhomepage) {
        this.showonhomepage = showonhomepage;
    }

    public int getEventexpirestatus() {
        return eventexpirestatus;
    }

    public void setEventexpirestatus(int eventexpirestatus) {
        this.eventexpirestatus = eventexpirestatus;
    }

    public String getEventpic() {
        return eventpic;
    }

    public void setEventpic(String eventpic) {
        this.eventpic = eventpic;
    }

    public int getEventseats() {
        return eventseats;
    }

    public void setEventseats(int eventseats) {
        this.eventseats = eventseats;
    }

    public String getEventenddate() {
        return eventenddate;
    }

    public void setEventenddate(String eventenddate) {
        this.eventenddate = eventenddate;
    }

    public String getEventstartdate() {
        return eventstartdate;
    }

    public void setEventstartdate(String eventstartdate) {
        this.eventstartdate = eventstartdate;
    }

    public int getEventpriceperperson() {
        return eventpriceperperson;
    }

    public void setEventpriceperperson(int eventpriceperperson) {
        this.eventpriceperperson = eventpriceperperson;
    }

    public String getEventdesc() {
        return eventdesc;
    }

    public void setEventdesc(String eventdesc) {
        this.eventdesc = eventdesc;
    }

    public int getEventcreator() {
        return eventcreator;
    }

    public void setEventcreator(int eventcreator) {
        this.eventcreator = eventcreator;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
