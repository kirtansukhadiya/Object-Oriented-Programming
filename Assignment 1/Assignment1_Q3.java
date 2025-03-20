/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 3
 *
 * Description:
 * This program implements a method to convert a boolean value to its String representation.
 * The program takes input from the user (either "true" or "false") and validates it.
 * If the input is valid, it converts the boolean value to a string and displays the result.
 * If the input is invalid, it notifies the user.
 *
 * To run the program:
 * 1. Compile the file using `javac Assignment1_Q3.java`.
 * 2. Run the compiled program with `java Assignment1_Q3`.
 * 3. Follow the prompts to enter a boolean value.
 */

import java.util.Scanner;

public class Assignment1_Q3 {
    public static String boolToString(boolean value) {
        return Boolean.toString(value); // Converts the boolean to its string representation
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get boolean input from the user
        System.out.print("Enter 'true' or 'false': ");
        String userInput = scanner.nextLine().trim().toLowerCase();

        // Validate input and convert to boolean
        if (userInput.equals("true") || userInput.equals("false")) {
            boolean value = Boolean.parseBoolean(userInput);

            // Convert to String and display the result
            String result = boolToString(value);
            System.out.println("The boolean as a string is: " + result);
        } else {
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
        }

        scanner.close();
    }
}
