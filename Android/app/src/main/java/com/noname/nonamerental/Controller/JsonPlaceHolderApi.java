package com.noname.nonamerental.Controller;

import com.noname.nonamerental.Model.UserRegisterData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST("user/register.php")
    Call<UserRegisterData> CreateUser(@Body UserRegisterData userRegisterData);

}
