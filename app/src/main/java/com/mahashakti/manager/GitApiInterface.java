package com.mahashakti.manager;

import java.util.HashMap;

import com.mahashakti.response.CreateSocialUser.CreateSocialSuccess;
import com.mahashakti.response.CreateThought.CreateThoughtSuccess;
import com.mahashakti.response.CreateUserSuccess.CreateUserSuccess;
import com.mahashakti.response.EventResponse.EventSuccess;
import com.mahashakti.response.GetGallery.GetGallerySuccess;
import com.mahashakti.response.GetThoughtsResponse.GetAllThoughtSuccess;
import com.mahashakti.response.LoginUserResponse.LoginUserSuccess;
import com.mahashakti.response.ProfileUpdateResponse.ProfileUpdateSuccess;
import com.mahashakti.response.UpcomingEventSuccess.UpcomingEventSuccess;
import com.mahashakti.response.createServices.CreateServices;

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
    @POST("register")
    // @POST("createuser")
    Observable<CreateUserSuccess> createUser(@Field("email") String Email,
                                             @Field("password") String Fullname,
                                             @Field("fullname") String Password);


    //------------------------2
    @FormUrlEncoded
    @POST("login")
    Observable<LoginUserSuccess> loginUser(@Field("email") String Email,
                                           @Field("password") String Password);


    //-----------------------3
    @Multipart
    @POST("createThought")
    Observable<CreateThoughtSuccess> createThought(@Part("userId") RequestBody userid,
                                                   @Part("message") RequestBody name,
                                                   @Part MultipartBody.Part file);

//    @Multipart
//    @POST("createthought")
//    Observable<CreateThoughtSuccess> createThought(@Part("userid") RequestBody userid,
//                                                   @Part("thought") RequestBody name,
//                                                   @Part MultipartBody.Part file);


    //-----------------------4
    @GET("getThought")
    // @GET("getallthought")
    Observable<GetAllThoughtSuccess> getallthought();


    //-----------------------5
    @Multipart
    @POST("updateProfile")
    Observable<ProfileUpdateSuccess> updateProfile(@Part("userId") RequestBody userid,
                                                   @Part("email") RequestBody email,
                                                   @Part("phone") RequestBody phone,
                                                   @Part MultipartBody.Part file,
                                                   @Part("sex") RequestBody sex);


    //-----------------------6
    @GET("event")
    Observable<EventSuccess> getallevent();

    //-----------------------7
    @GET("getGallery")
    Observable<GetGallerySuccess> getgalleryitems();


    //-----------------------8
    @GET("getUpcomingEvent")
    Observable<UpcomingEventSuccess> getUpcomingEvent();


    //-----------------------9
    @FormUrlEncoded
    @POST("createSocialUser")
    Observable<CreateSocialSuccess> createusersocial(@Field("name") String Name,
                                                     @Field("email") String Email); // @Field("userfrom") String Userfrom

    @GET("service")
    Observable<CreateServices> creatingService();


}
