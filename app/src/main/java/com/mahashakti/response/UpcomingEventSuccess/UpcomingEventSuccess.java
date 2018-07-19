package com.mahashakti.response.UpcomingEventSuccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dharamveer on 6/2/18.
 */

public class UpcomingEventSuccess {


    @Expose
    @SerializedName("payload")
    private PayloadUpcomingEvent payload;

    @Expose
    @SerializedName("Error")
    private boolean Error;
    
    @Expose
    @SerializedName("Success")
    private boolean Success;

    public PayloadUpcomingEvent getPayload() {
        return payload;
    }

    public void setPayload(PayloadUpcomingEvent payload) {
        this.payload = payload;
    }

    public boolean getError() {
        return Error;
    }

    public void setError(boolean Error) {
        this.Error = Error;
    }

    public boolean getSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }
}
