package com.mahashakti.Response.GetThoughtsResponse;

import com.google.gson.annotations.SerializedName;

public class GetAllThoughtPayload {
    @SerializedName("id")
    private int id;
    @SerializedName("message")
    private String message;
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("attachment_pic")
    private String attachment_pic;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("thoughtowner")
    private String thoughtowner;
    @SerializedName("userpic")
    private String userpic;
    @SerializedName("likecount")
    private int likecount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAttachment_pic() {
        return attachment_pic;
    }

    public void setAttachment_pic(String attachment_pic) {
        this.attachment_pic = attachment_pic;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getThoughtowner() {
        return thoughtowner;
    }

    public void setThoughtowner(String thoughtowner) {
        this.thoughtowner = thoughtowner;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }
}
