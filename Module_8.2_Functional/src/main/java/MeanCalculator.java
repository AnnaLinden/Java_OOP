import java.util.Arrays;
import java.util.OptionalDouble;

public class MeanCalculator {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        OptionalDouble mean = Arrays.stream(numbers).average();

        if (mean.isPresent()) {
            System.out.println("The mean is: " + mean.getAsDouble());
        } else {
            System.out.println("Array is empty.");
        }
    }
}
