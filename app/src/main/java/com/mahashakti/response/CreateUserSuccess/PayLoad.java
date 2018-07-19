package com.mahashakti.response.CreateUserSuccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayLoad {

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

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("phone")
    @Expose
    public Object phone;

    @SerializedName("sex")
    @Expose
    public Object sex;

    @SerializedName("image")
    @Expose
    public Object image;

    @SerializedName("id")
    @Expose
    public Integer id;


}
