package com.noname.nonamerental.Controller;

import com.noname.nonamerental.Model.Status;
import com.noname.nonamerental.Model.UserRegisterData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @POST("user/register.php")
    Call<UserRegisterData> CreateUser(@Body UserRegisterData userRegisterData);

    @GET("user/login.php")
    Call<Status> LoginUser(@Query("email") String email,
                           @Query("password") String password);


}
