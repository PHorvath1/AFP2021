package com.noname.nonamerental.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.noname.nonamerental.Controller.JsonPlaceHolderApi;
import com.noname.nonamerental.Model.Status;
import com.noname.nonamerental.R;
import com.noname.nonamerental.Service.Validation.LoginValidation;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    Button registerButton;
    Button loginButton;
    EditText userEmail;
    EditText userPassword;

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
        setContentView(R.layout.activity_login);

        registerButton = findViewById(R.id.loginRegisterButton);;
        loginButton = findViewById(R.id.loginLoginButton);
        userEmail = findViewById(R.id.loginUserEmailField);
        userPassword = findViewById(R.id.loginUserPasswordField);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    LoginValidation.IsUserInputCorrect(userEmail.getText().toString(),userPassword.getText().toString());
                    LoginUser(userEmail.getText().toString(),userPassword.getText().toString());
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }

    public void LoginUser(String userEmail, String userPassword){
        final String success = "success";
        Call<Status> Login = jsonPlaceHolderApi.LoginUser(userEmail, userPassword);
        Login.enqueue(new Callback<Status>() {

            @SneakyThrows
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {

                final String success = "success";

                if(response.body().getStatus().equals(success)){
                    System.out.println("Status check is correct");
                    startActivity(new Intent(Login.this,CarList.class));
                }
                else{
                    System.out.println("Wrong Password or Email");
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                System.out.println(t.getMessage());

            }
        });
    }

}