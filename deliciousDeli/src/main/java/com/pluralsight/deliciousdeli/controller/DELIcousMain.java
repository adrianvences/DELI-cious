package com.pluralsight.deliciousdeli.controller;

import com.pluralsight.deliciousdeli.enums.Bread;
import com.pluralsight.deliciousdeli.enums.SandWichSize;
import com.pluralsight.deliciousdeli.model.DeliProductManager;
import com.pluralsight.deliciousdeli.model.UserInterface;

public class DELIcousMain {
    public static void main(String[] args) {
//        UserInterface.homeScreen();
        DeliProductManager deliProductManager = new DeliProductManager();
        deliProductManager.loadToppingsFromCSV("src/main/resources/menu-items/regularToppings.csv");
        deliProductManager.loadChipsFromCSV("src/main/resources/menu-items/chips.csv");
//        deliProductManager.loadDrinksFromCSV("src/main/resources/menu-items/drinks.csv");

        deliProductManager.displayProducts();
    }
}
