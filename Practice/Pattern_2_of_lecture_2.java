/*Pattern needed is:
#####
####
###
##
#*/

public class Pattern_2_of_lecture_2 {
    public static void main(String[] args) {
        int rows = 5; // Total number of rows

        // Outer loop for rows
        for (int i = rows; i >= 1; i--) {
            // Inner loop for printing '#' symbols
            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}