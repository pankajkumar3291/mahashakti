package com.mahashakti.httpNet;


import com.mahashakti.response.LoginUserResponse.LoginUserSuccess;
import com.mahashakti.response.changePassword.ChangePassword;
import com.mahashakti.response.commentByBlog.CommentByBlog;
import com.mahashakti.response.createBlog.CreateBlog;
import com.mahashakti.response.createComment.CreateComment;
import com.mahashakti.response.createParticularServiceInfo.CreateParticularServiceInfo;
import com.mahashakti.response.createServices.CreateServices;
import com.mahashakti.response.displayingAdminApproveChat.DisplayingAdminChat;
import com.mahashakti.response.displayingUserChat.DisplayingUserChat;
import com.mahashakti.response.forgetPassword.ForgetPassword;
import com.mahashakti.response.upcomingEvent.UpcomingEvent;
import com.mahashakti.response.userInfo.UserInfo;

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


    // 6
    @FormUrlEncoded
    @POST("showChatsWithUser")
    Call<DisplayingUserChat> displayUserChatMessages(@Field("userId") Integer userId);


    // 7
    @FormUrlEncoded
    @POST("chat")
    Call<DisplayingAdminChat> displayAdminChatMessages(@Field("userId") Integer userId, @Field("message") String message);

    // 8
    @FormUrlEncoded
    @POST("getUserInfo")
    Call<UserInfo> UserInfoAPI(@Field("id") Integer userId);

    // 9

    @GET("upcommingEvent/")
    Call<UpcomingEvent> createUpcomingEvent();


    // 10

    @FormUrlEncoded
    @POST("forgotPassword")
    Call<ForgetPassword> forgetPasswordAPI(@Field("email") String email);

    // 11

    @FormUrlEncoded
    @POST("changePassword")
    Call<ChangePassword> changePasswordAPI(@Field("email") String email, @Field(("oldPassword")) String oldPassword, @Field(("newPassword")) String newPassword);


}
