package com.pluralsight.deliciousdeli.model;

import java.util.List;

public class Order {
    private static int orderCount = 0;  // Static variable to generate unique order IDs
    private int orderId;
    private String customerName;
    private List<Sandwich> sandwiches;  // List of sandwiches in the order
    private List<Drink> drinks;        // List of drinks in the order
    private List<Chips> chips;
    private double totalPrice;



}
