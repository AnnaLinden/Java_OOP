import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Name Generator");
            System.out.println("2. Max subarray sum");
            System.out.println("3. Remove duplicates");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    NameGenerator.main(args);
                    printSeparator();
                    break;
                case 2:
                    MaxSubarraySum.main(args);
                    printSeparator();
                    break;
                case 3:
                    RemoveDuplicates.main(args);
                    System.out.println("\n");
                    printSeparator();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }
    }

    static void printSeparator() {
        System.out.println("_".repeat(50));
    }
}
