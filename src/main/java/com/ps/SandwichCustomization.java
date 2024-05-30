package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichCustomization {

    // ansi code
    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";

    // Method to handle the home screen for sandwich customization
    public void homeScreen(Scanner scanner) {
        boolean isRunning = true;

        do {
            // Create a new sandwich object with default values
            Sandwich userSandwich = new Sandwich(
                    "Required",
                    "Required",
                    0.0, new ArrayList<>(),
                    false,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    false,
                    new ArrayList<>(),
                    false,
                    new ArrayList<>());
            boolean isCreatingSandwich = true;

            do {
                // Display the current sandwich state
                System.out.printf("\n%s\n", userSandwich);

                // Display options for customizing the sandwich
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

                // Handle user's choice for sandwich customization
                if (scanner.hasNextInt()) {
                    int createSandwichChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

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
                            userSandwich = SignatureSandwiches.chooseSignatureSandwich(scanner);
                            break;
                        case 9:
                            // Finalize the sandwich if required items are chosen
                            if (checkIfRequiredItemsAreChosen(userSandwich)) {
                                System.out.print(YELLOW + "Would you like your sandwich toasted? (Y/N): " + RESET);
                                String toasted = scanner.nextLine();

                                if (toasted.equalsIgnoreCase("y")) {
                                    userSandwich.setToasted(true);
                                }

                                // Ask for extra cheese if cheese is already chosen
                                if (userSandwich.getCheeses() != null && !userSandwich.getCheeses().isEmpty()) {
                                    System.out.print(YELLOW + "Would you like extra cheese on your sandwich? (Y/N): " + RESET);
                                    String extraCheese = scanner.nextLine();

                                    if (extraCheese.equalsIgnoreCase("y")) {
                                        userSandwich.setExtraCheese(true);
                                    }
                                }

                                // Ask for extra meat if premium toppings are chosen
                                if (userSandwich.getPremiumToppings() != null && !userSandwich.getPremiumToppings().isEmpty()) {
                                    System.out.print(YELLOW + "Would you like extra meat on your sandwich? (Y/N): " + RESET);
                                    String extraMeat = scanner.nextLine();

                                    if (extraMeat.equalsIgnoreCase("y")) {
                                        userSandwich.setExtraMeat(true);
                                    }
                                }
                                UserInterface.sandwiches.add(userSandwich);
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
            } while (isCreatingSandwich);

            // Ask if the user wants to add another sandwich
            System.out.print(GREEN + "Would you like to add another sandwich? (Y/N): " + RESET);
            String addAnother = scanner.nextLine();
            if (!addAnother.equalsIgnoreCase("y")) {
                isRunning = false;
            }
        } while (isRunning);
    }

    // Method to choose bread size
    private void chooseBreadSize(Scanner scanner, Sandwich userSandwich) {
        boolean isChoosingBreadSize = true;
        do {
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
        } while (isChoosingBreadSize);
    }

    // Method to choose bread type
    private void chooseBreadType(Scanner scanner, Sandwich userSandwich) {
        boolean isChoosingBreadType = true;
        do {
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
        } while (isChoosingBreadType);
    }

    // Method to choose toppings
    private void chooseToppings(Scanner scanner,
                                Sandwich userSandwich,
                                List<String> toppings,
                                String type) {

        List<String> chosenToppings = new ArrayList<>();
        boolean isChoosingToppings = true;
        do {
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

                        // loops through and prints each topping chosen by the user

                        for (String topping : chosenToppings) {
                            System.out.println(topping);
                        }

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
        } while (isChoosingToppings);
    }

    // Method to choose cheeses
    private void chooseCheeses(Scanner scanner, Sandwich userSandwich) {

        List<String> chosenCheeses = new ArrayList<>();
        boolean isChoosingCheeses = true;
        do {
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

                        for (String cheese : chosenCheeses) {
                            System.out.println(cheese);
                        }
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
        } while (isChoosingCheeses);
    }

    // Method to choose sauces
    private void chooseSauces(Scanner scanner, Sandwich userSandwich) {
        List<String> chosenSauces = new ArrayList<>();
        boolean isChoosingSauces = true;
        do {
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

                    for (String sauce : chosenSauces) {
                        System.out.println(sauce);
                    }

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
        } while (isChoosingSauces);
    }

    // Method to choose sides
    private void chooseSides(Scanner scanner, Sandwich userSandwich) {
        List<String> chosenSides = new ArrayList<>();
        boolean isChoosingSides = true;
        do {
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

                    for (String side : chosenSides) {
                        System.out.println(side);
                    }
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
        } while (isChoosingSides);
    }

    // Method to check if the required items (size and type) are chosen
    private boolean checkIfRequiredItemsAreChosen(Sandwich userSandwich) {
        return userSandwich.getSize() != null && userSandwich.getType() != null;
    }
}
