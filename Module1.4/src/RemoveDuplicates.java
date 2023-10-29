import java.util.Scanner;

/*
 * Task 3: Removing duplicates

Write a program that takes an array of integers as input from the user
 and removes all the duplicate numbers from it. The program should work as follows:

Ask the user for the size of the array.
Prompt the user to enter the integers into the array.
Remove all the duplicate numbers from the array using the following logic:
Create a new array that stores only one occurrence of each number.
Keep only the first occurrence of each number and discard any subsequent occurrences.
Print the resulting array without the duplicate numbers.
In this assignment, you can make the new array as big as the original array, even though it may not be completely filled.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Create a new array to store unique elements
        int[] uniqueArr = new int[size];
        int uniqueCount = 0;

        // Iterate through the original array and copy unique elements to the new array
        for (int i = 0; i < size; i++) {
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == uniqueArr[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueArr[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }

        System.out.println("The array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(uniqueArr[i] + " ");
        }
    }
}