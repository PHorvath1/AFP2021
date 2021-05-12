package com.noname.nonamerental;

import com.noname.nonamerental.Views.Fragments.CarListFragment;

import junit.framework.TestCase;

public class CarListFragmentTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testListCars() {
        CarListFragment instance = new CarListFragment();
        instance.listCars(2);
    }
}