package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Order {

    public Sandwich(String size,
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

        super(size, type, price);
        this.premiumToppingsList = premiumToppingsList;
        this.extraMeat = extraMeat;
        this.regularToppingsList = regularToppingsList;
        this.cheesesList = cheesesList;
        this.extraCheese = extraCheese;
        this.saucesList = saucesList;
        this.toasted = toasted;
        this.sidesList = sidesList;
    }


// instances containing customizations specific to each sandwich.
    private List<String> premiumToppingsList;
    private boolean extraMeat;
    private List<String> regularToppingsList;
    private List<String> cheesesList;
    private boolean extraCheese;
    private List<String> saucesList;
    private boolean toasted;
    private List<String> sidesList;

    // Static lists holding all available options
    public static List<String> premiumToppings = new ArrayList<>();
    public static List<String> regularToppings = new ArrayList<>();
    public static List<String> cheeses = new ArrayList<>();
    public static List<String> sauces = new ArrayList<>();
    public static List<String> sides = new ArrayList<>();

    static {
        premiumToppings.add("Steak");
        premiumToppings.add("Ham");
        premiumToppings.add("Salami");
        premiumToppings.add("Roast Beef");
        premiumToppings.add("Chicken");
        premiumToppings.add("Bacon");

        regularToppings.add("Lettuce");
        regularToppings.add("Peppers");
        regularToppings.add("Onions");
        regularToppings.add("Tomatoes");
        regularToppings.add("Jalapenos");
        regularToppings.add("Cucumbers");
        regularToppings.add("Pickles");
        regularToppings.add("Guacamole");
        regularToppings.add("Mushrooms");

        cheeses.add("American");
        cheeses.add("Provolone");
        cheeses.add("Cheddar");
        cheeses.add("Swiss");

        sauces.add("Mayo");
        sauces.add("Mustard");
        sauces.add("Ketchup");
        sauces.add("Ranch");
        sauces.add("Thousand Islands");
        sauces.add("Vinaigrette");

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

    // Calculating price
    @Override
    public double calcPrice() {
        double finalPrice = 0;
        double premiumToppingCharge = 0;
        double extraMeatCharge = 0;
        double cheeseCharge = 0;
        double extraCheeseCharge = 0;

        if (this.getSize() != null) {
            switch (this.getSize()) {
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

        if (premiumToppingsList != null) {
            for (String premiumTopping : premiumToppingsList) {
                finalPrice += premiumToppingCharge;
            }
        }

        if (cheesesList != null && !cheesesList.isEmpty()) {
            finalPrice += cheeseCharge;
        }

        if (extraMeat) {
            finalPrice += extraMeatCharge;
        }

        if (extraCheese) {
            finalPrice += extraCheeseCharge;
        }

        return finalPrice;
    }




    @Override
    public String toString() {
        return "-----------Your Sandwich-----------\n" +
                "Bread Size: " + (getSize() != null ? getSize() : "Required") + "\n" +
                "Bread Type: " + (getType() != null ? getType() : "Required") + "\n" +
                "Premium Toppings: " + premiumToppingsList + "\n" +
                "Extra Meat: " + extraMeat + "\n" +
                "Regular Toppings: " + regularToppingsList + "\n" +
                "Cheeses: " + cheesesList + "\n" +
                "Extra Cheese: " + extraCheese + "\n" +
                "Sauces: " + saucesList + "\n" +
                "Toasted: " + toasted + "\n" +
                "Sides: " + sidesList + "\n";
    }
}