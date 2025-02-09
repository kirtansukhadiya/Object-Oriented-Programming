/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 2
 * Question Number: 4
 *
 * Description:
 * This program simulates a simple banking system with 10 accounts.
 * Each account has an ID (0-9) and a starting balance of $100.
 * Users can select an account by entering the ID and perform transactions such as:
 * - Viewing Balance
 * - Withdrawing Money
 * - Depositing Money
 * - Returning to account selection
 * The program continues until the user enters -1 to exit.
 *
 * How to Run:
 * 1. Compile the program using: javac Assignment2_Q4.java
 * 2. Run the program using: java Assignment2_Q4
 * 3. Follow on-screen instructions to interact with the banking system.
 */

import java.util.Date;
import java.util.Scanner;

public class Assignment2_Q4 {

    // Account class
    static class Account {
        private int id;
        private double balance;
        private static double annualInterestRate = 0;
        private Date dateCreated;

        public Account() {
            this(0, 0);
        }

        public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
            this.dateCreated = new Date();
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public double getBalance() { return balance; }
        public void setBalance(double balance) { this.balance = balance; }
        public static double getAnnualInterestRate() { return annualInterestRate; }
        public static void setAnnualInterestRate(double rate) { annualInterestRate = rate; }
        public Date getDateCreated() { return dateCreated; }
        public double getMonthlyInterestRate() { return annualInterestRate / 12; }
        public double getMonthlyInterest() { return balance * getMonthlyInterestRate() / 100; }

        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient funds!");
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful.");
            }
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposit successful.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account[] accounts = new Account[10];

        // Initialize accounts with IDs 0-9 and balance $100
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100);
        }

        while (true) {
            int userId;

            // Prompt for user ID, allowing exit with -1
            while (true) {
                System.out.print("Enter account ID (0-9) or -1 to quit: ");
                userId = input.nextInt();

                if (userId == -1) {
                    System.out.println("Exiting program... Goodbye!");
                    input.close();
                    return;  // Ends the program
                }

                if (userId >= 0 && userId <= 9) {
                    break; // Valid ID, proceed to menu
                }

                System.out.println("Invalid ID! Try again.");
            }

            Account userAccount = accounts[userId];

            // Main menu loop
            while (true) {
                System.out.println("\nMain Menu:");
                System.out.println("1: View Balance");
                System.out.println("2: Withdraw Money");
                System.out.println("3: Deposit Money");
                System.out.println("4: Exit to Account Selection");
                System.out.print("Enter a choice: ");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your balance: $" + userAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = input.nextDouble();
                        userAccount.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = input.nextDouble();
                        userAccount.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Returning to account selection...\n");
                        break; // Goes back to account selection
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

                if (choice == 4) {
                    break; // Exit inner loop and return to ID selection
                }
            }
        }
    }
}