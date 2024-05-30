package com.ps;

public abstract class Order {
    public String size;
    private String type;
    private double price;

    public Order(String size, String type, double price) {
        this.size = size;
        this.type = type;
        this.price = price;
    }

    public Order(double price) {
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



    public Order() {
    }


    protected abstract double calcPrice();
}
