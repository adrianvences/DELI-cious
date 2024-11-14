package com.pluralsight.deliciousdeli.products;


public abstract class Product {
    protected String name;
    protected double smallPrice;
    protected double mediumPrice;
    protected double largePrice;

    public Product(String name, double smallPrice, double mediumPrice, double largePrice) {
        this.name = name;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    public String getName() {
        return name;
    }

    public double getSmallPrice() {
        return smallPrice;
    }

    public double getMediumPrice() {
        return mediumPrice;
    }

    public double getLargePrice() {
        return largePrice;
    }

    public abstract double calculateProductTotal();
}