package com.mahashakti.Response.EventResponse;

import com.google.gson.annotations.SerializedName;

public class EventPayload {
    @SerializedName("id")
    private int id;
    @SerializedName("eventname")
    private String eventname;
    @SerializedName("eventlocation")
    private String eventlocation;
    @SerializedName("eventcreator")
    private int eventcreator;
    @SerializedName("eventdesc")
    private String eventdesc;
    @SerializedName("eventpriceperperson")
    private int eventpriceperperson;
    @SerializedName("eventstartdate")
    private String eventstartdate;
    @SerializedName("eventenddate")
    private String eventenddate;
    @SerializedName("eventseats")
    private int eventseats;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public int getEventcreator() {
        return eventcreator;
    }

    public void setEventcreator(int eventcreator) {
        this.eventcreator = eventcreator;
    }

    public String getEventdesc() {
        return eventdesc;
    }

    public void setEventdesc(String eventdesc) {
        this.eventdesc = eventdesc;
    }

    public int getEventpriceperperson() {
        return eventpriceperperson;
    }

    public void setEventpriceperperson(int eventpriceperperson) {
        this.eventpriceperperson = eventpriceperperson;
    }

    public String getEventstartdate() {
        return eventstartdate;
    }

    public void setEventstartdate(String eventstartdate) {
        this.eventstartdate = eventstartdate;
    }

    public String getEventenddate() {
        return eventenddate;
    }

    public void setEventenddate(String eventenddate) {
        this.eventenddate = eventenddate;
    }

    public int getEventseats() {
        return eventseats;
    }

    public void setEventseats(int eventseats) {
        this.eventseats = eventseats;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
