package com.noname.nonamerental.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarResponse {
    private int id;
    private String brand;
    private String type;
    private String image;

}
