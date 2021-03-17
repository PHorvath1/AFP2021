package com.noname.nonamerental.Service.Validation;

import com.noname.nonamerental.Model.UserInput;

public abstract class  RegisterValidation {

    public static boolean IsUserInputCorrect(UserInput user) throws Exception {
        try {
            if (user.getName() != null && user.getEmail() != null && user.getAddress() != null && user.getPassword() != null && IsUserPhoneNumberCorrect(user.getPhonenumber())) {
                return true;
            }
        }
        catch (Exception e){
            throw e;
        }
        return false;
    }

    private static  boolean IsUserPhoneNumberCorrect(String phoneNumber) throws Exception{
        int temp;
        if (tryParseInt(phoneNumber)){
            temp = Integer.valueOf(phoneNumber);
            if (100000000 < temp && temp < 999999999){
                return true;
            }
        }
        throw new Exception("The Given Phone Number format is incorrect!");
    }
    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
