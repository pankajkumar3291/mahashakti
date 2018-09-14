package com.mahashakti.response.CreateSocialUser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayLoad {


//    @SerializedName("id")
//    @Expose
//    public Integer id;
//
//    @SerializedName("name")
//    @Expose
//    public String name;
//
//    @SerializedName("email")
//    @Expose
//    public String email;
//
//    @SerializedName("tel")
//    @Expose
//    public String tel;
//
//    @SerializedName("sex")
//    @Expose
//    public String sex;
//
//    @SerializedName("a_or_c")
//    @Expose
//    public String aOrC;
//
//    @SerializedName("user_pic")
//    @Expose
//    public Object userPic;
//
//    @SerializedName("created_at")
//    @Expose
//    public String createdAt;
//
//    @SerializedName("updated_at")
//    @Expose
//    public String updatedAt;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTel() {
//        return tel;
//    }
//
//    public void setTel(String tel) {
//        this.tel = tel;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getaOrC() {
//        return aOrC;
//    }
//
//    public void setaOrC(String aOrC) {
//        this.aOrC = aOrC;
//    }
//
//    public Object getUserPic() {
//        return userPic;
//    }
//
//    public void setUserPic(Object userPic) {
//        this.userPic = userPic;
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
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone")
    @Expose
    private Object phone;

    @SerializedName("sex")
    @Expose
    private Object sex;

    @SerializedName("image")
    @Expose
    private Object image;

    @SerializedName("id")
    @Expose
    private Integer id;


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

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
