package com.noname.nonamerental.Service.Validation;

import com.noname.nonamerental.Model.UserInput;

import junit.framework.TestCase;

import org.junit.Assert;

public class RegisterValidationTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testIsUserInputCorrect() {
        UserInput input = new UserInput("Name","email@address.com","Address","00000","100000000");
        boolean expected = false;
        boolean result = true;
        try {
            result = RegisterValidation.IsUserInputCorrect(input);
        } catch (Exception e) {
            result = false;
        }
        Assert.assertEquals(expected, result);
    }
}