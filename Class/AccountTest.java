//class2

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Account myAccount = new Account(); //creating new object

        System.out.printf("Initial name is: %s%n", myAccount.getName()); //shows initial variable

        System.out.println("Please enter the name: ");
        String theName = input.nextLine(); //reads the input from user
        myAccount.setName(theName); //stores the input into object myAccount
        System.out.println();//prints out the black line

        System.out.printf("Name is Account is: %n%s%n", myAccount.getName()); //Displays content of object myAccount
    }

}

//setName and getName is defined in file Account.java