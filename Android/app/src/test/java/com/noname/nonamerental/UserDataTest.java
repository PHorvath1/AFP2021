package com.noname.nonamerental;

import com.noname.nonamerental.Model.UserData;

import junit.framework.TestCase;

import org.junit.Assert;

public class UserDataTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetName() {
        UserData instance = new UserData("Name","email@address.com","Address",1000000000);
        String expected = "Name";
        String result = instance.getName();
        Assert.assertSame(expected, result);
    }

    public void testGetEmail() {
        UserData instance = new UserData("Name","email@address.com","Address",1000000000);
        String expected = "email@address.com";
        String result = instance.getEmail();
        Assert.assertSame(expected, result);
    }

    public void testGetAddress() {
        UserData instance = new UserData("Name","email@address.com","Address",1000000000);
        String expected = "Address";
        String result = instance.getAddress();
        Assert.assertSame(expected, result);
    }

    public void testGetPhone_number() {
        UserData instance = new UserData("Name","email@address.com","Address",1000000000);
        int expected = 1000000000;
        int result = instance.getPhone_number();
        Assert.assertEquals(expected, result);
    }
}