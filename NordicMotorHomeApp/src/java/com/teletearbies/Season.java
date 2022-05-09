package com.teletearbies;

public class Season {
    private String name;
    private double dailySeasonPrice;

    public Season(){}

    public Season(String name, double dailySeasonPrice){
        this.name=name;
        this.dailySeasonPrice=dailySeasonPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDailySeasonPrice() {
        return dailySeasonPrice;
    }

    public void setDailySeasonPrice(double dailySeasonPrice) {
        this.dailySeasonPrice = dailySeasonPrice;
    }
}
