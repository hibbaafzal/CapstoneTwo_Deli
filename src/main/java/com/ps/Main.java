package com.ps;

import java.util.Scanner;

public class Main {
    // ANSI color codes
    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n\n\n" + GREEN + "--------------Welcome to the DELI-cious Sandwich Shop!--------------" + RESET);
            System.out.println("How can we get you started today?");
            System.out.println("[1] New Order");
            System.out.println("[0] Exit");

            if (scanner.hasNextInt()) {
                int newOrderCommand = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (newOrderCommand) {
                    case 1:
                        OrderScreen.startOrder(scanner);
                        break;
                    case 0:
                        isRunning = false;
                        System.out.println(YELLOW + "Thank you for visiting DELI-cious Sandwich Shop! Have a great day!" + RESET);
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
    }
}
