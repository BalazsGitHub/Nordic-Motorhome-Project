package com.teletearbies;

public class Cancellation {
    private String type;
    private double percentage;

    public Cancellation(){}

    public Cancellation(String type, double percentage) {
        this.type = type;
        this.percentage = percentage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
