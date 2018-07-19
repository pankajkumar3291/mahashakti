package com.mahashakti.httpNet;


import com.mahashakti.response.LoginUserResponse.LoginUserSuccess;
import com.mahashakti.response.createBlog.CreateBlog;
import com.mahashakti.response.createParticularServiceInfo.CreateParticularServiceInfo;
import com.mahashakti.response.createServices.CreateServices;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RemoteRepositoryService {



//    service 1
    @GET("service/")
    Call<CreateServices> creatingService();


    //    service 2
    @FormUrlEncoded
    @POST("showServiceContent")
    Call<CreateParticularServiceInfo> creatingparticularService(@Field("serviceId") Integer serviceId);



    // blog 1

    @GET("getBlog/")
    Call<CreateBlog> creatingBlog();


}
