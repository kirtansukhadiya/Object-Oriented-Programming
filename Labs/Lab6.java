import java.util.ArrayList;

class PhoneBookEntry {
    private String name;
    private String phoneNumber;

    // Constructor
    public PhoneBookEntry(String name, String phoneNumber) {
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

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}
public class Lab6 {
    public static void main(String[] args) {
        ArrayList<PhoneBookEntry> phoneBook = new ArrayList<>();

        // Adding at least 5 entries
        phoneBook.add(new PhoneBookEntry("Alice Johnson", "123-456-7890"));
        phoneBook.add(new PhoneBookEntry("Bob Smith", "234-567-8901"));
        phoneBook.add(new PhoneBookEntry("Charlie Brown", "345-678-9012"));
        phoneBook.add(new PhoneBookEntry("Diana Prince", "456-789-0123"));
        phoneBook.add(new PhoneBookEntry("Ethan Hunt", "567-890-1234"));

        // Display the contents using a loop
        for (PhoneBookEntry entry : phoneBook) {
            System.out.println(entry);
        }
    }
}
