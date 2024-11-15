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
