/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 2
 *
 * Description:
 * This program implements a method to shift a character by a specified number of places
 * in the alphabet, wrapping around to the beginning of the alphabet if necessary.
 * The program takes input from the user: a character and a shift value, and outputs
 * the shifted character. The program handles both uppercase and lowercase letters,
 * and non-alphabet characters remain unchanged.
 *
 * To run the program:
 * 1. Compile the file using `javac Assignment1_Q2.java`.
 * 2. Run the compiled program with `java Assignment1_Q2`.
 * 3. Follow the prompts to enter a character and a shift value.
 */

import java.util.Scanner;

public class Assignment1_Q2 {
    public static char shift(char c, int n) {
        if (Character.isLowerCase(c)) {
            return (char) ('a' + (c - 'a' + n) % 26);
        }
        else if (Character.isUpperCase(c)) {
            return (char) ('A' + (c - 'A' + n) % 26);
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a single character: ");
        char inputChar = scanner.next().charAt(0);

        System.out.print("Enter the shift value (integer): ");
        int shiftValue = scanner.nextInt();

        char shiftedChar = shift(inputChar, shiftValue);
        System.out.println("The shifted character is: " + shiftedChar);

        scanner.close();
    }
}