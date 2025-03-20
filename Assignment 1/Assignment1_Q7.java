/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 7
 *
 * Description:
 * This program calculates the number of years it will take for a radioactive substance to decay
 * until less than 2% of its original atoms remain. The user inputs the substance's name and its
 * half-life in years. The calculation is based on exponential decay using the formula:
 *
 * N(t) = N0 * (1/2)^(t / half-life)
 *
 * To run:
 * - Compile the program using `javac Assignment1_Q7.java`.
 * - Run the compiled program using `java Assignment1_Q7`.
 * - Enter the substance name and its half-life in years when prompted.
 */import java.util.Scanner;

public class Assignment1_Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Radioactive Decay Calculator");

        System.out.print("Enter the name of the substance: ");
        String substanceName = scanner.nextLine();

        System.out.print("Enter the half-life of the substance (in years): ");
        double halfLife = scanner.nextDouble();

        double remainingPercentage = 100.0;
        int years = 0;

        while (remainingPercentage >= 2.0) {
            remainingPercentage /= 2;
            years += halfLife;
        }

        System.out.printf(
                "It will take approximately %d years for %s to decay to less than 2%% of its original amount.\n",
                years, substanceName
        );

        scanner.close();
    }

}
