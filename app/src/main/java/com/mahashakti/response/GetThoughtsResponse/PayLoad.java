package com.mahashakti.response.GetThoughtsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayLoad {

//    @SerializedName("id")
//    @Expose
//    public Integer id;
//
//    @SerializedName("message")
//    @Expose
//    public String message;
//
//    @SerializedName("user_id")
//    @Expose
//    public Integer userId;
//
//    @SerializedName("attachment_pic")
//    @Expose
//    public String attachmentPic;
//
//    @SerializedName("updated_at")
//    @Expose
//    public String updatedAt;
//
//    @SerializedName("thoughtowner")
//    @Expose
//    public String thoughtowner;
//
//    @SerializedName("userpic")
//    @Expose
//    public String userpic;
//
//    @SerializedName("likecount")
//    @Expose
//    public Integer likecount;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getAttachmentPic() {
//        return attachmentPic;
//    }
//
//    public void setAttachmentPic(String attachmentPic) {
//        this.attachmentPic = attachmentPic;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getThoughtowner() {
//        return thoughtowner;
//    }
//
//    public void setThoughtowner(String thoughtowner) {
//        this.thoughtowner = thoughtowner;
//    }
//
//    public String getUserpic() {
//        return userpic;
//    }
//
//    public void setUserpic(String userpic) {
//        this.userpic = userpic;
//    }
//
//    public Integer getLikecount() {
//        return likecount;
//    }
//
//    public void setLikecount(Integer likecount) {
//        this.likecount = likecount;
//    }

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("userId")
    @Expose
    public Integer userId;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("imagePath")
    @Expose
    public String imagePath;

}
