package com.pluralsight.deliciousdeli.model;

import com.pluralsight.deliciousdeli.products.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class DeliProductManager {
    // Lists to store all products
    private List<Topping> toppings;
    private List<Drink> drinks;
    private List<Chips> chips;
    private List<PremiumMeat> meats;
    private List<PremiumCheese> cheeses;
    private List<Sauce> sauces;
    private List<Side> sides;

    // Constructor
    public DeliProductManager() {
        this.toppings = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    // Util method to load from csv

    public <T> List<T> loadProductsFromCSV(String csvFilePath , IncludedProduct<T> factory) {
        List<T> products = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(csvFilePath);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line;
            buffReader.readLine();
            while ((line = buffReader.readLine()) != null) {
                String[] productData = line.split("\\|");
                    String productName = productData[0];
                    double price = Double.parseDouble(productData[1]);
                    double mediumPrice = Double.parseDouble(productData[2]);
                    double largePrice = Double.parseDouble(productData[3]);
                    T product = factory.create(productName, price, mediumPrice,largePrice);
                    products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public void loadToppingsFromCSV(String csvFile) {
        toppings = loadProductsFromCSV(csvFile , Topping::new);
    }

    public void loadChipsFromCSV(String csvFile) {
        chips = loadProductsFromCSV(csvFile , Chips::new);
    }

    public void loadDrinksFromCSV(String csvFile) {
        drinks = loadProductsFromCSV(csvFile, Drink::new);
    }

    public void loadPremiumToppingsFromCSV(String csvFile) {
         meats = loadProductsFromCSV(csvFile, PremiumMeat::new);
    }

    public void loadPremiumToppingCheeseFromCSV(String csvFile) {
        cheeses = loadProductsFromCSV(csvFile, PremiumCheese::new);
    }

    public void loadSauceSelection(String csvFile) {
        sauces = loadProductsFromCSV(csvFile, Sauce::new);
    }

    public void loadSideSelection(String csvFile) {
        sides = loadProductsFromCSV(csvFile, Side::new);
    }

    public void displayProducts() {
        System.out.println("Toppings");
        toppings.forEach(System.out::println);
        System.out.println("Chips");
        chips.forEach(System.out::println);
        System.out.println("Drinks");
        drinks.forEach(System.out::println);
        System.out.println("PremiumMeats");
        meats.forEach(System.out::println);
        System.out.println("cheese");
        cheeses.forEach(System.out::println);
        System.out.println("sides");
        sides.forEach(System.out::println);
        System.out.println("sauces");
        sauces.forEach(System.out::println);
    }

    // Getters
    public List<Topping> getToppings() {
        return toppings;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }
}
