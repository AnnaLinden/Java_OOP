import java.util.Random;
import java.util.Scanner;

/*
Task 1: A name generator

Write a program that generates random names by combining first and last names 
from hard-coded name arrays. The program should work as follows:

Create two arrays, firstNames and lastNames, which contain first and last names.

Ask the user how many random names the program should generate.

Generate random names using the following logic:

Choose the index value for the first name randomly.
Choose the index value for the last name randomly.
Use the index values to create a random full name (i.e. first name and last name).
Print the generated full name.
Repeat these steps as many times as the user-specified number of names to generate. 
*/

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
