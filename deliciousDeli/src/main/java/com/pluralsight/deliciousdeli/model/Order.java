package com.pluralsight.deliciousdeli.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCount = 0;  // Static variable to generate unique order IDs
    private int orderId;
    private String customerName;
    private List<Sandwich> sandwiches;  // List of sandwiches in the order
    private List<Drink> drinks;        // List of drinks in the order
    private List<Chips> chips;
    private double totalPrice;

    public Order(int orderId, String customerName, List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.totalPrice = totalPrice;
    }
}
