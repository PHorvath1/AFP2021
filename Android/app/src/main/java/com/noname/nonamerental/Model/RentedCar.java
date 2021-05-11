package com.noname.nonamerental.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RentedCar {
    private int uid;
    private int cid;
    private String rental_time;
    private int rental_price;

}
