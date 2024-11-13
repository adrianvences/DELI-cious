package com.pluralsight.deliciousdeli.model;

public class Topping extends Product {

    public Topping(String name, double startingPrice) {
        super(name, startingPrice);
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }
}
