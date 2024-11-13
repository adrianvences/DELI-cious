package com.pluralsight.deliciousdeli.model;

public class PremiumTopping extends Product {

    public PremiumTopping(String name, double startingPrice) {
        super(name, startingPrice);
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }
}
