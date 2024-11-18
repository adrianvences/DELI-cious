package com.pluralsight.deliciousdeli.products;

import com.pluralsight.deliciousdeli.enums.SandWichSize;

public class PremiumMeat extends Product {
    public PremiumMeat(String name, double price, double smallPrice, double mediumPrice, double largePrice) {
        super(name, price, smallPrice, mediumPrice, largePrice);
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }

    public double setPrice(SandWichSize size) {
        switch (size) {
            case FOUR:
                return price = smallPrice;
            case EIGHT:
                return price = mediumPrice;
            case TWELVE:
                return price = largePrice;
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}



