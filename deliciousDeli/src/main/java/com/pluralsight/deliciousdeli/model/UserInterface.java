package com.pluralsight.deliciousdeli.model;
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

                        // *** Home Screen Method *** //
    public void homeScreen(){
        init();
        // Boolean Flag to exit while loop
        boolean loopFlag = true;
        // While loop to keep home screen iterating through switch cases.
        while(loopFlag){
            // input variable that stores users input through promptMaker method for cleaner code.
            String input = Prompts.homePrompt();
            switch (input){
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
    public void orderScreen(){
        boolean flag = true;

        while(flag) {

            String input = Prompts.orderPrompt();

            switch (input){
                // New Order
                case "1":
                    processAddSandwichRequest();
                    break;
                // Add drink
                case "2":
                    System.out.println("add drink");
                    break;
                // Add Chips
                case "3":
                    System.out.println("add chips");
                    break;
                // Checkout
                case "4":
                    System.out.println("check out");
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
        if(this.deliProducts != null){
            System.out.println("deli loaded");
        } else {
            System.out.println("deli not loaded, check file");
        }
    }

    public Sandwich processAddSandwichRequest(){
        // select bread
        List<Bread> breads =  deliProducts.getBreads();
        productsFileManager.displayProducts("Bread choices: ", breads);
        String breadChoice = Prompts.promptMaker("Select your bread choice by number (digit): ");
        Bread selectedBread = breads.get(Integer.parseInt(breadChoice) - 1 );
        System.out.println(selectedBread);

        // select sandwich size
        productsFileManager.displaySandwichSizes();
        String sizeChoice = Prompts.promptMaker("Select your sandwich size by number (digit): ");
        SandWichSize sandwichSize = productsFileManager.getSandwichSizeFromChoice(sizeChoice);
        System.out.println(sandwichSize);

        // select meat
        List<PremiumMeat> premiumMeats = deliProducts.getMeats();
        List<PremiumMeat> selectedMeats = new ArrayList<>();
        selectToppings("Meat Topping choices",premiumMeats,selectedMeats);

        // select cheese
        List<PremiumCheese> premiumCheeses = deliProducts.getCheeses();
        List<PremiumCheese> selectedCheeses = new ArrayList<>();
        selectedCheeses = selectToppings("Cheese Topping choices", premiumCheeses,selectedCheeses);

        // Select Toppings
        List<IncludedTopping> toppings = deliProducts.getIncludedToppings();
        List<IncludedTopping> selectedIncludedToppings = new ArrayList<>();
        selectToppings("topping choices",toppings,selectedIncludedToppings);

        // Select sauces
        List<Sauce> sauces = deliProducts.getSauces();
        List<Sauce> selectedSauces = new ArrayList<>();
        selectToppings("Sauce choices",sauces,selectedSauces);

        // select if toasted
        boolean isToasted = Prompts.promptMaker("Would you like this sandwich toasted? (Yes/No)").equalsIgnoreCase("Yes");

        List<Object> allSelectedItems = new ArrayList<>();
        allSelectedItems.add(selectedMeats);
        allSelectedItems.add(selectedCheeses);
        allSelectedItems.add(selectedIncludedToppings);
        allSelectedItems.add(selectedSauces);

        // create sandwich
        return new Sandwich(selectedBread,sandwichSize,isToasted,allSelectedItems);
    }

    public void processAddDrinkRequest(){

    }



    public <T> List<T> selectToppings(String promptMessage, List<T> availableToppings, List<T> selectedToppings) {
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
                selectedToppings.add(selectedTopping);
                System.out.println("Selected toppings: " + selectedToppings);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                // Handle invalid input (non-integer or out-of-range selection)
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
        return selectedToppings;
    }


}
