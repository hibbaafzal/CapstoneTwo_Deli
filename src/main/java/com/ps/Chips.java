package com.ps;


import java.util.Scanner;

public class Chips extends Order {

    public Chips(double price) {
        super(price);


    }

    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";

    // Adding chips to order
    public static void addChips(Scanner scanner) {
        System.out.print("How many bags of chips would you like?: ");

        // Check if the input is an integer
        if (scanner.hasNextInt()) {
            int numberOfBags = scanner.nextInt();
            scanner.nextLine();


            if (numberOfBags > 0) {
                // add the specified number of bags to the order
                UserInterface.chips.add("Bag of chips");

                System.out.println(GREEN + numberOfBags + " bag(s) of chips added to your order." + RESET);

            } else {
                // invalid if the number is not positive
                System.out.println(RED + "Invalid choice. Please enter a positive number." + RESET);
            }
        } else {

            scanner.nextLine();

            System.out.println(RED + "Invalid input, please enter a number." + RESET);
        }


    }

    @Override
    protected double calcPrice() {

        double price;
        return price = 1.50;
    }


    }