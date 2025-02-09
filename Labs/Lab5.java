//Used Lab5 as name instead of Complex for better understanding of which labs work it is
public class Lab5  {
    private double realPart;
    private double imaginaryPart;

    // Constructor to initialize the real and imaginary parts
    public Lab5(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // Getter for real part
    public double getRealPart() {
        return realPart;
    }

    // Getter for imaginary part
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    // Method to add another complex number to the current one
    public void add(Lab5 c) {
        this.realPart += c.getRealPart();
        this.imaginaryPart += c.getImaginaryPart();
    }

    // Method to subtract another complex number from the current one
    public void subtract(Lab5 c) {
        this.realPart -= c.getRealPart();
        this.imaginaryPart -= c.getImaginaryPart();
    }

    // Method to print the complex number in the format (a, b)
    public void print() {
        System.out.println("(" + realPart + ", " + imaginaryPart + ")");
    }
}

// The provided UseComplex application
class UseComplex {
    public static void main(String[] args) {
        Lab5 c1 = new Lab5(2.0, 5.0); // 2.0 + 5.0i
        Lab5 c2 = new Lab5(-3.1, -6.3); // -3.1 - 6.3i

        c1.add(c2); // c1 is now -1.1 - 1.3i
        c1.print();

        c2.subtract(c1);
        c2.print();
    }
}
