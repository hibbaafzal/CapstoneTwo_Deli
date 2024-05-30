package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desserts extends Order {

    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";

     static ArrayList<String> availableDesserts = new ArrayList<>();

    static {
        availableDesserts.add("Chocolate Cake");
        availableDesserts.add("Cheesecake");
        availableDesserts.add("Brownie");
        availableDesserts.add("Ice Cream");

    }


    public void orderDesserts(Scanner scanner) {
        System.out.println("Available desserts:");

        // Looping through array to display all desserts
        for (int i = 0; i < availableDesserts.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, availableDesserts.get(i));
        }

        System.out.print("\nWhich dessert would you like?: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (choice > 0 && choice <= availableDesserts.size()) {
                String dessert = availableDesserts.get(choice - 1);
                UserInterface.desserts.add(dessert);
                System.out.println(GREEN + dessert + " added to your order." + RESET);
            } else {
                System.out.println(RED + "Invalid choice." + RESET);
            }
        } else {
            scanner.nextLine(); // Consume invalid input
            System.out.println(RED + "Invalid input, please enter a number." + RESET);
        }
    }
}