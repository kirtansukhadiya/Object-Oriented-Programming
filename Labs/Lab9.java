import java.util.Scanner;

// Abstract base class
abstract class DrawableShape {
    protected int centerX, centerY;
    protected String color;

    public DrawableShape(int centerX, int centerY, String color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public String getColor() {
        return color;
    }

    public void move(int deltaX, int deltaY) {
        this.centerX += deltaX;
        this.centerY += deltaY;
    }

    public abstract void draw();
}

// Concrete subclass
class Square extends DrawableShape {
    private int sideLength;

    public Square(int centerX, int centerY, String color, int sideLength) {
        super(centerX, centerY, color);
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square with color: " + color);
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
public class Lab9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter center X coordinate: ");
            int x = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter center Y coordinate: ");
            int y = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter color: ");
            String color = scanner.nextLine();

            System.out.print("Enter side length of square: ");
            int side = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Square square = new Square(x, y, color, side);
            square.draw();

            System.out.print("Move square by (deltaX deltaY): ");
            int deltaX = scanner.nextInt();
            int deltaY = scanner.nextInt();

            square.move(deltaX, deltaY);
            System.out.println("Square moved to new center: (" + square.getCenterX() + ", " + square.getCenterY() + ")");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter correct values.");
        } finally {
            scanner.close();
        }
    }
}
