/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 5 Part 2
 *
 * Description:
 * This program generates a multiplication table using nested loops. The table is structured
 * such that each row contains the multiplication results of that row's index with all numbers
 * from 1 up to the row index. The program uses nested `for` loops: the outer loop determines
 * the row, and the inner loop determines the column. The results are displayed in a formatted
 * structure with tab spacing for alignment.
 *
 * How to run the program:
 * - Save this file as Assignment1_Q5_2.java.
 * - Compile the program using a Java compiler (e.g., `javac Assignment1_Q5_2.java`).
 * - Run the program using the Java runtime environment (e.g., `java Assignment1_Q5_2`).
 * - The multiplication table will be displayed on the console.
 */
public class Assignment1_Q5_2 {
    public static void printMultiplicationTable() {
        for (int i = 1; i <= 9; i++) { // Outer loop for rows
            for (int j = 1; j <= i; j++) { // Inner loop for columns
                System.out.print(i * j + "\t"); // Print product with tab spacing
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    public static void main(String[] args) {
        System.out.println("Multiplication Table:");
        printMultiplicationTable();
    }
}
