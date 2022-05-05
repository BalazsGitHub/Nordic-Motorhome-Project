package com.teletearbies;

public class Brand {
    private String name;
    private String model;
    private double dailyBrandPrice;
    private int capacity;

    public Brand(String name, String model, double dailyBrandPrice, int capacity) {
        this.name = name;
        this.model = model;
        this.dailyBrandPrice = dailyBrandPrice;
        this.capacity = capacity;
    }

    public Brand(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDailyBrandPrice() {
        return dailyBrandPrice;
    }

    public void setDailyBrandPrice(double dailyBrandPrice) {
        this.dailyBrandPrice = dailyBrandPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
