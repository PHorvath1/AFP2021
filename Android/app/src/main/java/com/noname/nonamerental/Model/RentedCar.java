package com.noname.nonamerental.Model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RentedCar {
    private int uid;
    private int cid;
    private Date rental_time;
    private int rental_price;

}
