package com.pluralsight.deliciousdeli.model;
import com.pluralsight.deliciousdeli.DataManagers.DeliProductManager;
import com.pluralsight.deliciousdeli.DataManagers.ReceiptManager;
import com.pluralsight.deliciousdeli.enums.SandWichSize;
import com.pluralsight.deliciousdeli.products.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    // Scanner to read user input from terminal
    static Scanner scanner = new Scanner(System.in);
    Deli deliProducts;
    DeliProductManager productsFileManager;
    Order currentOrder;

    // *** Home Screen Method *** //
    public void homeScreen() {
        init();
        // Boolean Flag to exit while loop
        boolean loopFlag = true;
        // While loop to keep home screen iterating through switch cases.
        while (loopFlag) {
            // input variable that stores users input through promptMaker method for cleaner code.
            String input = Prompts.homePrompt();
            switch (input) {
                // New Order
                case "1":
                    orderScreen();
                    break;
                // Exit
                case "0":
                    System.out.println("Exit");
                    loopFlag = false;
                    break;
                // In case of invalid input. Default gives back an invalid input message.
                default:
                    System.out.println("Invalid input");
            }

        }
    }

    // *** Order Screen Method *** //
    public void orderScreen() {
        boolean flag = true;
        String customerName = Prompts.promptMaker("Please enter your name: ");
        currentOrder = new Order(generateOrderId(), customerName);

        while (flag) {

            String input = Prompts.orderPrompt();

            switch (input) {
                // New Order
                case "1":
                    Sandwich sandwich = processAddSandwichRequest();
                    currentOrder.addProduct(sandwich);
                    currentOrder.addToppings(sandwich);

                    break;
                // Add drink
                case "2":
                    Drink drink = processAddDrinkRequest();
                    currentOrder.addProduct(drink);
                    break;
                // Add Chips
                case "3":
                    Chips chips = processGetChipsRequest();
                    currentOrder.addProduct(chips);
                    break;
                // Checkout
                case "4":
                    checkout();
                    ReceiptManager.writeOrderToCSV(currentOrder, "src/main/resources/orders.csv");
                    break;
                // Exit
                case "0":
                    System.out.println("Exit");
                    flag = false;
                    break;
                // In case of invalid input. Default gives back an invalid input message.
                default:
                    System.out.println("Invalid input");
            }

        }
    }

    public void init() {
        productsFileManager = new DeliProductManager();
        this.deliProducts = productsFileManager.getDeli();
        if (this.deliProducts != null) {
            System.out.println("deli loaded");
        } else {
            System.out.println("deli not loaded, check file");
        }
    }

    public Sandwich processAddSandwichRequest() {
        // select bread
        List<Bread> breads = deliProducts.getBreads();
        productsFileManager.displayProducts("Bread choices: ", breads);
        String breadChoice = Prompts.promptMaker("Select your bread choice by number (digit): ");
        Bread selectedBread = breads.get(Integer.parseInt(breadChoice) - 1);
        System.out.println(selectedBread);

        // select sandwich size
        productsFileManager.displaySandwichSizes();
        String sizeChoice = Prompts.promptMaker("Select your sandwich size by number (digit): ");
        SandWichSize sandwichSize = productsFileManager.getSandwichSizeFromChoice(sizeChoice);
        System.out.println(sandwichSize);


        // select meat
        List<PremiumMeat> premiumMeats = deliProducts.getMeats();
        List<PremiumMeat> selectedMeats = new ArrayList<>();
        selectToppings("Meat Topping choices", premiumMeats, selectedMeats, sandwichSize);

        // select cheese
        List<PremiumCheese> premiumCheeses = deliProducts.getCheeses();
        List<PremiumCheese> selectedCheeses = new ArrayList<>();
        selectedCheeses = selectToppings("Cheese Topping choices", premiumCheeses, selectedCheeses, sandwichSize);

        // Select Toppings
        List<IncludedTopping> toppings = deliProducts.getIncludedToppings();
        List<IncludedTopping> selectedIncludedToppings = new ArrayList<>();
        selectToppings("topping choices", toppings, selectedIncludedToppings, sandwichSize);

        // Select sauces
        List<Sauce> sauces = deliProducts.getSauces();
        List<Sauce> selectedSauces = new ArrayList<>();
        selectToppings("Sauce choices", sauces, selectedSauces, sandwichSize);

        // select if toasted
        boolean isToasted = Prompts.promptMaker("Would you like this sandwich toasted? (Yes/No)").equalsIgnoreCase("Yes");

//        double toppingsPrice = calculateToppingsPrice(selectedMeats, selectedCheeses, selectedIncludedToppings, selectedSauces, sandwichSize);

        List<Object> allSelectedItems = new ArrayList<>();
        allSelectedItems.add(selectedMeats);
        allSelectedItems.add(selectedCheeses);
        allSelectedItems.add(selectedIncludedToppings);
        allSelectedItems.add(selectedSauces);

        // Set prices for selected toppings based on sandwich size
        for (PremiumMeat meat : selectedMeats) {
            meat.setPrice(sandwichSize);
        }

        for (PremiumCheese cheese : selectedCheeses) {
            cheese.setPrice(sandwichSize);
        }


        // create sandwich
        return new Sandwich(selectedBread, sandwichSize, isToasted, allSelectedItems);
    }

    public Drink processAddDrinkRequest() {
        List<Drink> drinks = deliProducts.getDrinks();
        Drink selectedDrink = drinks.get(0); // Get the first (and only) drink

        double price = 0; // To store the selected price
        boolean validChoice = false; // To track if a valid choice is made

        // Loop until the user selects a valid drink size
        while (!validChoice) {
            // Prompt user to select a drink size
            String sizeChoice = Prompts.drinkPrompt();

            switch (sizeChoice) {
                case "1": // Small
                    price = selectedDrink.getSmallPrice();
                    validChoice = true; // Exit the loop when a valid choice is made
                    break;
                case "2": // Medium
                    price = selectedDrink.getMediumPrice();
                    validChoice = true; // Exit the loop when a valid choice is made
                    break;
                case "3": // Large
                    price = selectedDrink.getLargePrice();
                    validChoice = true; // Exit the loop when a valid choice is made
                    break;
                default:
                    // Invalid input, re-prompt the user
                    System.out.println("Invalid size choice. Please select a valid option (1, 2, or 3).");
                    break; // Re prompt until a valid choice is made
            }
        }

        // Set the price for the selected drink size
        selectedDrink.setPrice(price);

        // Print the selected drink and its price
        System.out.println("$" + price);
        return selectedDrink;
    }

    public Chips processGetChipsRequest() {
        List<Chips> chips = deliProducts.getChips();
        Chips selectedChips = chips.get(0);

        boolean wantsChips = Prompts.promptMaker("Would you like chips with this order? (Yes/No)").equalsIgnoreCase("yes");
        if (wantsChips) {
            // If the user wants chips, create a new Chips object with the selected prices
            Chips chips1 = new Chips(
                    "Chips",
                    selectedChips.getSmallPrice(),
                    selectedChips.getMediumPrice(),
                    selectedChips.getLargePrice(),
                    selectedChips.getLargePrice()
            );
            System.out.println(chips1);
            return chips1;
        } else {
            System.out.println("No chips selected.");
            return null;
        }
    }

    public <T> List<T> selectToppings(String promptMessage, List<T> availableToppings, List<T> selectedToppings, SandWichSize sandwichSize) {
        while (true) {
            // Display the available toppings
            productsFileManager.displayProducts(promptMessage, availableToppings);

            // Get user input for the topping selection
            String toppingChoice = Prompts.promptMaker("Select a topping (Enter 0 to stop): ");

            // Exit the loop if the user enters "0"
            if (toppingChoice.equals("0")) break;

            try {
                // Parse the choice and add the selected topping to the selected list
                T selectedTopping = availableToppings.get(Integer.parseInt(toppingChoice) - 1);

                // Set the price for the selected topping based on the sandwich size
                if (selectedTopping instanceof PremiumMeat meat) {
                    meat.setPrice(sandwichSize);  // Set price for meat
                } else if (selectedTopping instanceof PremiumCheese cheese) {
                    cheese.setPrice(sandwichSize);  // Set price for cheese
                } else if (selectedTopping instanceof IncludedTopping topping) {
                    topping.getPrice();  // Set price for included topping
                } else if (selectedTopping instanceof Sauce sauce) {
                    sauce.getPrice();  // Set price for sauce
                }

                // Add the topping to the selected toppings list
                selectedToppings.add(selectedTopping);

                System.out.println("Selected toppings: " + selectedToppings);

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                // Handle invalid input
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
        return selectedToppings;
    }


    private int generateOrderId() {
        return (int) (System.currentTimeMillis() % 10000);  // Generates a simple order ID based on current time
    }

    public void checkout() {
        if (currentOrder != null) {
            System.out.println("Your order details:");
            System.out.println(currentOrder);
        } else {
            System.out.println("No order found. Please start an order.");
        }
    }

//    private static double calculateToppingsPrice(List<PremiumMeat> meats, List<PremiumCheese> cheeses,
//                                          List<IncludedTopping> toppings, List<Sauce> sauces,SandWichSize size) {
//        double totalToppingsPrice = 0.0;
//
//        // Add the price for selected meats
//        for (PremiumMeat meat : meats) {
//            totalToppingsPrice += meat.setPrice(size);
//        }
//
//        // Add the price for selected cheese
//        for (PremiumCheese cheese : cheeses) {
//            totalToppingsPrice += cheese.getPrice();
//        }
//
//        // Add the price for selected included toppings
//        for (IncludedTopping topping : toppings) {
//            totalToppingsPrice += topping.getPrice();
//        }
//
//        // Add the price for selected sauces
//        for (Sauce sauce : sauces) {
//            totalToppingsPrice += sauce.getPrice();
//        }
//
//        return totalToppingsPrice;
//    }
//
//
}
