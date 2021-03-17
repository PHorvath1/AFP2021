package com.noname.nonamerental.Service.Validation;

public abstract class LoginValidation {

    public static boolean IsUserInputCorrect(String userEmail, String userPassword) throws Exception {
        if(userEmail != null && userPassword != null ){
            return true;
        }
        else throw new Exception("User E-mail or Password is missing!");
    }
}
