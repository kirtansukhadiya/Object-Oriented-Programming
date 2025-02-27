import java.util.Scanner;

class IntegerImp {
    private int value;

    public IntegerImp(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isEven(IntegerImp obj) {
        return obj.value % 2 == 0;
    }

    public boolean equals(int num) {
        return this.value == num;
    }

    public boolean equals(IntegerImp obj) {
        return this.value == obj.value;
    }

    public static int parseInt(char[] chars) {
        int result = 0;
        for (char c : chars) {
            if (c < '0' || c > '9') {
                throw new NumberFormatException("Invalid character in array");
            }
            result = result * 10 + (c - '0');
        }
        return result;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    public static void swap(IntegerImp obj1, IntegerImp obj2) {
        int temp = obj1.value;
        obj1.value = obj2.value;
        obj2.value = temp;
    }
}

public class Lab7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value for num1: ");
        int num1Value = scanner.nextInt();
        IntegerImp num1 = new IntegerImp(num1Value);

        System.out.print("Enter the value for num2: ");
        int num2Value = scanner.nextInt();
        IntegerImp num2 = new IntegerImp(num2Value);

        System.out.print("Enter the value for num3: ");
        int num3Value = scanner.nextInt();
        IntegerImp num3 = new IntegerImp(num3Value);

        System.out.println("Value of num1: " + num1.getValue());
        System.out.println("num1 is even: " + num1.isEven());
        System.out.println("num2 is even: " + num2.isEven());
        System.out.println("Is 10 even? " + IntegerImp.isEven(10));
        System.out.println("Is 15 even? " + IntegerImp.isEven(15));
        System.out.println("Is num1 even? " + IntegerImp.isEven(num1));
        System.out.println("Is num2 even? " + IntegerImp.isEven(num2));
        System.out.println("num1 equals 10: " + num1.equals(10));
        System.out.println("num1 equals num2: " + num1.equals(num2));
        System.out.println("num1 equals num3: " + num1.equals(num3));

        System.out.print("Enter a string to parse into an int: ");
        String str = scanner.next();
        System.out.println("Parsed int from string: " + IntegerImp.parseInt(str));

        System.out.println("Before swap:");
        System.out.println("num1 value: " + num1.getValue());
        System.out.println("num2 value: " + num2.getValue());

        IntegerImp.swap(num1, num2);

        System.out.println("After swap:");
        System.out.println("num1 value: " + num1.getValue());
        System.out.println("num2 value: " + num2.getValue());

        scanner.close();
    }
}
