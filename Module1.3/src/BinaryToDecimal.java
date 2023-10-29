import java.util.Scanner;

// 11111 -> 31
// Write a program that prompts the user to enter a binary number 
// (composed of 0s and 1s) and converts it to decimal. Display the decimal 
// equivalent on the console. Hint: use the charAt method of the String class
// to retrieve the individual bits in the input string.

public class BinaryToDecimal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a binary number:");
        String binary = scanner.nextLine();

        // Option 1: Use built-in method
        // int decimal = Integer.parseInt(binary, 2);

        // Option 2: Manually convert
        int decimal = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {
            char bit = binary.charAt(i);
            if (bit == '1') {
                decimal += Math.pow(2, length - 1 - i); //
            } else if (bit != '0') {
                System.out.println("Invalid binary input!");
                return;
            }
        }

        System.out.println("Decimal equivalent: " + decimal);
    }
}
