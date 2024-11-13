package com.pluralsight.deliciousdeli.model;

import java.util.Scanner;

public class UserInterface {
    // Scanner to read user input from terminal
    static Scanner scanner = new Scanner(System.in);


                        // *** Home Screen Method *** //
    public static void homeScreen(){
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


}
