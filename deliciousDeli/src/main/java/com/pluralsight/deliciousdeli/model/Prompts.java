package com.pluralsight.deliciousdeli.model;

public class Prompts {

    public static String promptMaker(String prompt) {
        System.out.println(prompt);
        return UserInterface.scanner.nextLine();
    }

    public static String homePrompt(){
        return Prompts.promptMaker("""
                    *-------- DELICIOUS sandwiches --------*
                    -----------------Home-------------------
                     ~ Enter                               -
                     - 1 ) New Order                       -
                     - 0 ) To exit                         -
                     ---------------------------------------
                    """);
    }

    public static String orderPrompt(){
        return Prompts.promptMaker("""
                    *-------- DELICIOUS sandwiches --------*
                    -----------------Home-------------------
                     ~ Enter                               -
                     - 1 ) Add Sandwich                    -
                     - 2 ) Add Drink                       -
                     - 3 ) Add Chips                       -
                     - 4 ) Checkout                        -
                     - 0 ) Cancel Order                    -
                     ---------------------------------------
                    """);
    }
}
