/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 2
 * Question Number: 2
 *
 * Description:
 * This program implements a simple list-like data structure using a string to store items.
 * It provides methods to add, retrieve, delete, and manipulate items in the list.
 * The main method demonstrates its functionality with sample operations.
 *
 * How to run the program:
 * 1. Compile the Java file using: javac Assignment2_Q2.java
 * 2. Run the compiled class using: java Assignment2_Q2
 */

import java.util.Arrays;

public class Assignment2_Q2 {
    private String data;

    // Constructor initializes an empty list
    public Assignment2_Q2() {
        this.data = "";
    }

    // Add an item (convert object to string)
    public void addItem(Object o) {
        if (data.isEmpty()) {
            data = o.toString();
        } else {
            data += "," + o.toString();
        }
    }

    // Get an item at a specific position (zero-based index)
    public String getItem(int position) {
        String[] items = data.split(",");
        if (position >= 0 && position < items.length) {
            return items[position];
        }
        throw new IndexOutOfBoundsException("Invalid position: " + position);
    }

    // Delete an item at a specific position
    public void deleteItem(int position) {
        String[] items = data.split(",");
        if (position < 0 || position >= items.length) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        StringBuilder newData = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            if (i != position) {
                if (newData.length() > 0) newData.append(",");
                newData.append(items[i]);
            }
        }
        data = newData.toString();
    }

    // Delete an item by value
    public void deleteItem(String item) {
        String[] items = data.split(",");
        StringBuilder newData = new StringBuilder();
        boolean found = false;
        for (String s : items) {
            if (s.equals(item) && !found) {
                found = true; // Remove only the first occurrence
                continue;
            }
            if (newData.length() > 0) newData.append(",");
            newData.append(s);
        }
        data = newData.toString();
    }

    // Get the position of an item (zero-based index)
    public int getPosition(String item) {
        String[] items = data.split(",");
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1; // Item not found
    }

    // Get the first item (head)
    public String getHead() {
        String[] items = data.split(",");
        return items.length > 0 ? items[0] : null;
    }

    // Get all items except the first one (tail)
    public Assignment2_Q2 getTail() {
        String[] items = data.split(",");
        if (items.length <= 1) {
            return new Assignment2_Q2(); // Empty list
        }
        Assignment2_Q2 tail = new Assignment2_Q2();
        tail.data = String.join(",", Arrays.copyOfRange(items, 1, items.length));
        return tail;
    }

    // Get the number of items in the list
    public int length() {
        return data.isEmpty() ? 0 : data.split(",").length;
    }

    // Return the entire list as a string
    @Override
    public String toString() {
        return "[" + data + "]";
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Assignment2_Q2 myList = new Assignment2_Q2();
        myList.addItem("a");
        myList.addItem("b");
        myList.addItem("c");
        myList.addItem(12);
        myList.addItem("dog");

        System.out.println("List: " + myList);
        System.out.println("Item at position 2: " + myList.getItem(2));
        System.out.println("Position of 'b': " + myList.getPosition("b"));
        System.out.println("Head: " + myList.getHead());
        System.out.println("Tail: " + myList.getTail());
        System.out.println("Length: " + myList.length());

        myList.deleteItem(3);
        System.out.println("After deleting item at position 3: " + myList);

        myList.deleteItem("b");
        System.out.println("After deleting 'b': " + myList);
    }
}
