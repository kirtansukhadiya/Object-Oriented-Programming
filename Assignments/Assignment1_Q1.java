import java.util.Scanner;

public class Assignment1_Q1 {
    public static int calculateStartDayOfYear(int year) {
        // Reference year 2000 was a Saturday (index 6)
        int referenceYear = 2000;
        int referenceStartDay = 6;

        // Calculate the number of years between the input year and the reference year
        int yearsDifference = year - referenceYear;

        // Count leap years between the reference year and the input year
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

        // Total days difference (365 days per year + 1 extra day per leap year)
        int totalDays = yearsDifference * 365 + leapYears;

        // Calculate the starting day of the input year
        return (referenceStartDay + totalDays % 7 + 7) % 7; // Add 7 to handle negative differences
    }

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to determine the day of the week based on the day of the year
    public static String getDayOfWeek(int dayOfYear, int startDayOfYearIndex) {
        // Days of the week (0 = Sunday, 1 = Monday, ..., 6 = Saturday)
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Calculate the day of the week using modular arithmetic
        int dayIndex = (startDayOfYearIndex + (dayOfYear - 1)) % 7;
        return daysOfWeek[dayIndex];
    }

    // Method to calculate the day of the year given the month and day
    public static int getDay(int month, int day, boolean isLeapYear) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Adjust for leap year
        if (isLeapYear) {
            daysInMonths[1] = 29; // February has 29 days in a leap year
        }

        // Calculate the day of the year
        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }
        dayOfYear += day;
        return dayOfYear;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Year
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        // Input: Month
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        // Input: Day
        System.out.print("Enter the day (1-31): ");
        int day = scanner.nextInt();

        // Determine if the year is a leap year
        boolean isLeapYear = isLeapYear(year);

        // Calculate the starting day of the year
        int startDayOfYearIndex = calculateStartDayOfYear(year);

        // Calculate day of the year and day of the week
        int dayOfYear = getDay(month, day, isLeapYear);
        String dayOfWeek = getDayOfWeek(dayOfYear, startDayOfYearIndex);

        // Output the results
        System.out.println("Day of the year: " + dayOfYear);
        System.out.println("Day of the week: " + dayOfWeek);

        scanner.close();
    }
}
