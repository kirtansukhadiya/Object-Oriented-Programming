/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 2
 * Question Number: 3
 *
 * Description:
 * This Java program defines a class `Assignment2_Q3` to represent a rectangle with a given center,
 * width, and height. It provides constructors, getters, setters, and methods to calculate the
 * area and perimeter. It also includes methods to check if a point or another rectangle is within
 * the current rectangle or if two rectangles overlap.
 *
 * How to Run:
 * 1. Compile the Java file using: javac Assignment2_Q3.java
 * 2. Run the compiled class using: java Assignment2_Q3
 * 3. The program will execute the `main` method and display the results in the console.
 */

public class Assignment2_Q3 {
    private double x, y; // Center of the rectangle
    private double width, height;

    // No-arg constructor
    public Assignment2_Q3() {
        this(0, 0, 1, 1);
    }

    // Constructor with parameters
    public Assignment2_Q3(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Getters and Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Method to calculate the area
    public double getArea() {
        return width * height;
    }

    // Method to calculate the perimeter
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Method to check if a point is inside the rectangle
    public boolean contains(double x, double y) {
        return (x >= this.x - width / 2 && x <= this.x + width / 2 &&
                y >= this.y - height / 2 && y <= this.y + height / 2);
    }

    // Method to check if a rectangle is fully inside this rectangle
    public boolean contains(Assignment2_Q3 r) {
        return (r.x - r.width / 2 >= this.x - this.width / 2 &&
                r.x + r.width / 2 <= this.x + this.width / 2 &&
                r.y - r.height / 2 >= this.y - this.height / 2 &&
                r.y + r.height / 2 <= this.y + this.height / 2);
    }

    // Method to check if a rectangle overlaps with this rectangle
    public boolean overlaps(Assignment2_Q3 r) {
        return !(r.x - r.width / 2 > this.x + this.width / 2 ||
                r.x + r.width / 2 < this.x - this.width / 2 ||
                r.y - r.height / 2 > this.y + this.height / 2 ||
                r.y + r.height / 2 < this.y - this.height / 2);
    }

    // Test Program
    public static void main(String[] args) {
        Assignment2_Q3 r1 = new Assignment2_Q3(2, 2, 5.5, 4.9);

        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        System.out.println("Contains point (3,3): " + r1.contains(3, 3));
        System.out.println("Contains rectangle (4,5,10.5,3.2): " + r1.contains(new Assignment2_Q3(4, 5, 10.5, 3.2)));
        System.out.println("Overlaps with rectangle (3,5,2.3,5.4): " + r1.overlaps(new Assignment2_Q3(3, 5, 2.3, 5.4)));
    }
}
