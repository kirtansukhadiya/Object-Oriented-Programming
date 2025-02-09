/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 2
 * Question Number: 1
 *
 * Description:
 * This program takes a positive integer N as input from the user and determines
 * the maximum number of guesses required to find the number using a binary search-like approach.
 * It does this by repeatedly dividing N by 2 until it reaches 0 and counting the number of steps taken.
 *
 * How to Run:
 * - Compile the program using: javac Assignment2_Q1.java
 * - Run the program using: java Assignment2_Q1
 * - Enter a positive integer when prompted.
 */

import java.util.Scanner;

public class Assignment2_Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a positive integer N: ");
        int N = scanner.nextInt();

        // Validate input
        if (N <= 0) {
            System.out.println("N must be a positive integer.");
        } else {
            int guesses = 0;
            int current = N;

            // Keep dividing by 2 until we reach 0
            while (current > 0) {
                current /= 2;
                guesses++;
            }

            // Output the result
            System.out.println("It will take at most " + guesses + " guesses to find the number.");
        }

        scanner.close();
    }
}
