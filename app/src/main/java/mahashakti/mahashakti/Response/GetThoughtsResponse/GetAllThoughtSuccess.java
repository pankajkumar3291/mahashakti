package com.mahashakti.Response.GetThoughtsResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dharamveer on 19/1/18.
 */

public class GetAllThoughtSuccess {


    @SerializedName("Success")
    private boolean Success;
    @SerializedName("Error")
    private boolean Error;
    @SerializedName("payload")
    private List<GetAllThoughtPayload> payload;

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

    public List<GetAllThoughtPayload> getPayload() {
        return payload;
    }

    public void setPayload(List<GetAllThoughtPayload> payload) {
        this.payload = payload;
    }
}
