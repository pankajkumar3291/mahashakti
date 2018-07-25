package mahashakti.mahashakti.Hawk;

import android.content.Context;

import com.orhanobut.hawk.Hawk;

/**
 * Created by dharamveer on 22/1/18.
 */

public class HawkUserUtility {


    Context context;


    public HawkUserUtility(Context context) {
        this.context = context;
        Hawk.init(context).build();
    }



    public void setLogin(boolean login, Context context){

        Hawk.put("first",login);


    }


    public boolean getLogin(Context context){

        boolean val = Hawk.get("first");

        return val;

    }


    public void setUserId(int userId){

        Hawk.put("userid",userId);
    }


    public int getUserId(){

        int userid = Hawk.get("userid");
        return userid;
    }


    public void setUserPic(String userPic) {

        Hawk.put("userpic",userPic);

    }

    public String getUserPic()
    {
       String userPic =  Hawk.get("userpic");
        return userPic;
    }





    public void setUserName(String userName) {

        Hawk.put("userName",userName);

    }

    public String getUserName()
    {
        String userName =  Hawk.get("userName");
        return userName;
    }





    public void setUserEmail(String userEmail) {

        Hawk.put("userEmail",userEmail);

    }

    public String getUserEmail()
    {
        String userEmail =  Hawk.get("userEmail");
        return userEmail;
    }



    public void setPhoneNo(String phoneNo) {

        Hawk.put("phoneNo",phoneNo);

    }

    public String getPhoneNo()
    {
        String phoneNo =  Hawk.get("phoneNo");
        return phoneNo;
    }





    public void setSex(String sex) {

        Hawk.put("sex",sex);

    }

    public String getSex()
    {
        String sex =  Hawk.get("sex");
        return sex;
    }







}
