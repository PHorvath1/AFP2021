package com.noname.nonamerental.Controller;

import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noname.nonamerental.Model.UserRegisterData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterController {

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private static JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    public static void RegisterUser(UserRegisterData user) {
        Call<UserRegisterData> call = jsonPlaceHolderApi.CreateUser(user);

        call.enqueue(new Callback<UserRegisterData>() {
            @Override
            public void onResponse(Call<UserRegisterData> call, Response<UserRegisterData> response) {
                if (!response.isSuccessful()){
                    System.out.println("Error");
                }
                else {
                    System.out.println("Succes");
                }
            }

            @Override
            public void onFailure(Call<UserRegisterData> call, Throwable t) {
                System.out.println(t);

            }
        });
    }


}
