package com.pluralsight.deliciousdeli.model;

import com.pluralsight.deliciousdeli.products.Sandwich;

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
    public static void orderScreen(){
        boolean flag = true;

        while(flag) {

            String input = Prompts.orderPrompt();

            switch (input){
                // New Order
                case "1":
                    System.out.println("add sandwich");
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

    public void processAddSandwichRequest(){
        Sandwich sandwich =
    }


}
