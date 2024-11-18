package com.pluralsight.deliciousdeli.products;

import com.pluralsight.deliciousdeli.enums.SandWichSize;

public class PremiumCheese extends Product{
    public PremiumCheese(String name, double price, double smallPrice, double mediumPrice, double largePrice) {
        super(name, price, smallPrice, mediumPrice, largePrice);
    }

    @Override
    public double calculateProductTotal() {
        return 0;
    }


    public void setPrice(SandWichSize size) {
        switch (size) {
            case FOUR:
                this.price = smallPrice;
            case EIGHT:
                this.price = mediumPrice;
            case TWELVE:
                this.price = largePrice;
            default:
                this.price = 0.0;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
