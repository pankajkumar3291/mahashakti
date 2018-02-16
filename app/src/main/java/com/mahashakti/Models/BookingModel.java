package com.mahashakti.Models;

/**
 * Created by dharamveer on 11/1/18.
 */

public class BookingModel {


    private int imageProgramBooking;
    private String FestivalNameBooking,FestDescriptionBooking,DateBooking,TimeBooking;

    public int getImageProgramBooking() {
        return imageProgramBooking;
    }

    public void setImageProgramBooking(int imageProgramBooking) {
        this.imageProgramBooking = imageProgramBooking;
    }

    public String getFestivalNameBooking() {
        return FestivalNameBooking;
    }

    public void setFestivalNameBooking(String festivalNameBooking) {
        FestivalNameBooking = festivalNameBooking;
    }

    public String getFestDescriptionBooking() {
        return FestDescriptionBooking;
    }

    public void setFestDescriptionBooking(String festDescriptionBooking) {
        FestDescriptionBooking = festDescriptionBooking;
    }

    public String getDateBooking() {
        return DateBooking;
    }

    public void setDateBooking(String dateBooking) {
        DateBooking = dateBooking;
    }

    public String getTimeBooking() {
        return TimeBooking;
    }

    public void setTimeBooking(String timeBooking) {
        TimeBooking = timeBooking;
    }
}
