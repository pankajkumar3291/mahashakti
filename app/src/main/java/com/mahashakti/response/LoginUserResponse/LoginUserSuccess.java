package com.mahashakti.response.LoginUserResponse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dharamveer on 17/1/18.
 */

public class LoginUserSuccess {


    @SerializedName("Success")
    private boolean Success;
    @SerializedName("Error")
    private boolean Error;
    @SerializedName("payload")
    private Payload payload;

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

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
