package com.noname.nonamerental.Views;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noname.nonamerental.Controller.CarListAdapter;
import com.noname.nonamerental.Controller.JsonPlaceHolderApi;
import com.noname.nonamerental.Model.CarResponse;
import com.noname.nonamerental.R;

import java.util.List;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarList extends AppCompatActivity {
    private List<CarResponse> cars;

    private Button btnCoupe;
    private Button btnKombi;
    private Button btnSUV;
    private Button btnSedan;

    private RecyclerView carRecyclerView;


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
        setContentView(R.layout.activity_carlist);

        carRecyclerView = findViewById(R.id.carRecyclerView);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            //Ide kéne a belépett felhasználó azonosítója
            listCars(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listCars(int uid) {
        Call<List<CarResponse>> list = jsonPlaceHolderApi.ListCars(uid);
        list.enqueue(new Callback<List<CarResponse>>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                cars = response.body();
                carRecyclerView.setAdapter(new CarListAdapter(cars));
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {
                System.out.println("Hiba a járművek lekárdezésekor...");
            }
        });

    }
}
