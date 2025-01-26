/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 6
 *
 * Description:
 * This program allows the user to input a sequence of consecutive numbers. The program continues
 * to accept input as long as the entered number is one greater than the previous number.
 * If the sequence is broken, the program stops and displays a message.
 *
 * To run:
 * - Compile the program using `javac Assignment1_Q6.java`.
 * - Run the compiled program using `java Assignment1_Q6`.
 * - Enter a starting number and subsequent numbers. The program will terminate when a non-consecutive
 *   number is entered.
 */
import java.util.Scanner;

public class Assignment1_Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of consecutive numbers. Enter a non-consecutive number to stop.");

        // Start with the first number
        System.out.print("Enter the first number: ");
        int previousNumber = scanner.nextInt();

        while (true) {
            System.out.print("Enter the next number: ");
            int currentNumber = scanner.nextInt();

            // Check if the current number is one greater than the previous number
            if (currentNumber == previousNumber + 1) {
                previousNumber = currentNumber;
            } else {
                System.out.println("The sequence is broken. Stopping the program.");
                break;
            }
        }

        scanner.close();
    }
}
