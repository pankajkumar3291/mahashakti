package com.mahashakti.httpNet;


import com.mahashakti.response.LoginUserResponse.LoginUserSuccess;
import com.mahashakti.response.commentByBlog.CommentByBlog;
import com.mahashakti.response.createBlog.CreateBlog;
import com.mahashakti.response.createComment.CreateComment;
import com.mahashakti.response.createParticularServiceInfo.CreateParticularServiceInfo;
import com.mahashakti.response.createServices.CreateServices;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RemoteRepositoryService {


    //     1
    @GET("service/")
    Call<CreateServices> creatingService();


    //     2
    @FormUrlEncoded
    @POST("showServiceContent")
    Call<CreateParticularServiceInfo> creatingparticularService(@Field("serviceId") Integer serviceId);


    //  1

    @GET("getBlog/")
    Call<CreateBlog> creatingBlog();


    //     4
    @FormUrlEncoded
    @POST("getCommentByBlog")
    Call<CommentByBlog> createBlogComment(@Field("blogId") Integer blogId);


    // 5
    @FormUrlEncoded
    @POST("createComment")
    Call<CreateComment> createComment(@Field("blogId") Integer blogId,
                                      @Field("userId") Integer userId,
                                      @Field("message") String message);


}
