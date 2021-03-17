package com.noname.nonamerental.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.noname.nonamerental.Controller.RegisterController;
import com.noname.nonamerental.Model.UserInput;
import com.noname.nonamerental.Model.UserRegisterData;
import com.noname.nonamerental.Service.Validation.RegisterValidation;
import com.noname.nonamerental.R;


public class Register extends AppCompatActivity {

    private UserInput userInput;
    private Button submitButton;
    private EditText nameInput;
    private EditText emailInput;
    private EditText addressInput;
    private EditText phoneNumberInput;
    private EditText passwordInput;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backButton = findViewById(R.id.registerBackButton);
        nameInput = findViewById(R.id.registerUserNameField);
        emailInput = findViewById(R.id.registerUserEmailField);
        addressInput = findViewById(R.id.registerUserAddressField);
        phoneNumberInput = findViewById(R.id.registerUserPhonenumberField);
        passwordInput = findViewById(R.id.registerUserPasswordField);
        submitButton = findViewById(R.id.registerSubmitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = new UserInput(
                        nameInput.getText().toString(),
                        emailInput.getText().toString(),
                        passwordInput.getText().toString(),
                        addressInput.getText().toString(),
                        phoneNumberInput.getText().toString());

                try{
                   RegisterValidation.IsUserInputCorrect(userInput);
                   RegisterController.RegisterUser(new UserRegisterData(
                      userInput.getName(),
                      userInput.getEmail(),
                      userInput.getPassword(),
                      userInput.getAddress(),
                      Integer.valueOf(userInput.getPhonenumber())
                      ));
                   Toast.makeText(getApplicationContext(),"Successful registration...",Toast.LENGTH_SHORT).show();
                   Thread.sleep(1000);
                   startActivity(new Intent(Register.this,Login.class));

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();

                }

            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });

    }
}