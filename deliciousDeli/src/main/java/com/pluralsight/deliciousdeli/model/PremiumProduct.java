package com.pluralsight.deliciousdeli.model;

public interface PremiumProduct<T> {
    // Method to create a product with name, price, medium price, and large price
    T create(String name, double price, double mediumPrice, double largePrice);
}
