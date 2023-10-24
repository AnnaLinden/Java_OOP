import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Quadratic equation solver");
            System.out.println("2: Binary values");
            System.out.println("3: Prime number generator");
            System.out.println("4: Multiplication table exam");
            System.out.println("5: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    QuadraticSolver.main(args);
                    break;
                case 2:
                    BinaryToDecimal.main(args);
                    break;
                case 3:
                    PrimeGenerator.main(args);
                    break;
                case 4:
                    MultiplicationExam.main(args);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
