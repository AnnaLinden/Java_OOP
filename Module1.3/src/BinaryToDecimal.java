import java.util.Scanner;

// 11111 -> 31
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
                decimal += Math.pow(2, length - 1 - i);
            } else if (bit != '0') {
                System.out.println("Invalid binary input!");
                return;
            }
        }

        System.out.println("Decimal equivalent: " + decimal);
    }
}
