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
        deliProductManager.loadDrinksFromCSV("src/main/resources/menu-items/drinks.csv");
        deliProductManager.loadPremiumToppingCheeseFromCSV("src/main/resources/menu-items/premiumToppingCheese.csv");
        deliProductManager.loadPremiumToppingsFromCSV("src/main/resources/menu-items/premiumToppingsMeats.csv");
        deliProductManager.loadSauceSelection("src/main/resources/menu-items/sauceSelection.csv");
        deliProductManager.loadSideSelection("src/main/resources/menu-items/sideSelection.csv");
        deliProductManager.displayProducts();
    }
}
