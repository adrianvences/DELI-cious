package com.pluralsight.deliciousdeli.model;

public class PremiumTopping extends Product {
    private double fourPrice;
    private double eightPrice;
    private double twelvePrice;

    public PremiumTopping(String name, double startingPrice, double fourPrice, double eightPrice, double twelvePrice) {
        super(name, startingPrice);
        this.fourPrice = fourPrice;
        this.eightPrice = eightPrice;
        this.twelvePrice = twelvePrice;
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }

    public double getFourPrice() {
        return fourPrice;
    }

    public void setFourPrice(double fourPrice) {
        this.fourPrice = fourPrice;
    }

    public double getEightPrice() {
        return eightPrice;
    }

    public void setEightPrice(double eightPrice) {
        this.eightPrice = eightPrice;
    }

    public double getTwelvePrice() {
        return twelvePrice;
    }

    public void setTwelvePrice(double twelvePrice) {
        this.twelvePrice = twelvePrice;
    }
}
