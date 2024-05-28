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
    @Override
    public String toString() {
        return "-----------Your Sandwich-----------  \n" +
                "  Bread Size: " + (getSize() != null ? getSize() : "Required") + "\n" +
                "  Bread Type: " + (getType() != null ? getType() : "Required") + "\n" +
                "  Meats: " + (premiumToppingsList != null && !premiumToppingsList.isEmpty() ? String.join(", ", premiumToppingsList) : "N/A") + "\n" +
                "  Regular Toppings: " + (regularToppingsList != null && !regularToppingsList.isEmpty() ? String.join(", ", regularToppingsList) : "N/A") + "\n" +
                "  Cheeses: " + (cheesesList != null && !cheesesList.isEmpty() ? String.join(", ", cheesesList) : "N/A") + "\n" +
                "  Extra Cheese: " + (extraCheese ? "Yes" : "No") + "\n" +
                "  Sauces: " + (saucesList != null && !saucesList.isEmpty() ? String.join(", ", saucesList) : "N/A") + "\n" +
                "  Sides: " + (sidesList != null && !sidesList.isEmpty() ? String.join(", ", sidesList) : "N/A") + "\n" +
                "  Toasted: " + (toasted ? "Yes" : "No") + "\n" +
                " ";
    }


    //  method to handle sandwich creation.
    public void homeScreen(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            Sandwich userSandwich = new Sandwich();
            boolean isCreatingSandwich = true;

            while (isCreatingSandwich) {

                // Display the current state of the sandwich being created
                System.out.printf("\n%s\n", userSandwich);

                // Display options for sandwich customization
                System.out.println("[1] Choose bread size");
                System.out.println("[2] Choose bread type");
                System.out.println("[3] Choose meats (extra charge)");
                System.out.println("[4] Choose regular toppings");
                System.out.println("[5] Choose cheeses");
                System.out.println("[6] Choose sauces");
                System.out.println("[7] Choose sides");
                System.out.println("[8] Choose signature sandwich");
                System.out.println(GREEN + "[9] Finalize sandwich" + RESET);
                System.out.println(RED + "[0] Cancel sandwich" + RESET);

                if (scanner.hasNextInt()) {
                    int createSandwichChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Handle user choices for sandwich customization
                    switch (createSandwichChoice) {
                        case 1:
                            chooseBreadSize(scanner, userSandwich);
                            break;

                        case 2:
                            chooseBreadType(scanner, userSandwich);
                            break;

                        case 3:
                            chooseToppings(scanner, userSandwich, Sandwich.premiumToppings, "premium");
                            break;

                        case 4:
                            chooseToppings(scanner, userSandwich, Sandwich.regularToppings, "regular");
                            break;

                        case 5:
                            chooseCheeses(scanner, userSandwich);
                            break;

                        case 6:
                            chooseSauces(scanner, userSandwich);
                            break;

                        case 7:
                            chooseSides(scanner, userSandwich);
                            break;

                        case 8:
                            userSandwich = CustomSandwiches.chooseSignatureSandwich(scanner);
                            break;

                        case 9:
                            if (checkIfRequiredItemsAreChosen(userSandwich)) {
                                System.out.print(YELLOW + "Would you like your sandwich toasted? (Y/N): " + RESET);
                                String toasted = scanner.nextLine();
                                if (toasted.equalsIgnoreCase("y")) {
                                    userSandwich.setToasted(true);
                                }

                                if (userSandwich.getCheeses() != null && !userSandwich.getCheeses().isEmpty()) {
                                    System.out.print(YELLOW + "Would you like extra cheese on your sandwich? (Y/N): " + RESET);
                                    String extraCheese = scanner.nextLine();
                                    if (extraCheese.equalsIgnoreCase("y")) {
                                        userSandwich.setExtraCheese(true);
                                    }
                                }

                                if (userSandwich.getPremiumToppings() != null && !userSandwich.getPremiumToppings().isEmpty()) {
                                    System.out.print(YELLOW + "Would you like extra meat on your sandwich? (Y/N): " + RESET);
                                    String extraMeat = scanner.nextLine();

                                    if (extraMeat.equalsIgnoreCase("y")) {
                                        userSandwich.setExtraMeat(true);
                                    }
                                }
                                OrderScreen.sandwiches.add(userSandwich);
                                isCreatingSandwich = false;

                            } else {
                                System.out.println(RED + "Sorry, it seems that you haven't chosen the required items (sandwich size / sandwich type)\nPlease select one of each to finalize your sandwich." + RESET);
                            }
                            break;

                        case 0:
                            isCreatingSandwich = false;
                            break;

                        default:
                            System.out.println(RED + "Invalid choice, please try again." + RESET);
                            break;
                    }
                } else {
                    scanner.nextLine(); // Consume invalid input
                    System.out.println(RED + "Invalid input, please enter a number." + RESET);
                }
            }

            // Ask if the user wants to create another sandwich
            System.out.println(GREEN + "Would you like to add another sandwich? (Y/N): " + RESET);
            String addAnother = scanner.nextLine();
            if (!addAnother.equalsIgnoreCase("y")) {
                isRunning = false;
            }
        }
    }

    // Method to handle bread size selection
    private void chooseBreadSize(Scanner scanner, Sandwich userSandwich) {
        boolean isChoosingBreadSize = true;
        while (isChoosingBreadSize) {
            System.out.println("Please indicate the size of your sandwich:");
            System.out.println("[1] 4\" ($5.50)");
            System.out.println("[2] 8\" ($7.00)");
            System.out.println("[3] 12\" ($8.50)");

            int breadSizeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (breadSizeChoice) {
                case 1:
                    userSandwich.setSize("4\"");
                    isChoosingBreadSize = false;
                    break;

                case 2:
                    userSandwich.setSize("8\"");
                    isChoosingBreadSize = false;
                    break;

                case 3:
                    userSandwich.setSize("12\"");
                    isChoosingBreadSize = false;
                    break;

                default:
                    System.out.println(RED + "That is not a valid choice, please select a valid option..." + RESET);
                    break;
            }
        }
    }

    // Method to handle bread type selection
    private void chooseBreadType(Scanner scanner, Sandwich userSandwich) {
        boolean isChoosingBreadType = true;
        while (isChoosingBreadType) {
            System.out.println("Choose your bread type:");
            System.out.println("[1] Wheat");
            System.out.println("[2] White");
            System.out.println("[3] Rye");
            System.out.println("[4] Wrap");

            int breadChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (breadChoice) {
                case 1:
                    userSandwich.setType("Wheat");
                    isChoosingBreadType = false;
                    break;

                case 2:
                    userSandwich.setType("White");
                    isChoosingBreadType = false;
                    break;

                case 3:
                    userSandwich.setType("Rye");
                    isChoosingBreadType = false;
                    break;

                case 4:
                    userSandwich.setType("Wrap");
                    isChoosingBreadType = false;
                    break;

                default:
                    System.out.println(RED + "That is not a valid choice, please select a valid option..." + RESET);
                    break;
            }
        }
    }

    //handle topping selection
    public void chooseToppings(Scanner scanner,
                               Sandwich userSandwich,
                               List<String> toppings,
                               String type) {

        List<String> chosenToppings = new ArrayList<>();
        boolean isChoosingToppings = true;
        while (isChoosingToppings) {
            System.out.println("Please choose which toppings to add:");
            for (int i = 0; i < toppings.size(); i++) {
                System.out.printf("[%d] %s\n", i + 1, toppings.get(i));
            }

            System.out.println("[D] Done");
            System.out.println("[X] Cancel choosing toppings...");

            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (userChoice < 1 || userChoice > toppings.size()) {
                    System.out.println(RED + "Please provide a valid choice..." + RESET);
                } else {
                    chosenToppings.add(toppings.get(userChoice - 1));
                }
            } else {
                String userDone = scanner.nextLine();
                switch (userDone.toLowerCase()) {
                    case "d":
                        System.out.printf("Summary of %s toppings:\n\n", type);
                        chosenToppings.forEach(System.out::println);
                        System.out.print("Is this correct? (Y/N): ");
                        String accepted = scanner.nextLine();
                        switch (accepted.toLowerCase()) {
                            case "y":
                                if (type.equals("premium")) {
                                    userSandwich.setPremiumToppings(chosenToppings);
                                } else if (type.equals("regular")) {
                                    userSandwich.setRegularToppings(chosenToppings);
                                }
                                isChoosingToppings = false;
                                break;
                            case "n":
                                System.out.println(RED + "Enter toppings again." + RESET);
                                break;
                            default:
                                System.out.println(RED + "That is not a valid choice, try again..." + RESET);
                                break;
                        }
                        break;
                    case "x":
                        isChoosingToppings = false;
                        break;
                    default:
                        System.out.println(RED + "This is not a valid choice... Please enter a valid choice." + RESET);
                        break;
                }
            }
        }
    }

    //handle cheese selection
    private void chooseCheeses(Scanner scanner, Sandwich userSandwich) {
        List<String> chosenCheeses = new ArrayList<>();
        boolean isChoosingCheeses = true;
        while (isChoosingCheeses) {
            System.out.println("Please choose which cheeses to add:");
            for (int i = 0; i < Sandwich.cheeses.size(); i++) {
                System.out.printf("[%d] %s\n", i + 1, Sandwich.cheeses.get(i));
            }
            System.out.println("[D] Done");
            System.out.println("[X] Cancel choosing cheeses...");

            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (userChoice < 1 || userChoice > Sandwich.cheeses.size()) {
                    System.out.println(RED + "Please provide a valid choice..." + RESET);
                } else {
                    chosenCheeses.add(Sandwich.cheeses.get(userChoice - 1));
                }

            } else {
                String userDone = scanner.nextLine();
                switch (userDone.toLowerCase()) {
                    case "d":
                        System.out.println("\nSummary of cheeses:");
                        chosenCheeses.forEach(System.out::println);
                        System.out.print("Is this correct? (Y/N): ");
                        String accepted = scanner.nextLine();
                        switch (accepted.toLowerCase()) {
                            case "y":
                                userSandwich.setCheeses(chosenCheeses);
                                isChoosingCheeses = false;
                                break;
                            case "n":
                                System.out.println(RED + "Enter cheeses again." + RESET);
                                break;
                            default:
                                System.out.println(RED + "That is not a valid choice, try again..." + RESET);
                                break;
                        }
                        break;
                    case "x":
                        isChoosingCheeses = false;
                        break;
                    default:
                        System.out.println(RED + "This is not a valid choice... Please enter a valid choice." + RESET);
                        break;
                }
            }
        }
    }

    // handle sauce selection
    private void chooseSauces(Scanner scanner, Sandwich userSandwich) {
        List<String> chosenSauces = new ArrayList<>();
        boolean isChoosingSauces = true;
        while (isChoosingSauces) {
            System.out.println("Please choose which sauces to add:");
            for (int i = 0; i < Sandwich.sauces.size(); i++) {
                System.out.printf("[%d] %s\n", i + 1, Sandwich.sauces.get(i));
            }
            System.out.println("[D] Done");

            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (userChoice < 1 || userChoice > Sandwich.sauces.size()) {
                    System.out.println(RED + "Please provide a valid choice..." + RESET);
                } else {
                    chosenSauces.add(Sandwich.sauces.get(userChoice - 1));
                }
            } else {
                String userDone = scanner.nextLine();
                if (userDone.equalsIgnoreCase("d")) {
                    System.out.println("\nSummary of sauces:");
                    chosenSauces.forEach(System.out::println);
                    System.out.print("Is this correct? (Y/N): ");
                    String accepted = scanner.nextLine();
                    switch (accepted.toLowerCase()) {
                        case "y":
                            userSandwich.setSauces(chosenSauces);
                            isChoosingSauces = false;
                            break;
                        case "n":
                            System.out.println(RED + "Choose sauces again." + RESET);
                            break;
                    }
                } else {
                    System.out.println(RED + "This is not a valid choice... Please enter a valid choice." + RESET);
                }
            }
        }
    }

    //handle sides selection
    private void chooseSides(Scanner scanner, Sandwich userSandwich) {
        List<String> chosenSides = new ArrayList<>();
        boolean isChoosingSides = true;
        while (isChoosingSides) {
            System.out.println("Please choose which sides to add:");
            for (int i = 0; i < Sandwich.sides.size(); i++) {
                System.out.printf("[%d] %s\n", i + 1, Sandwich.sides.get(i));
            }
            System.out.println("[D] Done");

            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (userChoice < 1 || userChoice > Sandwich.sides.size()) {
                    System.out.println(RED + "Please provide a valid choice..." + RESET);
                } else {
                    chosenSides.add(Sandwich.sides.get(userChoice - 1));
                }
            } else {
                String userDone = scanner.nextLine();
                if (userDone.equalsIgnoreCase("d")) {
                    System.out.println("\nSummary of sides:");
                    chosenSides.forEach(System.out::println);
                    System.out.print("Is this correct? (Y/N): ");
                    String accepted = scanner.nextLine();
                    switch (accepted.toLowerCase()) {
                        case "y":
                            userSandwich.setSides(chosenSides);
                            isChoosingSides = false;
                            break;
                        case "n":
                            System.out.println(RED + "Choose sides again." + RESET);
                            break;
                    }
                } else {
                    System.out.println(RED + "This is not a valid choice... Please enter a valid choice." + RESET);
                }
            }
        }
    }

    // Method to check if required items (size and type) are chosen
    private boolean checkIfRequiredItemsAreChosen(Sandwich userSandwich) {
        return userSandwich.getSize() != null && userSandwich.getType() != null;
    }
}
