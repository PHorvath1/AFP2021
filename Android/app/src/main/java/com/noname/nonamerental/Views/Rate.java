package com.noname.nonamerental.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noname.nonamerental.Controller.JsonPlaceHolderApi;
import com.noname.nonamerental.Model.RateData;
import com.noname.nonamerental.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rate extends AppCompatActivity {
    private Button btnSend;
    private Button btnNoThanks;
    private RadioGroup rates;
    private int userId;

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
        setContentView(R.layout.activity_rate);

        btnSend = findViewById(R.id.btn_send);
        btnNoThanks = findViewById(R.id.btn_nothanks);
        rates = findViewById(R.id.rates);

        userId = getIntent().getIntExtra("uid", 1);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    RadioButton rate = findViewById(rates.getCheckedRadioButtonId());
                    sendRate(userId, Integer.parseInt(rate.getText().toString()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        btnNoThanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Rate.this, Login.class));
            }
        });
    }

    public void sendRate(int uid, int value) {
        RateData rateData = new RateData(uid, value);
        Call<String> call = jsonPlaceHolderApi.Rate(rateData);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    startActivity(new Intent(Rate.this, Login.class));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
