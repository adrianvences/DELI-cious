package com.pluralsight.deliciousdeli.enums;

import com.sun.source.tree.ReturnTree;

public enum PremiumTopping {
    STEAK(1.00,2.00,3.00),
    HAM(1.00,2.00,3.00),
    SALAMI(1.00,2.00,3.00),
    ROAST_BEEF(1.00,2.00,3.00),
    CHICKEN(1.00,2.00,3.00),
    BACON(1.00,2.00,3.00),
    AMERICAN(.75,1.50,2.25),
    PROVOLONE(.75,1.50,2.25),
    CHEDDAR(.75,1.50,2.25),
    SWISS(.75,1.50,2.25),
    EXTRA_CHEESE(.30,.60,.90),
    EXTRA_MEAT(.50,1.00,1.50);

    // class Fields // instance var // member var // attributes // properties
    private final double priceFor4Inch;
    private final double priceFor8Inch;
    private final double priceFor12Inch;

    // constructor
    PremiumTopping(double priceFor4Inch, double priceFor8Inch, double priceFor12Inch) {
        this.priceFor4Inch = priceFor4Inch;
        this.priceFor8Inch = priceFor8Inch;
        this.priceFor12Inch = priceFor12Inch;
    }

    // uses sandwich size to get topping price
    public double getPriceForSize(SandWichSize size) {
        // switch expression for more concise code
        return switch (size) {
            case FOUR -> priceFor4Inch;
            case EIGHT -> priceFor8Inch;
            case TWELVE -> priceFor12Inch;
            default -> throw new IllegalArgumentException("Invalid sandwich size: " + size);
        };
     }



}
