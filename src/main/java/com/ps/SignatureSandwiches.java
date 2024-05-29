package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignatureSandwiches extends Sandwich {

    public SignatureSandwiches(String sandwichType) {
        setSize("8\"");
        setType("White");

        if (sandwichType.equals("BLT")) {
            createBLTSandwich();
        } else if (sandwichType.equals("PhillyCheeseSteak")) {
            createPhillyCheeseSteakSandwich();
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
