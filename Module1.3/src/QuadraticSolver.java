import java.util.Scanner;
//2,-8,-24; roots:6;-2

public class QuadraticSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficient a:");
        double a = scanner.nextDouble();

        System.out.println("Enter coefficient b:");
        double b = scanner.nextDouble();

        System.out.println("Enter coefficient c:");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

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
}
