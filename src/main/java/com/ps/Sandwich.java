package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich extends Order {

    private List<String> premiumToppingsList = new ArrayList<>();
    private boolean extraMeat = false;

    private List<String> regularToppingsList = new ArrayList<>();

    private List<String> cheesesList = new ArrayList<>();
    private boolean extraCheese = false;

    private List<String> saucesList = new ArrayList<>();

    private boolean toasted = false;

    private List<String> sidesList = new ArrayList<>();

    // lists to hold available options
    public static List<String> premiumToppings = new ArrayList<>();
    public static List<String> regularToppings = new ArrayList<>();
    public static List<String> cheeses = new ArrayList<>();
    public static List<String> sauces = new ArrayList<>();
    public static List<String> sides = new ArrayList<>();

    // ansi code
    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";

    // initialize available options
    static {

        // premium toppings
        premiumToppings.add("Steak");
        premiumToppings.add("Ham");
        premiumToppings.add("Salami");
        premiumToppings.add("Roast Beef");
        premiumToppings.add("Chicken");
        premiumToppings.add("Bacon");

        // regular toppings
        regularToppings.add("Lettuce");
        regularToppings.add("Peppers");
        regularToppings.add("Onions");
        regularToppings.add("Tomatoes");
        regularToppings.add("Jalapenos");
        regularToppings.add("Cucumbers");
        regularToppings.add("Pickles");
        regularToppings.add("Guacamole");
        regularToppings.add("Mushrooms");

        // cheeses
        cheeses.add("American");
        cheeses.add("Provolone");
        cheeses.add("Cheddar");
        cheeses.add("Swiss");

        // sauces
        sauces.add("Mayo");
        sauces.add("Mustard");
        sauces.add("Ketchup");
        sauces.add("Ranch");
        sauces.add("Thousand Islands");
        sauces.add("Vinaigrette");

        // sides
        sides.add("au jus");
        sides.add("sauce");
    }

    // Getters and setters
    public List<String> getPremiumToppings() {
        return premiumToppingsList;
    }

    public void setPremiumToppings(List<String> premiumToppings) {
        this.premiumToppingsList = premiumToppings;
    }

    public List<String> getRegularToppings() {
        return regularToppingsList;
    }

    public void setRegularToppings(List<String> regularToppings) {
        this.regularToppingsList = regularToppings;
    }

    public List<String> getCheeses() {
        return cheesesList;
    }

    public void setCheeses(List<String> cheeses) {
        this.cheesesList = cheeses;
    }

    public List<String> getSauces() {
        return saucesList;
    }

    public void setSauces(List<String> sauces) {
        this.saucesList = sauces;
    }

    public List<String> getSides() {
        return sidesList;
    }

    public void setSides(List<String> sides) {
        this.sidesList = sides;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }


    // calculate the price of the sandwich
    // starts at 0.
    public double getPrice() {
        double finalPrice = 0;
        double premiumToppingCharge = 0;
        double extraMeatCharge = 0;
        double cheeseCharge = 0;
        double extraCheeseCharge = 0;

        // calculate base price and charges based on size
        if (getSize() != null) {
            switch (getSize()) {

                case "4\"":
                    finalPrice += 5.50;
                    premiumToppingCharge = 1.00;
                    extraMeatCharge = .50;
                    cheeseCharge = .75;
                    extraCheeseCharge = .30;
                    break;

                case "8\"":
                    finalPrice += 7.00;
                    premiumToppingCharge = 2.00;
                    extraMeatCharge = 1.00;
                    cheeseCharge = 1.50;
                    extraCheeseCharge = .60;
                    break;

                case "12\"":
                    finalPrice += 8.50;
                    premiumToppingCharge = 3.00;
                    extraMeatCharge = 1.50;
                    cheeseCharge = 2.25;
                    extraCheeseCharge = .90;
                    break;
            }
        }

        // Add charges for all premium toppings
        if (premiumToppingsList != null) {
            for (String premium : premiumToppingsList) {

                finalPrice += premiumToppingCharge;
            }
        }

        // Add charge for cheese if any are selected
        if (cheesesList != null && !cheesesList.isEmpty()) {
            finalPrice += cheeseCharge;
        }

        // Add charge for extra meat if selected
        if (extraMeat) {
            finalPrice += extraMeatCharge;
        }

        // Add charge for extra cheese if selected
        if (extraCheese) {
            finalPrice += extraCheeseCharge;
        }

        return finalPrice;
    }

    // modified toString method to make it more visually appealing.
 
