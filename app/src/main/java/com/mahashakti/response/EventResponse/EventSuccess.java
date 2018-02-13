package com.mahashakti.response.EventResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dharamveer on 23/1/18.
 */

public class EventSuccess  {


    @SerializedName("Success")
    private boolean Success;
    @SerializedName("Error")
    private boolean Error;
    @SerializedName("payload")
    private List<EventPayload> payload;

    public boolean getSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public boolean getError() {
        return Error;
    }

    public void setError(boolean Error) {
        this.Error = Error;
    }

    public List<EventPayload> getPayload() {
        return payload;
    }

    public void setPayload(List<EventPayload> payload) {
        this.payload = payload;
    }
}
