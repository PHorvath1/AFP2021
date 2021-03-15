package com.noname.nonamerental.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInput {
    private String name;
    private String email;
    private String password;
    private String address;
    private String phonenumber;
}
