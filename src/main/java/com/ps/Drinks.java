package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drinks {

    // ansi code
    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";

    // List to store available drinks
    private static List<String> availableDrinks = new ArrayList<>();

    // initialize the available drinks list
    static {
        availableDrinks.add("Coke");
        availableDrinks.add("Pepsi");
        availableDrinks.add("Sprite");
        availableDrinks.add("Water");
    }

    // handle the ordering of drinks
    public static void orderDrinks(Scanner scanner) {

        // Display available drinks

        System.out.println("Available drinks:");
        for (int i = 0; i < availableDrinks.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, availableDrinks.get(i));
        }


        System.out.print("Enter the number of the drink you want to add to your order: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline.


            if (choice > 0 && choice <= availableDrinks.size()) {

                // subtract one to get the correct index.
                String drink = availableDrinks.get(choice - 1);


                System.out.println("Choose the size: ");
                System.out.println("[1] Small");
                System.out.println("[2] Medium");
                System.out.println("[3] Large");

                if (scanner.hasNextInt()) {
                    int sizeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline.
                    String size;


                    switch (sizeChoice) {
                        case 1:
                            size = "Small";
                            break;
                        case 2:
                            size = "Medium";
                            break;
                        case 3:
                            size = "Large";
                            break;
                        default:
                            // Default to Small if the input is invalid
                            System.out.println("Invalid size choice. Defaulting to Small.");
                            size = "Small";
                            break;
                    }

                    // Add the chosen drink and size to the order
                    OrderScreen.drinks.add(size + " " + drink);

                    System.out.println(GREEN + size + " " + drink + " has been added to your order." + RESET);
                } else {
                    scanner.nextLine();
                    // invalid size input
                    System.out.println(RED + "Invalid input, please enter a number for the size." + RESET);
                }
            } else {
                // Inform user of invalid drink choice
                System.out.println(RED + "Invalid choice." + RESET);
            }
        } else {
            scanner.nextLine();
            // invalid drink choice.
            System.out.println(RED + "Invalid input, please enter a number." + RESET);
        }
    }
}
