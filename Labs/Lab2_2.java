import java.util.Scanner;

public class Lab2_2{
    public static double square(double x){
        return x*x;
    }

    public static double distance(double X, double Y){
        return Math.sqrt(X + Y);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter x co-ordinate of point a = ");
        double x1 = input.nextDouble();
        System.out.print("Enter y Co-ordinate of point a = ");
        double y1 = input.nextDouble();
        System.out.println();

        System.out.print("Enter x co-ordinate of point b = ");
        double x2 = input.nextDouble();
        System.out.print("Enter y Co-ordinate of point b = ");
        double y2 = input.nextDouble();
        System.out.println();

        double pointX = square((x2-x1));
        double pointY = square((y2-y1));
        double finalDistance = distance(pointX, pointY);

        System.out.printf("Distance between two points is = %.2f" , finalDistance);
    }
}