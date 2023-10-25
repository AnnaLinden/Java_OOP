import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        String[] firstNames = { "Juhani", "Olavi", "Kaarina", "Eeva", "Mikko", "Liisa" };
        String[] lastNames = { "Korhonen", "Virtanen", "Mäkinen", "Nieminen", "Heikkinen", "Salminen" };

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many random names should the program generate? ");
        int numNames = scanner.nextInt();

        Random random = new Random();
        for (int i = 0; i < numNames; i++) {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            System.out.println(firstName + " " + lastName);
        }
    }
}
