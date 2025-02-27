public class MidTerm1 {
    public static void main(String[] args) {
        //int n = 7;
        //int z = 5;
        int a = 5;
       /* for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if(j==1 || i==1 || i==n || j==n){
                    System.out.print(" 4 ");
                }
                else if (j==2 || i == 2 || i == n-1 || j== n-1) {
                    System.out.print(" 3 ");

                }
                else if (j==3 || i ==3 || i == n-2 || j== n-2) {
                    System.out.print(" 2 ");
                }
                else{
                    System.out.print(" 1 ");
                }

            }
            System.out.println();
        }*/
        /*for (int i = 1; i <= z; i++) {
            // Print the top row
            if (i == 1) {
                for (int j = 1; j <= z; j++) {
                    System.out.print(" * ");
                }
            }
            // Print the diagonal
            else if (i < z) {
                for (int j = 1; j <= z - i; j++) {
                    System.out.print("   ");
                }
                System.out.print(" * ");
            }
            // Print the bottom row
            else {
                for (int j = 1; j <= z; j++) {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }*/

        for(int i = 1; i <= a; i++){
            if(i == 1){
                for(int j = 1; j <= a; j++){
                    System.out.print("*");
                }
            }
            else if(i == 3){
                for (int j = 1; j<=a;j++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            else{
                System.out.print("*");

            }
            System.out.println();
        }


    }
}
