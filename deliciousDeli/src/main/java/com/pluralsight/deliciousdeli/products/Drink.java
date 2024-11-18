package com.pluralsight.deliciousdeli.products;

public class Drink extends Product {

    public Drink(String name, double price, double smallPrice, double mediumPrice, double largePrice) {
        super(name, price, smallPrice, mediumPrice, largePrice);
    }

    @Override
    public double calculateProductTotal() {
        return price; // Return the price for the selected size
    }

    @Override
    public String toString() {
        return name; // Return the name of the drink
    }

}
