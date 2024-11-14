package com.pluralsight.deliciousdeli.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class DeliProductManager {
    // Lists to store all products
    private List<Topping> toppings;
    private List<Drink> drinks;
    private List<Chips> chips;

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
                // for products with more than one price
                if (productData.length == 4) {
                    double mediumPrice = Double.parseDouble(productData[2]);
                    double largePrice = Double.parseDouble(productData[3]);
//                    T product = factory.create(productName, price, mediumPrice,largePrice);
                    T product = factory.create(productName, price);
                    products.add(product);
                } else {
                    T product = factory.create(productName, price);
                    products.add(product);
                }
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

//    public void loadDrinksFromCSV(String csvFile) {
//        drinks = loadProductsFromCSV(csvFile, (name, price, mediumPrice, largePrice) -> {
//            return new Drink(name, price, mediumPrice, largePrice);
//        });
//    }

    public void displayProducts() {
        System.out.println("Toppings");
        toppings.forEach(System.out::println);
        System.out.println("chips");
        chips.forEach(System.out::println);
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
