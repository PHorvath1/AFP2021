package com.noname.nonamerental.Views;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noname.nonamerental.Controller.JsonPlaceHolderApi;
import com.noname.nonamerental.Model.Car;
import com.noname.nonamerental.R;

import java.util.List;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarView extends AppCompatActivity {

    private List<Car> data;
    private int position;
    private Button btnRent;
    private Button btnBack;
    private ImageView ivCar;
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvPrice;

    public CarView(int position){

        this.position = position;

    }

    public CarView(){

        this.position = 1;

    }

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private static JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carview);
        ivCar = findViewById(R.id.ivCar);
        tvName = findViewById(R.id.tvCarName);
        tvDescription = findViewById(R.id.tvCarDescription);
        tvPrice = findViewById(R.id.tvCarPrice);
        try {
            getCarInfo(1, position);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void getCarInfo(int uid, int cid){
        Call<List<Car>> car = jsonPlaceHolderApi.GetCarInfo(uid, cid);
        car.enqueue(new Callback<List<Car>>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                data = response.body();
                System.out.println(data.get(0));
                ivCar.setImageResource(getApplicationContext().getResources().getIdentifier(data.get(0).getImage(),"mipmap",getApplicationContext().getPackageName()));
                String temp = data.get(0).getBrand()+' '+data.get(0).getType();
                tvName.setText(temp);
                tvDescription.setText(data.get(0).getDescription());
                tvPrice.setText(String.valueOf(data.get(0).getPrice()));
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                System.out.println("Hiba a jármű megtekintésekor...");
                System.out.println(t.getMessage());
            }
        });
    }

}
