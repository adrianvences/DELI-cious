package com.pluralsight.deliciousdeli.products;

import com.pluralsight.deliciousdeli.enums.SandWichSize;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private Bread breadChoice;
    private SandWichSize sandwichSize;
    private boolean toasted;
    private List<Object> toppings;

    public Sandwich(Bread breadChoice, SandWichSize sandwichSize, boolean toasted, List<Object> toppings) {
        super("Sandwich", breadChoice.getPrice(), breadChoice.smallPrice, breadChoice.mediumPrice, breadChoice.largePrice);
        this.breadChoice = breadChoice;
        this.sandwichSize = sandwichSize;
        this.toasted = toasted;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Sandwich {" +
                "\n  Bread Choice: " + breadChoice +
                "\n  Sandwich Size: " + sandwichSize +
                "\n  Toasted: " + (toasted ? "Yes" : "No") +
                "\n  Toppings: " + toppings +
                "\n  Total Price: $" + String.format("%.2f", calculateProductTotal()) +
                "\n}";
    }

    @Override
    public double calculateProductTotal() {
        double basePrice = switch (sandwichSize) {
            case FOUR -> breadChoice.getSmallPrice();
            case EIGHT -> breadChoice.getMediumPrice();
            case TWELVE -> breadChoice.getLargePrice();
        };

        // Add the price of the toppings
        double toppingsPrice = 0.0;
        for (Object toppingList : toppings) {
            for(Product topping: (ArrayList<Product>) toppingList){
                toppingsPrice += topping.getPrice();
            }
        }
        return basePrice + toppingsPrice;
    }

    public List<Object> getToppings(){
        return toppings;
    }

    @Override
    public double getPrice() {
        double basePrice = switch (sandwichSize) {
            case FOUR -> breadChoice.getSmallPrice();
            case EIGHT -> breadChoice.getMediumPrice();
            case TWELVE -> breadChoice.getLargePrice();
        };

        // Add the price of the toppings
        double toppingsPrice = 0.0;
        for (Object toppingList : toppings) {
            for(Product topping: (ArrayList<Product>) toppingList){
                toppingsPrice += topping.getPrice();
            }
        }

        return basePrice + toppingsPrice;
    }

}
