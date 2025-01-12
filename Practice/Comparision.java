import java.util.Scanner;

public class Comparision{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter First Integer: ");
        int number1 = input.nextInt();

        System.out.print("Enter Second Integer: ");
        int number2 = input.nextInt();

        if (number1 == number2)
            System.out.printf("%d == %d%n", number1, number2);

        if (number1 != number2)
            System.out.printf("%d != %d%n", number1, number2);

        if (number1 < number2)
            System.out.printf("%d < %d%n", number1, number2);

        if (number1 > number2)
            System.out.printf("%d > %d", number1, number2);
    }
}