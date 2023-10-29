import java.util.Scanner;

/*
 * Task 2: Finding the maximum subarray sum

Write a program that takes an array of integers as input from 
the user and finds the subarray with the maximum sum. A subarray
is a portion of an array, which consists of contiguous elements 
from the original array in the same order. The program should work as follows:

Ask the user for the number of integers in the array.
Prompt the user to enter the integers into the array.
Find the subarray with the maximum sum using the following logic:
Iterate through all possible subarrays in the array.
Calculate the sum of each subarray.
Keep track of the maximum sum found and the corresponding subarray indices.
Print the maximum sum and the corresponding indices. (Use the indices shown to the user, i.e., starting from 1.)
 */

public class MaxSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for (int i = 0; i < size; i++) {
            int currentSum = 0;
            for (int j = i; j < size; j++) {
                currentSum += arr[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Integers: " + (start + 1) + "-" + (end + 1));
    }
}
