package com.mahashakti.response.GetThoughtsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dharamveer on 19/1/18.
 */

public class GetAllThoughtSuccess {


    @Expose
    @SerializedName("payload")
    private List<GetAllThoughtPayload> payload;
    @Expose
    @SerializedName("Error")
    private boolean Error;
    @Expose
    @SerializedName("Success")
    private boolean Success;

    public List<GetAllThoughtPayload> getPayload() {
        return payload;
    }

    public void setPayload(List<GetAllThoughtPayload> payload) {
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
