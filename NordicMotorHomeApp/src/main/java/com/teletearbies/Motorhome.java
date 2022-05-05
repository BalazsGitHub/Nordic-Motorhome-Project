package com.teletearbies;

import java.util.ArrayList;

public class Motorhome {
    private int id;
    private String name;
    private Brand brand;
    private String fuelType;
    private double extraKilometer;
    private double speedometer;
    private ArrayList<Extra> extras;
    private boolean isServiced;
    private boolean isFuelHalf;


    public Motorhome(String name, Brand brand, String fuelType, double extraKilometer, double speedometer, ArrayList<Extra> extras, boolean isServiced, boolean isFuelHalf) {
        this.name = name;
        this.brand = brand;
        this.fuelType = fuelType;
        this.extraKilometer = extraKilometer;
        this.speedometer = speedometer;
        this.extras = extras;
        this.isServiced = isServiced;
        this.isFuelHalf = isFuelHalf;
    }

    public Motorhome(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getExtraKilometer() {
        return extraKilometer;
    }

    public void setExtraKilometer(double extraKilometer) {
        this.extraKilometer = extraKilometer;
    }

    public double getSpeedometer() {
        return speedometer;
    }

    public void setSpeedometer(double speedometer) {
        this.speedometer = speedometer;
    }

    public ArrayList<Extra> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<Extra> extras) {
        this.extras = extras;
    }

    public boolean isServiced() {
        return isServiced;
    }

    public void setServiced(boolean serviced) {
        isServiced = serviced;
    }

    public boolean isFuelHalf() {
        return isFuelHalf;
    }

    public void setFuelHalf(boolean fuelHalf) {
        isFuelHalf = fuelHalf;
    }
}
