package com.mahashakti.Response.CreateThought;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dharamveer on 18/1/18.
 */

public class CreateThoughtSuccess {


    @SerializedName("Success")
    private boolean Success;
    @SerializedName("Error")
    private boolean Error;
    @SerializedName("message")
    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
