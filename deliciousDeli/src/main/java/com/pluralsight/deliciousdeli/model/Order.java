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

    public Order(int orderId, String customerName, List<Sandwich> products, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.products = new ArrayList<>();
        this.totalPrice = totalPrice;
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public double getPrice(){
        double total = 0;
        for(Product p : products){
            total += 0;
        }
        return total;
    }
}
