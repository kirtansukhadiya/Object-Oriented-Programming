/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 8
 *
 * Description:
 * This program takes four integer inputs from the user and displays a vertical bar graph
 * using asterisks (*). The height of each column corresponds to the input value, and the
 * graph is displayed dynamically based on the maximum value among the inputs. The base
 * of the graph includes labels (1, 2, 3, 4) for each column.
 *
 * How to run:
 * 1. Compile the program using a Java compiler (e.g., `javac Assignment1_Q8.java`).
 * 2. Run the compiled program (`java Assignment1_Q8`).
 * 3. Enter four integer values when prompted.
 * 4. The program will display a vertical bar graph corresponding to the entered values.
 */
import java.util.Scanner;

public class Assignment1_Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter four values to draw bar graphs:");
        int value1 = scanner.nextInt();
        int value2 = scanner.nextInt();
        int value3 = scanner.nextInt();
        int value4 = scanner.nextInt();

        int maxValue = Math.max(Math.max(value1, value2), Math.max(value3, value4));

        System.out.println("\nVertical Bar Graph:");
        for (int i = maxValue; i > 0; i--) {
            System.out.print(" | ");
            System.out.print(value1 >= i ? "** " : "   ");
            System.out.print(value2 >= i ? "** " : "   ");
            System.out.print(value3 >= i ? "** " : "   ");
            System.out.print(value4 >= i ? "** " : "   ");
            System.out.println();
        }

        System.out.print("    ");
        for (int i = 0; i < 4; i++) {
            System.out.print("--");
        }
        System.out.println();


        scanner.close();
    }
}
