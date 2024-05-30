package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignatureSandwiches extends Sandwich {

    public SignatureSandwiches(String size,
                               String type,
                               double price,
                               List<String> premiumToppingsList,
                               boolean extraMeat,
                               List<String> regularToppingsList,
                               List<String> cheesesList,
                               boolean extraCheese,
                               List<String> saucesList,
                               boolean toasted,
                               List<String> sidesList) {
        super(size, type, price, premiumToppingsList,
                extraMeat, regularToppingsList,
                cheesesList, extraCheese, saucesList, toasted, sidesList);
    }

    public SignatureSandwiches(String sandwichType) {
        super("8\"", "White", 0.0, new ArrayList<>(), false, new ArrayList<>(), new ArrayList<>(), false, new ArrayList<>(), true, new ArrayList<>());
        switch (sandwichType) {
            case "BLT":
                createBLTSandwich();
                break;
            case "PhillyCheeseSteak":
                createPhillyCheeseSteakSandwich();
                break;
            default:
                throw new IllegalArgumentException("Unknown sandwich type: " + sandwichType);
        }
    }

    private void createBLTSandwich() {
        List<String> premiumToppings = new ArrayList<>();
        premiumToppings.add("Bacon");
        setPremiumToppings(premiumToppings);

        List<String> cheeses = new ArrayList<>();
        cheeses.add("Cheddar");
        setCheeses(cheeses);

        List<String> regularToppings = new ArrayList<>();
        regularToppings.add("Lettuce");
        regularToppings.add("Tomato");
        setRegularToppings(regularToppings);

        List<String> sauces = new ArrayList<>();
        sauces.add("Ranch");
        setSauces(sauces);

        setToasted(true);
    }

    private void createPhillyCheeseSteakSandwich() {
        List<String> premiumToppings = new ArrayList<>();
        premiumToppings.add("Steak");
        setPremiumToppings(premiumToppings);

        List<String> cheeses = new ArrayList<>();
        cheeses.add("American");
        setCheeses(cheeses);

        List<String> regularToppings = new ArrayList<>();
        regularToppings.add("Peppers");
        setRegularToppings(regularToppings);

        List<String> sauces = new ArrayList<>();
        sauces.add("Mayo");
        setSauces(sauces);

        setToasted(true);
    }

    public static Sandwich chooseSignatureSandwich(Scanner scanner) {
        while (true) {
            System.out.println("[1] BLT");
            System.out.println("[2] Philly Cheese Steak");

            int customSandwichChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (customSandwichChoice) {
                case 1:
                    return new SignatureSandwiches("BLT");
                case 2:
                    return new SignatureSandwiches("PhillyCheeseSteak");
                default:
                    System.out.println("That is not a valid choice, please select a valid option...");
            }
        }
    }
}
