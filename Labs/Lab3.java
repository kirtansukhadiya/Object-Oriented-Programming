import java.util.Scanner;

public class Lab3 {
    public static double calculateCharges(int hoursParked) {
        double charge = 2.00;

        if (hoursParked > 3) {
            charge += 0.50 * (hoursParked - 3);
        }

        return Math.min(charge, 10.00);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalReceipts = 0.0;

        System.out.println("Enter the number of customers: ");
        int numberOfCustomers = scanner.nextInt();

        for (int i = 1; i <= numberOfCustomers; i++) {
            System.out.print("Enter hours parked for customer " + i + ": ");
            int hoursParked = scanner.nextInt();

            double charge = calculateCharges(hoursParked);

            System.out.printf("Charge for customer %d: $%.2f%n", i, charge);

            totalReceipts += charge;
        }

        System.out.printf("Total receipts for yesterday: $%.2f%n", totalReceipts);

        scanner.close();
    }
}
