import java.util.Scanner;

public class Lab2_1{
    public static double biggerCircle(int bigCircleRadius){
        double biggerCircleArea = Math.PI*(bigCircleRadius*bigCircleRadius);
        System.out.printf("Area bigger/outer circle is = %.2f", biggerCircleArea);
        System.out.println();
        return biggerCircleArea;
    }

    public static double smallerCircle(double smallCircleRadius){
        double smallerCircleArea = Math.PI*(smallCircleRadius*smallCircleRadius);
        System.out.printf("Area bigger/outer circle is = %.2f" , smallerCircleArea);
        System.out.println();
        return smallerCircleArea;
    }

    public static double areaCircle(double biggerCircleArea, double smallerCircleArea){
        return biggerCircleArea - smallerCircleArea;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Radius of Bigger/outer circle: ");
        int bigCircleRadius = input.nextInt();

        System.out.print("Enter Radius of smaller/inner circle: ");
        int smallCircleRadius = input.nextInt();

        double biggerCircleArea = biggerCircle(bigCircleRadius);
        double smallerCircleArea = smallerCircle(smallCircleRadius);

        double totalAreaOfDonut = areaCircle(biggerCircleArea, smallerCircleArea);
        System.out.printf("Area of the Donut is = %.2f" , totalAreaOfDonut);
    }


}
