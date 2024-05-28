package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomSandwiches extends Sandwich {

    // Constructor
    public CustomSandwiches(String sandwichType) {
        setSize("8\""); // Default size for custom sandwiches
        setType("White"); // Default bread type for custom sandwiches


        if (sandwichType.equals("BLT")) {
            createBLTSandwich();
        } else if (sandwichType.equals("PhillyCheeseSteak")) {
            createPhillyCheeseSteakSandwich();
        }
    }

    // Method to create a BLT sandwich
    private void createBLTSandwich() {
        // Add premium toppings
        List<String> premiumToppings = new ArrayList<>();
        premiumToppings.add("Bacon");
        setPremiumToppings(premiumToppings);

        // Add cheese
        List<String> cheeses = new ArrayList<>();
        cheeses.add("Cheddar");
        setCheeses(cheeses);

        // Add regular toppings
        List<String> regularToppings = new ArrayList<>();
        regularToppings.add("Lettuce");
        regularToppings.add("Tomato");
        setRegularToppings(regularToppings);

        // Add sauces
        List<String> sauces = new ArrayList<>();
        sauces.add("Ranch");
        setSauces(sauces);

        setToasted(true); // Set the sandwich to be toasted
    }

    // Method to create a Philly Cheese Steak sandwich
    private void createPhillyCheeseSteakSandwich() {
        // Add premium toppings
        List<String> premiumToppings = new ArrayList<>();
        premiumToppings.add("Steak");
        setPremiumToppings(premiumToppings);

        // Add cheese
        List<String> cheeses = new ArrayList<>();
        cheeses.add("American");
        setCheeses(cheeses);

        // Add regular toppings
        List<String> regularToppings = new ArrayList<>();
        regularToppings.add("Peppers");
        setRegularToppings(regularToppings);

        // Add sauces
        List<String> sauces = new ArrayList<>();
        sauces.add("Mayo");
        setSauces(sauces);

        setToasted(true); // Set the sandwich to be toasted
    }

    // Method to choose a signature sandwich
    public static Sandwich chooseSignatureSandwich(Scanner scanner) {
        boolean isChoosingSignatureSandwich = true;
        while (isChoosingSignatureSandwich) {
            // Display sandwich options
            System.out.println("[1] BLT");
            System.out.println("[2] Philly Cheese Steak");

            // Process user input
            int customSandwichChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (customSandwichChoice) {
                case 1:
                    return new CustomSandwiches("BLT"); // Create and return a BLT sandwich
                case 2:
                    return new CustomSandwiches("PhillyCheeseSteak"); // Create and return a Philly Cheese Steak sandwich
                default:
                    System.out.println(Sandwich.RED + "That is not a valid choice, please select a valid option..." + Sandwich.RESET);
                    break;
            }
        }
        return new Sandwich(); // Default return
    }
}
