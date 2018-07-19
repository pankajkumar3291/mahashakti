package com.mahashakti.response.CreateThought;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayLoad {

//    @SerializedName("user_id")
//    @Expose
//    public String userId;
//
//    @SerializedName("message")
//    @Expose
//    public String message;
//
//    @SerializedName("attachment_pic")
//    @Expose
//    public String attachmentPic;
//
//    @SerializedName("approve_or_not")
//    @Expose
//    public Integer approveOrNot;
//
//    @SerializedName("updated_at")
//    @Expose
//    public String updatedAt;
//
//    @SerializedName("created_at")
//    @Expose
//    public String createdAt;
//
//    @SerializedName("id")
//    @Expose
//    public Integer id;
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
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
//    public String getAttachmentPic() {
//        return attachmentPic;
//    }
//
//    public void setAttachmentPic(String attachmentPic) {
//        this.attachmentPic = attachmentPic;
//    }
//
//    public Integer getApproveOrNot() {
//        return approveOrNot;
//    }
//
//    public void setApproveOrNot(Integer approveOrNot) {
//        this.approveOrNot = approveOrNot;
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
//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    @SerializedName("image")
    @Expose
    public Integer image;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("userId")
    @Expose
    public String userId;

    @SerializedName("id")
    @Expose
    public Integer id;
}
