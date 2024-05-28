package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chips {



    // Adding chips to order
    public static void addChips(Scanner scanner) {
        System.out.print("How many bags of chips would you like?: ");

        // Check if the next input is an integer
        if (scanner.hasNextInt()) {
            int numberOfBags = scanner.nextInt();
            scanner.nextLine();


            if (numberOfBags > 0) {
                // add the specified number of bags to the order
                for (int i = 0; i < numberOfBags; i++) {
                    OrderScreen.chips.add("Bag of chips");
                }

                System.out.println(numberOfBags + " bag(s) of chips added to your order.");
            } else {
                // invalid if the number is not positive
                System.out.println("Invalid choice. Please enter a positive number.");
            }
        } else {

            scanner.nextLine();

            System.out.println("Invalid input, please enter a number.");
        }
    }
}
