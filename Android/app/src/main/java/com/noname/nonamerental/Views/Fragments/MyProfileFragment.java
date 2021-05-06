package com.noname.nonamerental.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noname.nonamerental.Controller.JsonPlaceHolderApi;
import com.noname.nonamerental.Model.UserData;
import com.noname.nonamerental.R;

import java.util.List;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyProfileFragment extends Fragment {
    private TextView tvName;
    private TextView tvAddress;
    private TextView tvEmail;
    private TextView tvPhoneNumber;

    private Button btnChangePassword;
    private EditText inputCurrentPassword;
    private EditText inputNewPassword;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private static JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    private int userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_myprofile,container,false);

        userId = getArguments().getInt("UserId");

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = view.findViewById(R.id.tv_user_name);
        tvAddress = view.findViewById(R.id.tv_user_adress);
        tvEmail = view.findViewById(R.id.tv_user_email);
        tvPhoneNumber = view.findViewById(R.id.tv_user_phone);

        inputCurrentPassword = view.findViewById(R.id.input_current_password);
        inputNewPassword = view.findViewById(R.id.input_new_password);
        btnChangePassword = view.findViewById(R.id.btn_change_password);

        try {
            showUser(userId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputCurrentPassword.getText().toString() != inputNewPassword.getText().toString()) {
                    updatePassword(userId);
                }
            }
        });
    }

    public void showUser(int uid) {
        Call<List<UserData>> list = jsonPlaceHolderApi.GetUserData(uid);
        list.enqueue(new Callback<List<UserData>>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                tvName.setText(response.body().get(0).getName());
                tvAddress.setText(response.body().get(0).getAddress());
                tvEmail.setText(response.body().get(0).getEmail());
                tvPhoneNumber.setText(String.valueOf(response.body().get(0).getPhone_number()));
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                System.out.println("Hiba az adatok lekérdezésekor...");
            }
        });
    }

    private void updatePassword(int uid) {
        Call<String> status = jsonPlaceHolderApi.ChangePassword(uid, inputCurrentPassword.getText().toString(), inputNewPassword.getText().toString());
        status.enqueue(new Callback<String>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getContext(),"Sikeres jelszóváltoztatás...", Toast.LENGTH_SHORT);
                HomeFragment home = new HomeFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("UserId",userId);
                home.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, home, "HomeFragmentTag").commit();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
