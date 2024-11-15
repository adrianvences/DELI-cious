package com.pluralsight.deliciousdeli.products;

public class Chips extends Product {
    public Chips(String name, double price, double smallPrice, double mediumPrice, double largePrice) {
        super(name, price, smallPrice, mediumPrice, largePrice);
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
