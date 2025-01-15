import java.util.Scanner;

public class Lab1 {

    // Method to display the bar chart
    public static void displayAsterisks(int[] numbers) {
        System.out.println("\nBar Chart:");
        for (int num : numbers) {
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers between 1 and 30:");

        for (int i = 0; i < 5; i++) {
            while (true) {
                try {
                    System.out.print("Number " + (i + 1) + ": ");
                    int num = scanner.nextInt();

                    if (num >= 1 && num <= 30) {
                        numbers[i] = num;
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 30.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        // Display the bar chart
        displayAsterisks(numbers);

        scanner.close();
    }
}