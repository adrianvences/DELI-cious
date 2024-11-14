package com.pluralsight.deliciousdeli.products;

public class Chips extends Product {
    public Chips(String name, double smallPrice, double mediumPrice, double largePrice) {
        super(name, smallPrice, mediumPrice, largePrice);
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return "Chips{" +
                "name='" + name + '\'' +
                ", smallPrice=" + smallPrice +
                ", mediumPrice=" + mediumPrice +
                ", largePrice=" + largePrice +
                '}';
    }
}
