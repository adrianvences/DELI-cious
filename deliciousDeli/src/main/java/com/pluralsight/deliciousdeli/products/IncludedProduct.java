package com.pluralsight.deliciousdeli.products;

public interface IncludedProduct<T> {
    // Method to create a product with name, price, medium price, and large price
    T create(String name, double price, double smallPrice, double mediumPrice, double largePrice);
}