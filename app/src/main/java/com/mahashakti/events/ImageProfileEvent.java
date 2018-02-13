package com.mahashakti.events;

/**
 * Created by dharamveer on 2/2/18.
 */

public class ImageProfileEvent {


    private String profileImage;


    public String getImageUrl() {
        return profileImage;
    }



    public ImageProfileEvent(String userpic) {

        this.profileImage = userpic;

    }
}
