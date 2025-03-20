/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 4
 *
 * Description:
 * This program prints a table displaying the values of N, its square, and its cube for numbers 1 to 5.
 * The table is formatted with proper alignment for readability.
 *
 * To run the program:
 * 1. Compile the file using `javac Assignment1_Q4.java`.
 * 2. Run the compiled program with `java Assignment1_Q4`.
 */

public class Assignment1_Q4 {
    public static void main(String[] args) {
        // Print the table header
        System.out.printf("%-5s %-10s %-10s%n", "N", "SQUARE", "CUBE");

        // Print the table rows for numbers 1 to 5
        for (int n = 1; n <= 5; n++) {
            int square = n * n;
            int cube = n * n * n;
            System.out.printf("%-5d %-10d %-10d%n", n, square, cube);
        }
    }
}
