import java.util.Scanner;
//import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a scanner object

        while (true) { // keep running until the user decides to exit
            System.out.println("Which activity would you like to run? (1-4) Or enter 0 to exit.");
            int activity = Integer.parseInt(scanner.nextLine()); // read user input

            if (activity == 0) { // exit condition
                System.out.println("Exiting program...");
                break; // exit the loop
            }

            switch (activity) {
                case 1:
                    Greeting.greetUser();
                    printSeparator();
                    break;
                case 2:
                    PatternTask.printPattern();
                    printSeparator();
                    break;
                case 3:
                    MathOperationsTask.performOperations();
                    printSeparator();
                    break;
                case 4:
                    CatTask.catActions();
                    printSeparator();
                    break;
                default:
                    System.out.println("Invalid activity number!");
                    break;
            }
        }

    }

    static void printSeparator() {
        System.out.println("_".repeat(30));
    }

}

// Task 1
// Install the environment, create a new project, and write a simple program
// that greets the user with a fixed message. Run the program and make sure that
// it works. Commit your changes to GitHub.
class Greeting {

    public static void greetUser() {
        System.out.println("Hello and welcome!");
    }
}

// Task 2
class PatternTask {
    public static void printPattern() {
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
// ask the user three integers and print their sum.
// modify the program so that the program also prints the product and average of
// the three integers. Hint: try the modified program with integers 3, 4, and 6.
// The sum should be 13, the product 72, and the average 4.3333333333333. If the
// average is something else, find out why and modify the program accordingly.
// Add the explanation as a comment to the program. Commit your changes to
// GitHub.
class MathOperationsTask { // Define a class named MathOperationsTask
    public static void performOperations() { // Define a method named performOperations
        Scanner scanner = new Scanner(System.in); // create a scanner object

        // prompt the user for three integers and convert the input to integer
        // scanner: This is an instance of the Scanner class, which is used to read user
        // input from the console in Java.
        // nextLine(): This method reads the input provided by the user as a string.
        // parseInt(): This method converts the string input to an integer.
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

        // calculate the sum, product and average
        int sum = first + second + third;
        int product = first * second * third;
        double average = (double) sum / 3; // cast to double to get decimal result

        // print the results
        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The product of the numbers is " + product);
        System.out.println("The average of the numbers is " + average);

        // Alternative output
        // String output = "The sum of the numbers is " + sum +
        // "\nThe product of the numbers is " + product +
        // "\nThe average of the numbers is " + average;

        // JOptionPane.showMessageDialog(null, output);

    }
}

// Task 4
class CatTask {
    public static void catActions() {
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
