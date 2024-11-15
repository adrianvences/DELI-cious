package com.pluralsight.deliciousdeli.products;

public class Sauce extends Product{

    public Sauce(String name, double smallPrice, double mediumPrice, double largePrice) {
        super(name, smallPrice, mediumPrice, largePrice);
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
