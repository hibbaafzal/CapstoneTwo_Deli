package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drinks extends Order{

    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";

    List<String> availableDrinks = new ArrayList<>();


    public Drinks() {

        availableDrinks.add("Coke");
        availableDrinks.add("Pepsi");
        availableDrinks.add("Sprite");
        availableDrinks.add("Water");

    }


    public void orderDrinks(Scanner scanner) {
        System.out.println("Available drinks:");

        // looping through array to display all drinks
        for (int i = 0; i < availableDrinks.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, availableDrinks.get(i));

        }
        System.out.print("\nEnter the number of the drink you want to add to your order: ");
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
                    UserInterface.drinks.add(size + " " + drink);
                    System.out.println(GREEN + size + " " + drink + " added to your order."+ RESET);
                } else {
                    scanner.nextLine(); // Consume invalid input
                    System.out.println(RED + "Invalid input, please enter a number for the size."+ RESET);
                }
            } else {
                System.out.println(RED+ "Invalid choice."+ RESET);
            }

        } else {
            scanner.nextLine(); // Consume invalid input
            System.out.println(RED + "Invalid input, please enter a number."+ RESET);
        }
    }
}
