import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a list of integers
        List<Integer> numbers = Arrays.asList(10, 5, 8, 20, 15, 3, 12);

        // Step 2: Filter even numbers
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> evenNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);

        // Step 3: Double the odd numbers
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        Function<Integer, Integer> doubleValue = n -> n * 2;
        List<Integer> doubledOddNumbers = numbers.stream().filter(isOdd).map(doubleValue).collect(Collectors.toList());
        System.out.println("Doubled Odd Numbers: " + doubledOddNumbers);

        // Step 4: Sum the numbers
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Numbers: " + sum);
    }
}
