package com.mahashakti.RetrofitLibrary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import com.mahashakti.Response.CreateThought.CreateThoughtSuccess;
import com.mahashakti.Response.CreateUserSuccess.CreateUserSuccess;
import com.mahashakti.Response.EventResponse.EventSuccess;
import com.mahashakti.Response.GetThoughtsResponse.GetAllThoughtSuccess;
import com.mahashakti.Response.LoginUserResponse.LoginUserSuccess;
import com.mahashakti.Response.ProfileUpdateResponse.ProfileUpdateSuccess;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public class RestClient1 {


    private static GitApiInterface gitApiInterface;

    // http://employeelive.com/kwiqmall/API/public/getRestaurants

    private static String baseUrl = "http://mahashaktiradiance.com/api/";

    public static GitApiInterface getClient() {


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())

                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .build();


        gitApiInterface = retrofit.create(GitApiInterface.class);

        return gitApiInterface;


    }

    public interface GitApiInterface {



       //------------------------1
        @POST("createuser")
        Call<CreateUserSuccess> createUser(@Body HashMap<String, String> hashMap);


        //------------------------2
        @POST("loginuser")
        Call<LoginUserSuccess> loginUser(@Body HashMap<String, String> hashMap);



        //-----------------------3
        @Multipart
        @POST("createthought")
        Call<CreateThoughtSuccess> createThought(@Part("userid") RequestBody userid,
                                                 @Part("thought") RequestBody name,
                                                 @Part MultipartBody.Part file);


        //-----------------------4
        @GET("getallthought")
        Call<GetAllThoughtSuccess> getallthought();




        //-----------------------5
        @Multipart
        @POST("updateprofile")
        Call<ProfileUpdateSuccess> updateProfile(@Part("userid") RequestBody userid,
                                                 @Part("email") RequestBody email,
                                                 @Part("phone") RequestBody phone,
                                                 @Part MultipartBody.Part file,
                                                 @Part("sex") RequestBody sex);


        //-----------------------6
        @GET("getallevent")
        Call<EventSuccess> getallevent();



    }
}