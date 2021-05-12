package com.noname.nonamerental.Service.Validation;

import junit.framework.TestCase;

public class LoginValidationTest extends TestCase {
    public void testLoginValidation(){
        String username = "Teszt@teszt.com";
        String password = "tesztpass";
        boolean result;
        boolean expResult = true;
        try {
            result = LoginValidation.IsUserInputCorrect(username,password);
        } catch (Exception e) {
            result = false;
        }
        assertEquals(expResult, result);

    }
}