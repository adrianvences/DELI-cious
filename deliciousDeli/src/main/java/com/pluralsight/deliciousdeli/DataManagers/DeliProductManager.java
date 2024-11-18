package com.pluralsight.deliciousdeli.DataManagers;

import com.pluralsight.deliciousdeli.enums.SandWichSize;
import com.pluralsight.deliciousdeli.model.Deli;
import com.pluralsight.deliciousdeli.products.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class DeliProductManager {
    // Lists to store all products
    private List<IncludedTopping> toppings;
    private List<Drink> drinks;
    private List<Chips> chips;
    private List<PremiumMeat> meats;
    private List<PremiumCheese> cheeses;
    private List<Sauce> sauces;
    private List<Side> sides;
    private List<Bread> breads;

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
                    double smallPrice = Double.parseDouble(productData[1]);
                    double mediumPrice = Double.parseDouble(productData[2]);
                    double largePrice = Double.parseDouble(productData[3]);
                    T product = factory.create(productName, 0, smallPrice, mediumPrice,largePrice);
                    products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public Deli getDeli(){
        Deli deli = new Deli("Delicious deli", "123 sandwich street", "980-222-2222",
                loadBreadsFromCSV("src/main/resources/menu-items/bread.csv"),
                loadChipsFromCSV("src/main/resources/menu-items/chips.csv"),
                loadDrinksFromCSV("src/main/resources/menu-items/drinks.csv"),
                loadPremiumToppingCheeseFromCSV("src/main/resources/menu-items/premiumToppingCheese.csv"),
                loadPremiumToppingsFromCSV("src/main/resources/menu-items/premiumToppingsMeats.csv"),
                loadSauceSelection("src/main/resources/menu-items/sauceSelection.csv"),
                loadSideSelection("src/main/resources/menu-items/sideSelection.csv"),
                loadToppingsFromCSV("src/main/resources/menu-items/regularToppings.csv")
                );
        return deli;
    }

    public List<Bread> loadBreadsFromCSV(String csvFile) {
        return breads = loadProductsFromCSV(csvFile, Bread::new);
    }

    public List<IncludedTopping> loadToppingsFromCSV(String csvFile) {
        return toppings = loadProductsFromCSV(csvFile , IncludedTopping::new);
    }

    public List<Chips> loadChipsFromCSV(String csvFile) {
        return chips = loadProductsFromCSV(csvFile , Chips::new);
    }

    public List<Drink> loadDrinksFromCSV(String csvFile) {
        return drinks = loadProductsFromCSV(csvFile, Drink::new);
    }

    public List<PremiumMeat> loadPremiumToppingsFromCSV(String csvFile) {
         return meats = loadProductsFromCSV(csvFile, PremiumMeat::new);
    }

    public List<PremiumCheese> loadPremiumToppingCheeseFromCSV(String csvFile) {
        return cheeses = loadProductsFromCSV(csvFile, PremiumCheese::new);
    }

    public List<Sauce> loadSauceSelection(String csvFile) {
        return sauces = loadProductsFromCSV(csvFile, Sauce::new);
    }

    public List<Side> loadSideSelection(String csvFile) {
        return sides = loadProductsFromCSV(csvFile, Side::new);
    }

    public <T> void displayProducts(String productType, List<T> productList) {
        System.out.println(productType);
//        productList.forEach(System.out::println);
        for (int i = 0; i < productList.size(); i++) {
            T product = productList.get(i);
            System.out.println((i + 1) + ") " + product);
        }// Increment index by 1
    }

    public void displaySandwichSizes() {
        System.out.println("Select your sandwich size:");
        // Loop through the enum values to show options
        for (int i = 0; i < SandWichSize.values().length; i++) {
            SandWichSize size = SandWichSize.values()[i];
            // Display size as 1 = FOUR, 2 = EIGHT, 3 = TWELVE
            System.out.println((i + 1) + ") " + size.name().toLowerCase() + " inch");
        }
    }

    public SandWichSize getSandwichSizeFromChoice(String sizeChoice) {
        try {
            // Convert the user's input to an index and check if it's valid
            int index = Integer.parseInt(sizeChoice) - 1; // Convert to zero-based index
            if (index >= 0 && index < SandWichSize.values().length) {
                return SandWichSize.values()[index]; // Return the selected size
            }
        } catch (NumberFormatException e) {
            // Handle invalid input
            System.out.println("Invalid input. Please enter a valid number.");
        }
        return null; // Return null if the selection is invalid
    }





    // Getters
    public List<IncludedTopping> getToppings() {
        return toppings;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }
}
