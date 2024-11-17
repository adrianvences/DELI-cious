package com.pluralsight.deliciousdeli.DataManagers;

import com.pluralsight.deliciousdeli.model.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptManager {

    public static void writeOrderToCSV(Order order, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) { // true for appending
            // Write the order details to the CSV file
            writer.write(order.toCSV()); // Use the toCSV() method to format the order as a CSV line
            writer.newLine(); // Move to the next line for the next order
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


}
