package com.pluralsight.deliciousdeli.model;

public class Drink extends Product{
    private double mediumPrice;
    private double largePrice;

    public Drink(String name, double startingPrice, double mediumPrice, double largePrice) {
        super(name, startingPrice);
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    @Override
    public double calculateProductTotal() {
        return startingPrice;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "smallPrice=" +
                ", mediumPrice=" + mediumPrice +
                ", largePrice=" + largePrice +
                ", name='" + name + '\'' +
                ", startingPrice=" + startingPrice +
                '}';
    }

}
