package com.mahashakti.manager;

import java.util.HashMap;

import com.mahashakti.response.CreateSocialUser.CreateSocialSuccess;
import com.mahashakti.response.CreateThought.CreateThoughtSuccess;
import com.mahashakti.response.CreateUserSuccess.CreateUserSuccess;
import com.mahashakti.response.EventResponse.EventSuccess;
import com.mahashakti.response.GetGallery.GetGallerySuccess;
import com.mahashakti.response.GetGallery.PayloadGallery;
import com.mahashakti.response.GetThoughtsResponse.GetAllThoughtSuccess;
import com.mahashakti.response.LoginUserResponse.LoginUserSuccess;
import com.mahashakti.response.ProfileUpdateResponse.ProfileUpdateSuccess;
import com.mahashakti.response.UpcomingEventSuccess.UpcomingEventSuccess;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by dharamveer on 24/1/18.
 */

public interface GitApiInterface {



        //------------------------1
        @FormUrlEncoded
        @POST("createuser")
        Observable<CreateUserSuccess> createUser(@Field("email") String Email,
                                                 @Field("fullname") String Fullname,
                                                 @Field("password") String Password);



        //------------------------2
        @FormUrlEncoded
        @POST("loginuser")
        Observable<LoginUserSuccess> loginUser(@Field("email") String Email,
                                               @Field("password") String Password);



        //-----------------------3
        @Multipart
        @POST("createthought")
        Observable<CreateThoughtSuccess> createThought(@Part("userid") RequestBody userid,
                                                 @Part("thought") RequestBody name,
                                                 @Part MultipartBody.Part file);


        //-----------------------4
        @GET("getallthought")
        Observable<GetAllThoughtSuccess> getallthought();




        //-----------------------5
        @Multipart
        @POST("updateprofile")
        Observable<ProfileUpdateSuccess> updateProfile(@Part("userid") RequestBody userid,
                                                 @Part("email") RequestBody email,
                                                 @Part("phone") RequestBody phone,
                                                 @Part MultipartBody.Part file,
                                                 @Part("sex") RequestBody sex);


        //-----------------------6
        @GET("getallevent")
        Observable<EventSuccess> getallevent();

        //-----------------------7
        @GET("getgalleryitems")
        Observable<GetGallerySuccess> getgalleryitems();



        //-----------------------8
        @GET("getUpcomingEvent")
        Observable<UpcomingEventSuccess> getUpcomingEvent();



        //-----------------------9
        @FormUrlEncoded
        @POST("createusersocial")
        Observable<CreateSocialSuccess> createusersocial(@Field("name") String Name,
                                                         @Field("email") String Email,
                                                        @Field("userfrom") String Userfrom);





}
