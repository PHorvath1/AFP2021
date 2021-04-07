package com.noname.nonamerental.Model;

public class CarResponse {
    private int id;
    private String brand;
    private String type;
    private String image;

    public CarResponse(int id, String brand, String type, String image) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }
}
