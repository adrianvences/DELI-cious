package com.pluralsight.deliciousdeli.products;

public class Bread extends Product{

    public Bread(String name, double smallPrice, double mediumPrice, double largePrice) {
        super(name, smallPrice, mediumPrice, largePrice);
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "name='" + name + '\'' +
                ", smallPrice=" + smallPrice +
                ", mediumPrice=" + mediumPrice +
                ", largePrice=" + largePrice +
                '}';
    }
}
