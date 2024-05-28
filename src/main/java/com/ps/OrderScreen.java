package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ps.Drinks.orderDrinks;

public class OrderScreen extends Order {

    // store the order items
    public static List<Sandwich> sandwiches = new ArrayList<>();
    public static List<String> drinks = new ArrayList<>();
    public static List<String> chips = new ArrayList<>();

    // ansi code
    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";

    // start the ordering process
    public static void startOrder(Scanner scanner) {
        boolean isOrdering = true;

        while (isOrdering) {
            // Display the order screen
            System.out.println(YELLOW + "\n\n\n-----------------Order Screen-----------------\n\n" + RESET);
            System.out.println("What would you like to do?");
            System.out.println("[1] Add Sandwich");
            System.out.println("[2] Add Drink");
            System.out.println("[3] Add Chips");
            System.out.println(GREEN + "[4] Checkout" + RESET);
            System.out.println(RED + "[0] Cancel Order" + RESET);


            if (scanner.hasNextInt()) {
                int orderScreen = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (orderScreen) {
                    case 1:
                        new Sandwich().homeScreen(scanner); // Add sandwich
                        break;

                    case 2:
                        orderDrinks(scanner); // Add drink
                        break;

                    case 3:
                        addChips(scanner); // Add chips
                        break;
                    case 4:
                        checkout(scanner); // Checkout
                        break;

                    case 0:
                        // Cancel order
                        sandwiches.clear();
                        drinks.clear();
                        chips.clear();
                        isOrdering = false;
                        break;

                    default:
                        System.out.println(RED + "Invalid choice, please try again." + RESET);
                        break;
                }
            } else {
                scanner.nextLine();
                System.out.println(RED + "Invalid input, please enter a number." + RESET);
            }
        }
    }

    // Method to add chips to the order
    private static void addChips(Scanner scanner) {
        System.out.print("How many bags of chips would you like?: ");
        if (scanner.hasNextInt()) {
            int numberOfBags = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (numberOfBags > 0) {
                for (int i = 0; i < numberOfBags; i++) {
                    chips.add("Bag of chips");
                }
                System.out.println(GREEN + numberOfBags + " bag(s) of chips added to your order." + RESET);
            } else {
                System.out.println(RED + "Invalid choice. Please enter a positive number." + RESET);
            }
        } else {
            scanner.nextLine(); // Consume invalid input
            System.out.println(RED + "Invalid input, please enter a number." + RESET);
        }
    }

    // Method to handle the checkout process
    private static void checkout(Scanner scanner) {
        System.out.println(YELLOW + "------------Your Order:------------" + RESET);
        if (sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty()) {
            System.out.println("Your order is empty.");
            System.out.println(RED + "Please add something to your order." + RESET);
            return;
        } else {
            if (!sandwiches.isEmpty()) {
                System.out.println("Sandwiches:");
                for (Sandwich sandwiches : OrderScreen.sandwiches) {
                    System.out.println(sandwiches);
                }
            }
            if (!drinks.isEmpty()) {
                System.out.println("Drinks:");
                for (String drink : drinks) {
                    System.out.println(drink);
                }
            }
            if (!chips.isEmpty()) {
                System.out.println("Chips:");
                for (String chip : chips) {
                    System.out.println(chip);
                }
            }
        }

        // Prompt user to confirm or cancel the order
        System.out.print(GREEN + "[C] Confirm - print receipt\n" + RESET);
        System.out.print(RED + "[X] Cancel - delete order and go back to the home screen\n" + RESET);

        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "c":
                printReceiptToFile(sandwiches, drinks, chips);
                sandwiches.clear();
                drinks.clear();
                chips.clear();
                System.exit(0);
                break;

            case "x":
                sandwiches.clear();
                drinks.clear();
                chips.clear();
                break;

            default:
                System.out.println(RED + "Invalid choice, please try again." + RESET);
                break;
        }
    }

    // Method to print the receipt to a file
    // using datetime formatter
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


            System.out.println(GREEN + "Your receipt has been printed." + RESET);
            System.out.println(YELLOW + "Thank you for choosing DELI-cious Deli!\nWe appreciate your business!" + RESET);
        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }

    // get the price of a drink based on its size
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
