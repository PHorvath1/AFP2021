package com.noname.nonamerental.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noname.nonamerental.Controller.JsonPlaceHolderApi;
import com.noname.nonamerental.Controller.RentalListAdapter;
import com.noname.nonamerental.Model.CarResponse;
import com.noname.nonamerental.Model.RentalResponse;
import com.noname.nonamerental.R;

import java.util.List;

import lombok.Getter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MyRentalsFragment  extends Fragment {


    @Getter
    private static RecyclerView rentalRecyclerView;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private static JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    private static List<RentalResponse> rentals;


    private int userId;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //userId = getArguments().getInt("UserId");
        View root = inflater.inflate(R.layout.fragment_myrentals,container,false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rentalRecyclerView = view.findViewById(R.id.myRentalRecyclerView);
        rentalRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        try {
            listRentals(userId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listRentals(int uid){
        Call<List<RentalResponse>> list = jsonPlaceHolderApi.ListRentals(uid);
        list.enqueue(new Callback<List<RentalResponse>>() {
            @Override
            public void onResponse(Call<List<RentalResponse>> call, Response<List<RentalResponse>> response) {
                rentals = response.body();
                rentalRecyclerView.setAdapter(new RentalListAdapter(rentals,getContext()));
            }

            @Override
            public void onFailure(Call<List<RentalResponse>> call, Throwable t) {

            }
        });
    }

}
