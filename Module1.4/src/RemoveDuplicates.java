import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        System.out.println("The array without duplicates:");
        for (int i = 0; i < n; i++) {
            if (!set.contains(arr[i])) {
                System.out.print(arr[i] + " ");
                set.add(arr[i]);
            }
        }
    }
}
