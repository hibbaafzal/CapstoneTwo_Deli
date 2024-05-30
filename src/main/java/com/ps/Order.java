package com.ps;

public abstract class Order {
    private String size;
    private String type;
    private double price;

    public Order(String size, String type, double price) {
        this.size = size;
        this.type = type;
        this.price = price;
    }


    // Getters and Setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }




    public Order() {
    }


    public Order(double price) {
    }



}
