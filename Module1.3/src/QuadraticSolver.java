import java.util.Scanner;
//2,-8,-24; roots:6;-2
//Task 1: Quadratic equation solver

// Write a program that prompts the user to enter the coefficients 
// of a quadratic equation (ax^2 + bx + c = 0) and calculates its roots 
// using the quadratic formula. Display the roots on the console. 
// If the equation has no real roots, display the message "No real roots".

public class QuadraticSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = getValidDouble(scanner, "Enter coefficient a:");
        double b = getValidDouble(scanner, "Enter coefficient b:");
        double c = getValidDouble(scanner, "Enter coefficient c:");

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Root is: " + root);
        } else {
            System.out.println("No real roots");
        }

    }

    private static double getValidDouble(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Try again.");
            scanner.next(); // clear invalid input
        }
        return scanner.nextDouble();
    }

}
