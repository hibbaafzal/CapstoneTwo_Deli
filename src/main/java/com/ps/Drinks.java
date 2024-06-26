package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drinks extends Order {

    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";

    static List<String> availableDrinks = new ArrayList<>();

    static {
        availableDrinks.add("Coke");
        availableDrinks.add("Pepsi");
        availableDrinks.add("Sprite");
        availableDrinks.add("Water");
    }

    public void orderDrinks(Scanner scanner) {
        System.out.println("Available drinks:");

        // Looping through array to display all drinks
        for (int i = 0; i < availableDrinks.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, availableDrinks.get(i));
        }

        System.out.print("\nWhat drink would you like?: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (choice > 0 && choice <= availableDrinks.size()) {
                String drink = availableDrinks.get(choice - 1);

                System.out.println("Choose the size: ");
                System.out.println("[1] Small");
                System.out.println("[2] Medium");
                System.out.println("[3] Large");

                if (scanner.hasNextInt()) {
                    int sizeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
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
                            System.out.println(RED + "Invalid size choice. Defaulting to Small." + RESET);
                            size = "Small";
                            break;
                    }

                    // Adding drink to the order
                    UserInterface.drinks.add(size + " " + drink);
                    System.out.println(GREEN + size + " " + drink + " added to your order." + RESET);

                    // Calculating the price of the selected drink
                    double price = calcPrice();


                } else {
                    scanner.nextLine(); // Consume invalid input
                    System.out.println(RED + "Invalid input, please enter a number for the size." + RESET);
                }
            } else {
                System.out.println(RED + "Invalid choice." + RESET);
            }
        } else {
            scanner.nextLine(); // Consume invalid input
            System.out.println(RED + "Invalid input, please enter a number." + RESET);
        }
    }

    public double getPrice(String drink) {
        switch (drink) {
            case "Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
            default:
                return 0.0;
        }
    }

    @Override
    protected double calcPrice() {
        double total = 0.0;
        for (String drink : UserInterface.drinks) {
            total += getPrice(drink);
        }
        return total;
    }

}
