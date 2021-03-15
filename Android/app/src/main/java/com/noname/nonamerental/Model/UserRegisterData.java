package com.noname.nonamerental.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
public class UserRegisterData {
    private String name;
    private String email;
    private String password;
    private String address;
    private int phonenumber;
}
