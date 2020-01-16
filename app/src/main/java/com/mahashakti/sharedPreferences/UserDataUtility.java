package com.mahashakti.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dharamveer on 17/1/18.
 */

public class UserDataUtility {


    Context context;

    SharedPreferences sharedPreferences;


    private int userId;

    private String userName;
    private String userEmail;
    private String phoneNo;
    private String sex;
    private String userPic;


    public UserDataUtility(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);

    }


    public static boolean getLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("lll", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("first", false);
    }

    public static void setLogin(boolean login, Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("lll", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first", login);
        editor.clear();
        editor.apply();
    }


    public int getUserId() {
        userId = sharedPreferences.getInt("userId", userId);
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        sharedPreferences.edit().putInt("userId", userId).commit();

    }

    public String getUserName() {
        userName = sharedPreferences.getString("userName", userName);

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        sharedPreferences.edit().putString("userName", userName).commit();

    }

    public String getUserEmail() {
        userEmail = sharedPreferences.getString("userEmail", userEmail);

        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        sharedPreferences.edit().putString("userEmail", userEmail).commit();

    }

    public String getPhoneNo() {
        phoneNo = sharedPreferences.getString("phoneNo", phoneNo);
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        sharedPreferences.edit().putString("phoneNo", phoneNo).commit();

    }

    public String getSex() {
        sex = sharedPreferences.getString("sex", sex);

        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        sharedPreferences.edit().putString("sex", sex).commit();

    }


    public String getUserPic() {
        userPic = sharedPreferences.getString("userPic", userPic);
        return userPic;
    }

    public void setUserPic(String userPic) {

        this.userPic = userPic;
        sharedPreferences.edit().putString("userPic", userPic).commit();

    }


}
