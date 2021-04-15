package com.noname.nonamerental.Model;

public class Car {
    private int id;
    private String brand;
    private String type;
    private String category;
    private String description;
    private int price;
    private int quantity;
    private String image;

    public Car(int id, String brand, String type, String category, String description, int price, int quantity, String image) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
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

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }
}
