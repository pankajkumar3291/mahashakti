package com.mahashakti.response.CreateSocialUser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dharamveer on 15/2/18.
 */

public class CreatePayloadSocial {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("a_or_c")
    @Expose
    private String aOrC;
    @SerializedName("user_pic")
    @Expose
    private Object userPic;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAOrC() {
        return aOrC;
    }

    public void setAOrC(String aOrC) {
        this.aOrC = aOrC;
    }

    public Object getUserPic() {
        return userPic;
    }

    public void setUserPic(Object userPic) {
        this.userPic = userPic;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
