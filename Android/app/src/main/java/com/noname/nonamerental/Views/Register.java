package com.noname.nonamerental.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.noname.nonamerental.Controller.RegisterController;
import com.noname.nonamerental.Model.UserInput;
import com.noname.nonamerental.Model.UserRegisterData;
import com.noname.nonamerental.R;

public class Register extends AppCompatActivity {

    private UserInput userInput;
    private Button submitButton;
    private EditText nameInput;
    private EditText emailInput;
    private EditText addressInput;
    private EditText phoneNumberInput;
    private EditText passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = findViewById(R.id.registerUserNameField);
        emailInput = findViewById(R.id.registerUserEmailField);
        addressInput = findViewById(R.id.registerUserAddressField);
        phoneNumberInput = findViewById(R.id.registerUserPhonenumberField);
        passwordInput = findViewById(R.id.registerUserPasswordField);
        submitButton = findViewById(R.id.registerSubmit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userInput = new UserInput(
                        nameInput.getText().toString(),
                        emailInput.getText().toString(),
                        passwordInput.getText().toString(),
                        addressInput.getText().toString(),
                        phoneNumberInput.getText().toString());

                if (isUserInputCorrect(userInput)){
                   RegisterController.RegisterUser(new UserRegisterData(
                      userInput.getName(),
                      userInput.getEmail(),
                      userInput.getPassword(),
                      userInput.getAddress(),

                      Integer.valueOf(userInput.getPhonenumber())
                   ));
                }
                else{
                    Toast.makeText(getApplicationContext(),"User Input is not correct",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    private boolean isUserInputCorrect(UserInput user) {
        if (user.getName() == null || user.getEmail() == null || user.getAddress() == null || user.getPassword() == null || !IsUserPhoneNumberCorrect(user.getPhonenumber())){
            return false;
        }
        else return true;
    }

    private boolean IsUserPhoneNumberCorrect(String phoneNumber){
        int temp;
        if (tryParseInt(phoneNumber)){
            temp = Integer.valueOf(phoneNumber);
            if (100000000 < temp && temp < 999999999){
                return true;
            }
        }
        return false;
    }
    boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}