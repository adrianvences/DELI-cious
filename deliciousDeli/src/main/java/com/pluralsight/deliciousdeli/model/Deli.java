package com.pluralsight.deliciousdeli.model;

import com.pluralsight.deliciousdeli.products.*;

import java.util.List;

public class Deli {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Bread> breads;
    private List<Chips> chips;
    private List<Drink> drinks;
    private List<PremiumCheese> cheeses;
    private List<PremiumMeat> meats;
    private List<Sauce> sauces;
    private List<Side> sides;
    private List<IncludedTopping> includedToppings;


    public Deli(String name, String address, String phoneNumber, List<Bread> breads, List<Chips> chips, List<Drink> drinks, List<PremiumCheese> cheeses, List<PremiumMeat> meats, List<Sauce> sauces, List<Side> sides, List<IncludedTopping> includedToppings) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.breads = breads;
        this.chips = chips;
        this.drinks = drinks;
        this.cheeses = cheeses;
        this.meats = meats;
        this.sauces = sauces;
        this.sides = sides;
        this.includedToppings = includedToppings;
    }

    // Generic addProduct method
    public <T> void addProduct(T product) {
        if (product instanceof Bread) {
            breads.add((Bread) product);
        } else if (product instanceof Chips) {
            chips.add((Chips) product);
        } else if (product instanceof Drink) {
            drinks.add((Drink) product);
        } else if (product instanceof PremiumCheese) {
            cheeses.add((PremiumCheese) product);
        } else if (product instanceof PremiumMeat) {
            meats.add((PremiumMeat) product);
        } else if (product instanceof Sauce) {
            sauces.add((Sauce) product);
        } else if (product instanceof Side) {
            sides.add((Side) product);
        } else if (product instanceof IncludedTopping) {
            includedToppings.add((IncludedTopping) product);
        } else {
            System.out.println("Product type not recognized: " + product.getClass().getName());
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Bread> getBreads() {
        return breads;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<PremiumCheese> getCheeses() {
        return cheeses;
    }

    public List<PremiumMeat> getMeats() {
        return meats;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public List<Side> getSides() {
        return sides;
    }

    public List<IncludedTopping> getIncludedToppings() {
        return includedToppings;
    }
}
