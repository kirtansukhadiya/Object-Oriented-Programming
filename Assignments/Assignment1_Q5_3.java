/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 5 Part 3
 *
 * Description:
 * This program generates and prints four patterns (Right triangle, Left triangle, X-pattern, and Z-pattern)
 * side by side. The program uses modular design with helper methods for each pattern and space handling.
 *
 * To run:
 * - Compile the program using `javac Assignment1_Q5_3.java`
 * - Run the compiled code using `java Assignment1_Q5_3`
 * - Adjust the `size` variable in the main method to control the dimensions of the patterns.
 */
public class Assignment1_Q5_3 {
    public static void printPatterns(int size) {
        for (int row = 0; row < size; row++) {
            printRightTriangle(size, row);
            printSpaces(4);
            printLeftTriangle(size, row);
            printSpaces(4);
            printXPattern(size, row);
            printSpaces(4);
            printZPattern(size, row);
            System.out.println();
        }
    }

    private static void printRightTriangle(int size, int row) {
        for (int col = 0; col < size; col++) {
            if (col >= row) {
                System.out.print("# ");
            } else {
                System.out.print("  ");
            }
        }
    }

    private static void printLeftTriangle(int size, int row) {
        for (int col = 0; col < size; col++) {
            if (col <= size - 1 - row) {
                System.out.print("# ");
            } else {
                System.out.print("  ");
            }
        }
    }

    private static void printXPattern(int size, int row) {
        for (int col = 0; col < size; col++) {
            if (row == 0 || row == size - 1 || col == row || col == size - 1 - row) {
                System.out.print("# ");
            } else {
                System.out.print("  ");
            }
        }
    }

    private static void printZPattern(int size, int row) {
        for (int col = 0; col < size; col++) {
            if (row == 0 || row == size - 1 || col == size - 1 - row) {
                System.out.print("# ");
            } else {
                System.out.print("  ");
            }
        }
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("  ");
        }
    }

    public static void main(String[] args) {
        int size = 8;
        printPatterns(size);
    }
}

