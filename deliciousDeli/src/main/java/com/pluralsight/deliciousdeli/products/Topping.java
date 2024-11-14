package com.pluralsight.deliciousdeli.products;

public class Topping extends Product {

    public Topping(String name, double smallPrice, double mediumPrice, double largePrice) {
        super(name, smallPrice, mediumPrice, largePrice);
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", smallPrice=" + smallPrice +
                ", mediumPrice=" + mediumPrice +
                ", largePrice=" + largePrice +
                '}';
    }
}
