package com.pluralsight.deliciousdeli.model;

import com.pluralsight.deliciousdeli.products.Product;
import com.pluralsight.deliciousdeli.products.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private List<Product> products;  // List of products in the order
    private double totalPrice;
    private List<Sandwich> sandwiches;

    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.products = new ArrayList<>();
        this.sandwiches = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addProduct(Product p){
        products.add(p);
        totalPrice += p.getPrice();
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getPrice(){
        double total = 0;
        for(Product p : products){
            total += p.getPrice() ;
        }
        return total;
    }

    public String toCSV() {

        StringBuilder csv = new StringBuilder();

        // Add Headers
        csv.append("""
                ------Receipt------
                Delicious Deli
                """).append("\n");

        // Add Order ID and Customer Name
        csv.append("Order ID: " + orderId).append("\n").append("Customer Name: " + customerName).append("\n");

        // Add each product and its price
        for (Product product : products) {
            // Add product name and price
            csv.append(" ").append(product.getName()).append(" ").append(String.format("%.2f", product.getPrice())).append("\n");
        }

        // Add the total price at the bottom
        csv.append("\nTotal: ").append(String.format("%.2f", totalPrice)).append("\n");
        csv.append("-------------------");

        return csv.toString();
    }

    @Override
    public String toString() {
        return "Order {" +
                "\n  Order ID: " + orderId +
                "\n  Customer Name: '" + customerName + '\'' +
                "\n  Products: " + products +
                "\n  Total Price: $" + String.format("%.2f", totalPrice) +
                "\n}";
    }
}
