package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drinks {

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
        System.out.print("Enter the number of the drink you want to add to your order: ");
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
                            System.out.println("Invalid size choice. Defaulting to Small.");
                            size = "Small";
                            break;
                    }
                    OrderScreen.drinks.add(size + " " + drink);
                    System.out.println(size + " " + drink + " added to your order.");
                } else {
                    scanner.nextLine(); // Consume invalid input
                    System.out.println("Invalid input, please enter a number for the size.");
                }
            } else {
                System.out.println("Invalid choice.");
            }

        } else {
            scanner.nextLine(); // Consume invalid input
            System.out.println("Invalid input, please enter a number.");
        }
    }
}
