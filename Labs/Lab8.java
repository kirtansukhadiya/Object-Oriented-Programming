//Changed the name of the class to Lab8 from LargeList to make classification of lab in my laptop easier. It contains the same class definition
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Lab8 {
    private int[] pos;

    public Lab8(int number) {
        Random rand = new Random();
        pos = new int[number];
        if (number > 0) {
            pos[0] = rand.nextInt(10) + 1;
            for (int i = 1; i < number; i++) {
                pos[i] = pos[i - 1] + (rand.nextInt(10) + 1);
            }
        }
    }

    public Lab8(Lab8 other) {
        this.pos = Arrays.copyOf(other.pos, other.pos.length);
    }

    public int gatValue(int target) {
        for (int value : pos) {
            if (value == target) {
                return 1;
            }
        }
        return 0;
    }

    public void reset(int[] newPos) {
        this.pos = Arrays.copyOf(newPos, newPos.length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lab8 other = (Lab8) obj;
        return Arrays.equals(this.pos, other.pos);
    }

    public void printList() {
        System.out.println(Arrays.toString(pos));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements for List 1: ");
        int size1 = scanner.nextInt();
        int[] elements1 = new int[size1];
        System.out.println("Enter " + size1 + " elements for List 1:");
        for (int i = 0; i < size1; i++) {
            elements1[i] = scanner.nextInt();
        }
        Lab8 list1 = new Lab8(size1);
        list1.reset(elements1);
        System.out.print("List 1: ");
        list1.printList();

        System.out.print("Enter the number of elements for List 2: ");
        int size2 = scanner.nextInt();
        int[] elements2 = new int[size2];
        System.out.println("Enter " + size2 + " elements for List 2:");
        for (int i = 0; i < size2; i++) {
            elements2[i] = scanner.nextInt();
        }
        Lab8 list2 = new Lab8(size2);
        list2.reset(elements2);
        System.out.print("List 2: ");
        list2.printList();

        System.out.println("List 1 equals List 2? " + list1.equals(list2));

        Lab8 copyList = new Lab8(list1);
        System.out.print("Copy of List 1: ");
        copyList.printList();
        System.out.println("Copy equals List 1? " + copyList.equals(list1));

        System.out.print("Enter the number of elements for Modified Copy: ");
        int sizeCopy = scanner.nextInt();
        int[] elementsCopy = new int[sizeCopy];
        System.out.println("Enter " + sizeCopy + " elements for Modified Copy:");
        for (int i = 0; i < sizeCopy; i++) {
            elementsCopy[i] = scanner.nextInt();
        }
        copyList.reset(elementsCopy);
        System.out.print("Modified Copy: ");
        copyList.printList();
        System.out.println("Copy still equals List 1? " + copyList.equals(list1));

        scanner.close();
    }
}
