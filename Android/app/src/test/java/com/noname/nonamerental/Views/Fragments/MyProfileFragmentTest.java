package com.noname.nonamerental.Views.Fragments;

import junit.framework.TestCase;

public class MyProfileFragmentTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testShowUser() {
        MyProfileFragment instance = new MyProfileFragment();
        try {
            instance.showUser(0);
        } catch (Exception e) {
            fail("Hiba a showUser parancsban!");
        }
    }
}