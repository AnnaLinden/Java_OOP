package Task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class FibonacciToCSV {

    public static void main(String[] args) {
        String filename = "fibonacci.csv";
        BigInteger[] fibonacciSequence = generateFibonacciSequence(100);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (BigInteger number : fibonacciSequence) {
                writer.write(number.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Fibonacci sequence written to " + filename);
    }

    private static BigInteger[] generateFibonacciSequence(int length) {
        BigInteger[] sequence = new BigInteger[length];
        sequence[0] = BigInteger.ZERO;
        sequence[1] = BigInteger.ONE;

        for (int i = 2; i < length; i++) {
            sequence[i] = sequence[i - 1].add(sequence[i - 2]);
        }

        return sequence;
    }
}