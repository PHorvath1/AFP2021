package com.noname.nonamerental.Views;

import com.noname.nonamerental.Model.Car;
import com.noname.nonamerental.Model.RentedCar;

import junit.framework.TestCase;

public class CarViewTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetCarInfo() {
        try {
            CarView instance = new CarView();
            int uid = 1;
            int cid = 1;
            instance.getCarInfo(uid, cid);
        }catch (Exception e){
            fail("Hiba az autó lekérésekor");
        }
    }

    public void testRentCar() {
        try {
            CarView instance = new CarView();
            RentedCar car = new RentedCar(1, 1, "2021-10-10", 2000);
            instance.rentCar(car);
        }catch (Exception e){
            fail("Hiba az autó kölcsönzésekor");
        }
    }

    public void testDecreaseQuantity() {
        try {
            CarView instance = new CarView();
            instance.decreaseQuantity(1);
        }
        catch (Exception e){
            fail("Hiba a szám csökkentésekor");
        }
    }
}