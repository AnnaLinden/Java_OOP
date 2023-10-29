import java.util.Scanner;

// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
// Write a program that prompts the user to enter two positive integers, start and end (where start < end). The program should generate and display all the prime numbers between start and end, inclusive.

A prime number is a positive integer greater than 1 that has no positive divisors other than 1 and itself.

Your program should use control structures(such as loops and conditional statements)to implement the logic for generating and checking prime numbers.

public class PrimeGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter start:");
        int start = scanner.nextInt();

        System.out.println("Enter end:");
        int end = scanner.nextInt();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
