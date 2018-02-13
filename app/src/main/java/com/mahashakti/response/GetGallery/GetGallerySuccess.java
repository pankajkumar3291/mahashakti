package com.mahashakti.response.GetGallery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dharamveer on 2/2/18.
 */

public class GetGallerySuccess {
    @Expose
    @SerializedName("payload")
    private List<PayloadGallery> payload;
    @Expose
    @SerializedName("Error")
    private boolean Error;
    @Expose
    @SerializedName("Success")
    private boolean Success;

    public List<PayloadGallery> getPayload() {
        return payload;
    }

    public void setPayload(List<PayloadGallery> payload) {
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
