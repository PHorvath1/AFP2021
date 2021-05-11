package com.noname.nonamerental.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RentalResponse {
    private String brand;
    private String type;
    private String image;
    private String rental_time;
    private int rental_price;
}
