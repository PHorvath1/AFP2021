package com.noname.nonamerental.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserData {
    public String name;
    public String email;
    public String address;
    public int phone_number;
}
