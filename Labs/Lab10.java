import java.util.Arrays;
import java.util.Scanner;

public class Lab10 implements Comparable<Lab10>{
    private String firstName;
    private String lastName;

    public Lab10(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Lab10 other) {
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public String toString() {
        return "(" + lastName + ", " + firstName + ")";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Lab10[] employees = new Lab10[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter first name of employee " + (i + 1) + ": ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name of employee " + (i + 1) + ": ");
            String lastName = scanner.nextLine();
            employees[i] = new Lab10(firstName, lastName);
        }

        System.out.println("\nBefore Sorting");
        for (Lab10 emp : employees) {
            System.out.println(emp);
        }

        Arrays.sort(employees);

        System.out.println("\nAfter Sorting");
        for (Lab10 emp : employees) {
            System.out.println(emp);
        }

        scanner.close();
    }
}
