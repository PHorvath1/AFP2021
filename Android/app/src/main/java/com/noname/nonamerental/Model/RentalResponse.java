package com.noname.nonamerental.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RentalResponse {
    private int uid;
    private int cid;
    private String date;
    private int rentalPrice;
}
