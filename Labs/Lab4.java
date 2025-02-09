public class Lab4 {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Lab4() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5.0;
        this.color = "blue";
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (on) {
            return "speed " + speed + "\ncolor " + color + "\nradius " + radius + "\nfan is on";
        } else {
            return "speed " + speed + "\ncolor " + color + "\nradius " + radius + "\nfan is off";
        }
    }

    public static void main(String[] args) {
        Lab4 fan1 = new Lab4();
        fan1.setSpeed(Lab4.FAST);
        fan1.setRadius(10.0);
        fan1.setColor("yellow");
        fan1.setOn(true);

        Lab4 fan2 = new Lab4();
        fan2.setSpeed(Lab4.MEDIUM);
        fan2.setRadius(5.0);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1 + "\n");
        System.out.println(fan2);
    }
}
