package com.pluralsight.deliciousdeli.enums;

public enum SandWichSize {

    // Enum constants representing different sandwich sizes with base price
    FOUR(5.50),
    EIGHT(7.00),
    TWELVE(8.50);

    // field to store base price
    final double basePrice;

    // Constructor for SandWichSize
    SandWichSize (double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
