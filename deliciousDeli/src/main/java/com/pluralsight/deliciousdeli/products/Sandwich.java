package com.pluralsight.deliciousdeli.products;

import com.pluralsight.deliciousdeli.enums.SandWichSize;

import java.util.List;

public class Sandwich {
    private Bread breadChoice;
    private SandWichSize sandwichSize;
    private boolean toasted;
    private List<Object> toppings;

    public Sandwich(Bread breadChoice, SandWichSize sandwichSize, boolean toasted, List<Object> toppings) {
        this.breadChoice = breadChoice;
        this.sandwichSize = sandwichSize;
        this.toasted = toasted;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadChoice=" + breadChoice +
                ", sandwichSize=" + sandwichSize +
                ", toasted=" + toasted +
                ", toppings=" + toppings +
                '}';
    }
}
