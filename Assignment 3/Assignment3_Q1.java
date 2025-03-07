/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment: 3
 * Question: 1
 *
 * Description:
 * This Java program defines a base class `Document` with subclasses `Email` and `File`.
 * It allows users to input details for an email and a file, then checks if a given keyword
 * is present in either. The `ContainsKeyword` method determines this by searching the string
 * representation of the document objects.
 *
 * How to Run:
 * 1. Compile the program using `javac Assignment3_Q1.java`.
 * 2. Run the program using `java Assignment3_Q1`.
 * 3. Follow the prompts to enter email and file details.
 * 4. Input keywords to search within the email and file content.
 */

import java.util.Scanner;

class Document {
    protected String text;

    public Document() {
        this.text = "";
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}

class Email extends Document {
    private String sender;
    private String recipient;
    private String title;

    public Email(String sender, String recipient, String title, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.text = text;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Sender: " + sender + "\nRecipient: " + recipient + "\nTitle: " + title + "\nBody: " + text;
    }
}

class File extends Document {
    private String pathname;

    public File(String pathname, String text) {
        this.pathname = pathname;
        this.text = text;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public String getPathname() {
        return pathname;
    }

    @Override
    public String toString() {
        return "Pathname: " + pathname + "\nContent: " + text;
    }
}
public class Assignment3_Q1 {
    public static boolean ContainsKeyword(Document docObject, String keyword) {
        return docObject.toString().contains(keyword);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sender email:");
        String sender = scanner.nextLine();
        System.out.println("Enter recipient email:");
        String recipient = scanner.nextLine();
        System.out.println("Enter email title:");
        String title = scanner.nextLine();
        System.out.println("Enter email body:");
        String emailBody = scanner.nextLine();
        Email email1 = new Email(sender, recipient, title, emailBody);

        System.out.println("Enter file pathname:");
        String pathname = scanner.nextLine();
        System.out.println("Enter file content:");
        String fileContent = scanner.nextLine();
        File file1 = new File(pathname, fileContent);

        System.out.println("\nTesting Email Object:\n" + email1);
        System.out.println("Enter keyword to search in email:");
        String keywordEmail = scanner.nextLine();
        System.out.println("Contains '" + keywordEmail + "' in email: " + ContainsKeyword(email1, keywordEmail));

        System.out.println("\nTesting File Object:\n" + file1);
        System.out.println("Enter keyword to search in file:");
        String keywordFile = scanner.nextLine();
        System.out.println("Contains '" + keywordFile + "' in file: " + ContainsKeyword(file1, keywordFile));

        scanner.close();
    }
}
