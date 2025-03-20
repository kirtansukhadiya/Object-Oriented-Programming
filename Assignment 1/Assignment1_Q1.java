/**
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 1
 * Question Number: 1

 * Description:
 * This program calculates and displays the parking charges for each customer
 * who parked in the garage yesterday. It uses a method `calculateCharges`
 * to determine the charges based on the number of hours parked, ensuring
 * the maximum charge does not exceed $10.00. The program prompts for the
 * number of customers and their parking durations, calculates the charges
 * for each customer, and provides a total receipt for all customers.
 
 * How to run the program:
 * 1. Compile the program using `javac Assignment1_Q1.java`.
 * 2. Run the program using `java Assignment1_Q1`.
 * 3. Follow the prompts to input the number of customers and hours parked.
 * 4. View the charges for each customer and the total receipts.
 */

import java.util.Scanner;

public class Assignment1_Q1 {
    public static int calculateStartDayOfYear(int year) {
        int referenceYear = 2000;
        int referenceStartDay = 6;

        int yearsDifference = year - referenceYear;

        int leapYears = 0;
        if (yearsDifference > 0) {
            for (int i = referenceYear; i < year; i++) {
                if (isLeapYear(i)) {
                    leapYears++;
                }
            }
        } else {
            for (int i = referenceYear - 1; i >= year; i--) {
                if (isLeapYear(i)) {
                    leapYears++;
                }
            }
        }

        int totalDays = yearsDifference * 365 + leapYears;

        return (referenceStartDay + totalDays % 7 + 7) % 7;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getDayOfWeek(int dayOfYear, int startDayOfYearIndex) {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int dayIndex = (startDayOfYearIndex + (dayOfYear - 1)) % 7;
        return daysOfWeek[dayIndex];
    }

    public static int getDay(int month, int day, boolean isLeapYear) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear) {
            daysInMonths[1] = 29;
        }

        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }
        dayOfYear += day;
        return dayOfYear;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the day (1-31): ");
        int day = scanner.nextInt();

        boolean isLeapYear = isLeapYear(year);

        int startDayOfYearIndex = calculateStartDayOfYear(year);

        int dayOfYear = getDay(month, day, isLeapYear);
        String dayOfWeek = getDayOfWeek(dayOfYear, startDayOfYearIndex);
        
        System.out.println("Day of the year: " + dayOfYear);
        System.out.println("Day of the week: " + dayOfWeek);

        scanner.close();
    }
}
