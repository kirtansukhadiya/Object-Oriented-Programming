/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 3
 * Question Number: 3
 *
 * Description:
 * This program implements a simple phone book using an ArrayList in Java.
 * It prompts the user to enter at least five contacts, including a name and phone number.
 * The program then stores these contacts and displays them as output.
 *
 * How to Run:
 * 1. Compile the program using: javac Assignment3_Q3.java
 * 2. Run the program using: java Assignment3_Q3
 * 3. Enter at least five contacts when prompted.
 * 4. The program will display the stored contacts.
 */

import java.util.ArrayList;
import java.util.Scanner;

class PhoneBook {
    private String name;
    private String phoneNumber;

    // Constructor
    public PhoneBook(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString method to display contact information
    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}
public class Assignment3_Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PhoneBook> contacts = new ArrayList<>();
        int numContacts;

        // Ensure at least 5 contacts are entered
        do {
            System.out.print("Enter the number of contacts (minimum 5): ");
            numContacts = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (numContacts < 5) {
                System.out.println("You must enter at least 5 contacts.");
            }
        } while (numContacts < 5);

        // Input contacts
        for (int i = 0; i < numContacts; i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            contacts.add(new PhoneBook(name, phoneNumber));
        }

        // Display all contacts
        System.out.println("\nPhone Book Entries:");
        for (PhoneBook contact : contacts) {
            System.out.println(contact);
        }

        scanner.close();
    }
}
