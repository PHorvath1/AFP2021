package com.noname.nonamerental.Controller;

import com.noname.nonamerental.Model.Car;
import com.noname.nonamerental.Model.CarResponse;
import com.noname.nonamerental.Model.RentedCar;
import com.noname.nonamerental.Model.Status;
import com.noname.nonamerental.Model.UserData;
import com.noname.nonamerental.Model.UserRegisterData;

import java.sql.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @POST("user/register.php")
    Call<UserRegisterData> CreateUser(@Body UserRegisterData userRegisterData);

    @GET("user/login.php")
    Call<Status> LoginUser(@Query("email") String email,
                           @Query("password") String password);

    @GET("user/profile.php")
    Call<List<UserData>> GetUserData(@Query("uid") int id);

    @GET("cars/index.php")
    Call<List<CarResponse>> ListCars(@Query("uid") int id);

    @GET("cars/index.php")
    Call<List<Car>> GetCarInfo(@Query("uid") int id,
                         @Query("carId") int cid);

    @PUT("cars/index.php")
    Call<RentedCar> RentCar(@Query("uid") int id,
                            @Query("carId") int cid,
                            @Query("rental_time") Date date);

}
