package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderFileManager {

    // Method to print the receipt to a file

    public static void printReceiptToFile(List<Sandwich> sandwiches,
                                          List<String> drinks,
                                          List<String> chips) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedDateTime = now.format(formatter);

        // Create a file name based on the current date and time EACH TIME receipt is printed.
        String fileName = "receipts/" + formattedDateTime + ".txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            double total = 0;

            bufferedWriter.write("--------- RECEIPT ---------\n");
            bufferedWriter.write("Date: " + now.toLocalDate() + "\n\n");

            // Write sandwich details and calculate total price
            if (!sandwiches.isEmpty()) {
                bufferedWriter.write("Sandwiches:\n");
                for (Sandwich sandwich : sandwiches) {
                    bufferedWriter.write(sandwich.toString() + "\n");
                    total += sandwich.getPrice();
                }
            }

            // Write drink details and calculate total price
            if (!drinks.isEmpty()) {
                bufferedWriter.write("Drinks:\n");
                for (String drink : drinks) {
                    bufferedWriter.write(drink + "\n");
                    double drinkPrice = getDrinkPrice(drink);
                    bufferedWriter.write(String.format("$%.2f\n", drinkPrice));
                    total += drinkPrice;
                }
            }

            // Write chip details and calculate total price
            if (!chips.isEmpty()) {
                bufferedWriter.write("Chips:\n");
                for (String chip : chips) {
                    bufferedWriter.write(chip + "\n");
                    double chipPrice = 1.50;
                    bufferedWriter.write(String.format("$%.2f\n", chipPrice));
                    total += chipPrice;
                }
            }

            // Calculate and write tax and total amount
            double tax = total * 0.08875;
            bufferedWriter.write(String.format("\nTax: $%.2f\n", tax));
            bufferedWriter.write(String.format("Total: $%.2f\n", total + tax));
            bufferedWriter.write("----------------------------\n");

            System.out.println(OrderScreen.GREEN + "Your receipt has been printed." + OrderScreen.RESET);
            System.out.println(OrderScreen.YELLOW + "Thank you for choosing DELI-cious Deli!\n" +
                    "We appreciate your business!" + OrderScreen.RESET);
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }

    // Get the price of a drink based on its size
    private static double getDrinkPrice(String drink) {
        if (drink.startsWith("Small")) {
            return 2.00;
        } else if (drink.startsWith("Medium")) {
            return 2.50;
        } else if (drink.startsWith("Large")) {
            return 3.00;
        }
        return 0;
    }
}
