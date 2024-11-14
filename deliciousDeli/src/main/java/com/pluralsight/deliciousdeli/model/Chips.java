package com.pluralsight.deliciousdeli.model;

public class Chips extends Product {
    public Chips(String name, double startingPrice) {
        super(name, startingPrice);
    }

    @Override
    public double calculateProductTotal() {
        return startingPrice;
    }

    @Override
    public String toString() {
        return "Chips{" +
                "name='" + name + '\'' +
                ", startingPrice=" + startingPrice +
                '}';
    }
}
