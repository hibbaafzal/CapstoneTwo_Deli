package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    // Store the items
    static List<Sandwich> sandwiches = new ArrayList<>();
    static List<String> drinks = new ArrayList<>();
    static List<String> chips = new ArrayList<>();
    static List<String> desserts = new ArrayList<>();

    // ANSI code
    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";

    // Method to start the main user interface.
    public void startOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        do {
            System.out.println("\n\n\n" + GREEN + "--------------Welcome to the DELI-cious Sandwich Shop!--------------" + RESET);
            System.out.println("How can we get you started today?");
            System.out.println("[1] New Order");
            System.out.println("[0] Exit");

            if (scanner.hasNextInt()) {
                int newOrderCommand = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (newOrderCommand) {
                    case 1:
                        startOrderProcess(scanner);
                        break;
                    case 0:
                        isRunning = false;
                        System.out.println(YELLOW + "Thank you for visiting DELI-cious Sandwich Shop! Have a great day!" + RESET);
                        break;
                    default:
                        System.out.println(RED + "Invalid choice, please try again." + RESET);
                        break;
                }
            } else {
                scanner.nextLine(); // Consume invalid input
                System.out.println(RED + "Invalid input, please enter a number." + RESET);
            }
        } while (isRunning);
    }

    // Start the ordering process
    public static void startOrderProcess(Scanner scanner) {
        boolean isOrdering = true;

        do {
            // Display the order screen
            System.out.println(YELLOW + "\n\n\n-----------------Order Screen-----------------\n\n" + RESET);
            System.out.println("What would you like to do?");
            System.out.println("[1] Add Sandwich");
            System.out.println("[2] Add Drink");
            System.out.println("[3] Add Chips");
            System.out.println("[4] Add Dessert");
            System.out.println(GREEN + "[5] Checkout" + RESET);
            System.out.println(RED + "[0] Cancel Order" + RESET);

            if (scanner.hasNextInt()) {
                int orderScreen = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (orderScreen) {
                    case 1:
                        new SandwichCustomization().homeScreen(scanner); // Add sandwich
                        break;
                    case 2:
                        new Drinks().orderDrinks(scanner); // Add drink
                        break;
                    case 3:
                        Chips.addChips(scanner); // Add chips
                        break;
                    case 4:
                        new Desserts().orderDesserts(scanner); // Add dessert
                        break;
                    case 5:
                        checkout(scanner); // Checkout
                        break;
                    case 0:
                        // Cancel order
                        sandwiches.clear();
                        drinks.clear();
                        chips.clear();
                        desserts.clear();
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
        } while (isOrdering);
    }

    // Method to handle the checkout process
    private static void checkout(Scanner scanner) {
        System.out.println(YELLOW + "------------Your Order------------" + RESET);
        if (sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty() && desserts.isEmpty()) {
            System.out.println("Your order is empty.");
            System.out.println(RED + "Please add something to your order." + RESET);
            return;
        } else {
            if (!sandwiches.isEmpty()) {
                System.out.println("Sandwiches:");
                for (Sandwich sandwich : sandwiches) {
                    System.out.println(sandwich);
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
            if (!desserts.isEmpty()) {
                System.out.println("Desserts:");
                for (String dessert : desserts) {
                    System.out.println(dessert);
                }
            }
        }

        // Prompt user to confirm or cancel the order
        System.out.print(GREEN + "[C] Confirm - print receipt\n" + RESET);
        System.out.print(RED + "[X] Cancel - delete order and go back to the home screen\n" + RESET);

        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "c":
                OrderFileManager.printReceiptToFile(sandwiches, drinks, chips, desserts);
                sandwiches.clear();
                drinks.clear();
                chips.clear();
                desserts.clear();
                System.exit(0);
                break;
            case "x":
                sandwiches.clear();
                drinks.clear();
                chips.clear();
                desserts.clear();
                break;
            default:
                System.out.println(RED + "Invalid choice, please try again." + RESET);
                break;
        }
    }
}
