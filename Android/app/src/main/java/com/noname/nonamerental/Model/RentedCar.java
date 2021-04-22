package com.noname.nonamerental.Model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RentedCar {
    private int cid;
    private int uid;
    private Date rental_time;
    private int rental_price;

}
