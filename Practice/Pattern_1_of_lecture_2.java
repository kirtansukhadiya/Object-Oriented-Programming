/*Pattern needed is:
1,2,3,4,5,6,7,8,9
2,4,6,8,10,12,14,16,18
3,6,9,12,15,18,21,24,27
4,8,12,16,20,24,28,32,36*/

public class Pattern_1_of_lecture_2{
    public static void main(String[] args) {
        int rows = 4; // Number of rows
        int columns = 9; // Number of columns

        // Outer loop for rows
        for (int i = 1; i <= rows; i++) {
            // Inner loop for columns
            for (int j = 1; j <= columns; j++) {
                System.out.print(i * j); // Print product
                if (j < columns) {
                    System.out.print(","); // Add a comma between numbers
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}