/*
 * Name: Kirtan Sukhadiya
 * Student ID: 1222983
 * Assignment Number: 3
 * Question Number: 2
 *
 * Description:
 * This Java program simulates a predator-prey ecosystem using a grid-based world.
 * The world consists of Ants (prey) and Doodlebugs (predators). Each organism
 * moves based on specific rules, breeds after a certain number of moves,
 * and doodlebugs starve if they do not eat within a certain timeframe.
 *
 * How to Run the Program:
 * 1. Compile the program using: javac Assignment3_Q2.java
 * 2. Run the program using: java Assignment3_Q2
 * 3. Enter the number of ants and doodlebugs when prompted.
 * 4. The simulation will display the grid. 'o' represents ants, 'X' represents doodlebugs, and '.' represents empty spaces.
 * 5. Press 'k' to continue the simulation or type 'exit' to quit.
 */

import java.util.Random;
import java.util.Scanner;

abstract class Organism {
    protected int x, y;
    protected int breedCounter;
    protected World world;

    public Organism(World world, int x, int y) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.breedCounter = 0;
    }

    public abstract void move();
    public abstract void breed();
}

class Ant extends Organism {
    public Ant(World world, int x, int y) {
        super(world, x, y);
    }

    @Override
    public void move() {
        world.moveOrganism(this);
    }

    @Override
    public void breed() {
        if (breedCounter >= 3) {
            world.breedOrganism(this);
            breedCounter = 0;
        }
    }
}

class Doodlebug extends Organism {
    private int starveCounter;

    public Doodlebug(World world, int x, int y) {
        super(world, x, y);
        this.starveCounter = 0;
    }

    @Override
    public void move() {
        boolean ate = world.moveDoodlebug(this);
        if (!ate) {
            starveCounter++;
            if (starveCounter >= 3) {
                world.removeOrganism(this);
            }
        } else {
            starveCounter = 0;
        }
    }

    @Override
    public void breed() {
        if (breedCounter >= 8) {
            world.breedOrganism(this);
            breedCounter = 0;
        }
    }
}

class World {
    private static final int SIZE = 20;
    private Organism[][] grid = new Organism[SIZE][SIZE];
    private Random rand = new Random();

    public void initialize(int numAnts, int numDoodlebugs) {
        for (int i = 0; i < numAnts; i++) {
            placeRandomly(new Ant(this, -1, -1));
        }
        for (int i = 0; i < numDoodlebugs; i++) {
            placeRandomly(new Doodlebug(this, -1, -1));
        }
    }

    private void placeRandomly(Organism org) {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (grid[x][y] != null);

        org.x = x;
        org.y = y;
        grid[x][y] = org;
    }

    public void moveOrganism(Organism org) {
        int[] directions = {-1, 1, 0, 0};
        int i = rand.nextInt(4);
        int newX = org.x + directions[i];
        int newY = org.y + directions[3 - i];

        if (isValidMove(newX, newY)) {
            grid[org.x][org.y] = null;
            org.x = newX;
            org.y = newY;
            grid[newX][newY] = org;
        }
        org.breedCounter++;
    }

    public boolean moveDoodlebug(Doodlebug db) {
        int[] directions = {-1, 1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int newX = db.x + directions[i];
            int newY = db.y + directions[3 - i];
            if (isValidMove(newX, newY) && grid[newX][newY] instanceof Ant) {
                grid[db.x][db.y] = null;
                db.x = newX;
                db.y = newY;
                grid[newX][newY] = db;
                db.breedCounter++;
                return true;
            }
        }
        moveOrganism(db);
        return false;
    }

    public void breedOrganism(Organism org) {
        int[] directions = {-1, 1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int newX = org.x + directions[i];
            int newY = org.y + directions[3 - i];
            if (isValidMove(newX, newY)) {
                if (org instanceof Ant) {
                    grid[newX][newY] = new Ant(this, newX, newY);
                } else if (org instanceof Doodlebug) {
                    grid[newX][newY] = new Doodlebug(this, newX, newY);
                }
                return;
            }
        }
    }

    public void removeOrganism(Organism org) {
        grid[org.x][org.y] = null;
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && grid[x][y] == null;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] instanceof Ant) {
                    System.out.print("o ");
                } else if (grid[i][j] instanceof Doodlebug) {
                    System.out.print("X ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void update() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] instanceof Doodlebug) {
                    grid[i][j].move();
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] instanceof Ant) {
                    grid[i][j].move();
                }
            }
        }
    }
}

public class Assignment3_Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of ants: ");
        int numAnts = scanner.nextInt();
        System.out.print("Enter number of doodlebugs: ");
        int numDoodlebugs = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline

        World world = new World();
        world.initialize(numAnts, numDoodlebugs);

        while (true) {
            world.display();
            System.out.println("Press 'k' to continue or type 'exit' to quit...");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Simulation ended.");
                break;
            }
            world.update();
        }
        scanner.close();
    }
}
