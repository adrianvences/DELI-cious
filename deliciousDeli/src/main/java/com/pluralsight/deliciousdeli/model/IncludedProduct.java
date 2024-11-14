package com.pluralsight.deliciousdeli.model;

public interface IncludedProduct<T> {
    // Method to create a product with just a name and price
    T create(String name, double price);

    // Method to create a product with name, price, medium price, and large price
//    T create(String name, double price, double mediumPrice, double largePrice);
}