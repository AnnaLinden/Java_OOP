import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        // Task 1
        System.out.println("Task 1");
        GreetingTask.greetUser();
        printSeparator();

        // Task 2
        System.out.println("Task 2");
        PatternTask.printPattern();
        printSeparator();

        // Task 3
        System.out.println("Task 3");
        MathOperationsTask.performOperations();
        printSeparator();

        // // Task 4
        System.out.println("Task 4");
        CatTask.catActions();
        printSeparator();

    }

    static void printSeparator() {
        System.out.println("_".repeat(30));
    }

}

// Task 1
class GreetingTask {

    public static void greetUser() {
        System.out.println("Hello and welcome!");
    }
}

// Task 2
class PatternTask {
    static void printPattern() {
        // System.out.println(" *");
        // System.out.println(" ***");
        // System.out.println(" *****");
        // System.out.println(" *******");

        // Alternative solution
        System.out.println(" ".repeat(4) + "*");
        System.out.println(" ".repeat(3) + "*".repeat(3));
        System.out.println(" ".repeat(2) + "*".repeat(5));
        System.out.println(" ".repeat(1) + "*".repeat(7));
    }
}

// Task 3
class MathOperationsTask {
    static void performOperations() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        // Alternative solution
        // String input1 = JOptionPane.showInputDialog("Give the first number:");
        // int first = Integer.parseInt(input1);

        // String input2 = JOptionPane.showInputDialog("Give the second number:");
        // int second = Integer.parseInt(input2);

        // String input3 = JOptionPane.showInputDialog("Give the third number:");
        // int third = Integer.parseInt(input3);

        int sum = first + second + third;
        int product = first * second * third;
        double average = (double) sum / 3; // cast to double to get decimal result

        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);

        // Alternative output
        // String output = "The sum of the numbers is " + sum +
        // "\nThe product of the numbers is " + product +
        // "\nThe average of the numbers is " + average;

        // JOptionPane.showMessageDialog(null, output);

        scanner.close(); // close the scanner
    }
}

// Task 4
class CatTask {
    static void catActions() {
        Cat whiskers = new Cat("Whiskers");
        Cat rex = new Cat("Rex");

        whiskers.meow();
        whiskers.meow();
        rex.meow();
        whiskers.meow();
    }

    static class Cat {
        private String name;

        Cat(String name) {
            this.name = name;
        }

        void meow() {
            System.out.println("The cat named " + name + " says: Meow!");
        }
    }
}
