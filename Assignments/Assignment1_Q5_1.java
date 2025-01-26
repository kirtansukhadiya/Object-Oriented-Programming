/*
 * Author: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment No: 1
 * Question No: 5 Part 1
 *
 * Description:
 * This Java program includes a menu to test a method that generates and prints a
 * string of N repeated characters. The program takes a character and an integer
 * input from the user, then prints a string of that character repeated N times.
 * The user can choose to generate another string or exit the program.
 *
 * Program Structure:
 * - The method `printChars(char ch, int n)` generates a string of N characters
 *   based on the provided character and integer input.
 * - The `main` method contains a loop that displays a menu, takes user input,
 *   and calls the `printChars` method.
 * - The program runs in a loop until the user selects the option to exit.
 *
 * How to Run:
 * 1. Compile the Java program: `javac Assignment1_Q5_1.java`
 * 2. Run the program: `java Assignment1_Q5_1`
 * 3. Follow the menu options to generate strings or exit the program.
 */

import java.util.Scanner;

public class Assignment1_Q5_1 {
    public static void printChars(char ch, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(ch);
        }
        System.out.println("Generated String: " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Generate String");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a character: ");
                    char ch = scanner.next().charAt(0);
                    System.out.print("Enter the number of repetitions: ");
                    int n = scanner.nextInt();
                    printChars(ch, n);
                    break;

                case 2:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // Blank line for readability
        } while (choice != 2);

        scanner.close();
    }
}
