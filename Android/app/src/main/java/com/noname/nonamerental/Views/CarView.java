package com.noname.nonamerental.Views;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noname.nonamerental.Controller.JsonPlaceHolderApi;
import com.noname.nonamerental.Model.Car;
import com.noname.nonamerental.Model.RentedCar;
import com.noname.nonamerental.R;

import java.sql.Date;
import java.util.List;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarView extends AppCompatActivity {

    private List<Car> data;
    private RentedCar rentedCar;
    private int itemPosition;
    private Button btnRent;
    private Button btnBack;
    private ImageView ivCar;
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvPrice;
    private TextView tvQuantity;
    private TextView tdRentDate;
    private TextView tdReturnDate;

    public CarView(){
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
        itemPosition = getIntent().getIntExtra("carId",1);
        ivCar = findViewById(R.id.ivCar);
        tvName = findViewById(R.id.tvCarName);
        tvDescription = findViewById(R.id.tvCarDescription);
        tvPrice = findViewById(R.id.tvCarPrice);
        tvQuantity = findViewById(R.id.tvQuantity);
        tdRentDate = findViewById(R.id.tdRentDate);
        tdReturnDate = findViewById(R.id.tdReturnDate);
        btnBack = findViewById(R.id.btnBack);
        btnRent = findViewById(R.id.btnRentCar);
        try {
            getCarInfo(1, itemPosition);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rentedCar = new RentedCar(1, itemPosition, Date.valueOf(tdReturnDate.getText().toString()), Integer.parseInt(tvPrice.getText().toString()));
                try{
                    rentCar(rentedCar.getUid(), rentedCar.getCid(), rentedCar.getRental_time());
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CarView.this, MainActivity.class));
            }
        });


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
                tvPrice.setText(String.valueOf(data.get(0).getPrice()) + "Ft/nap");
                tvQuantity.setText("Elérhető: "+String.valueOf(data.get(0).getQuantity()));
                tdRentDate.setText("From (YYYY-MM-DD)");
                tdReturnDate.setText("To (YYYY-MM-DD)");
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                System.out.println("Hiba a jármű megtekintésekor...");
                System.out.println(t.getMessage());
            }
        });
    }

    public void rentCar(int uid, int cid, Date endDate){
        Call<RentedCar> call = jsonPlaceHolderApi.RentCar(uid, cid, endDate);
        call.enqueue(new Callback<RentedCar>() {
            @Override
            public void onResponse(Call<RentedCar> call, Response<RentedCar> response) {
                if (response.isSuccessful())
                    System.out.println("Success");
                else
                    System.out.println("Error");
            }

            @Override
            public void onFailure(Call<RentedCar> call, Throwable t) {
                System.out.println("Hiba a kölcsönzéskor: " + t.getMessage());
            }
        });
    }

}
