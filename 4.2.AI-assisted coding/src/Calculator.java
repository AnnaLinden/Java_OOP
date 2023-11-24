// Calculator class that has the ability to sum positive integers. 
// A negative integer should throw an exception.

public class Calculator {
    private int value;

    public Calculator() {
        value = 0;
    }

    // A method that resets the calculator to zero.
    public void clear() {
        value = 0;
    }

    // A method that adds an integer to the calculator.
    // A negative integer should throw an exception.
    public void add(int num) {
        try {
            if (num < 0) {
                throw new IllegalArgumentException("Negative integers are not allowed.");
            }
            value += num;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getCurrentValue() {
        return value;
    }

    // write a temporary main method that creates an instance of the Calculator
    // class and uses it to calculate the sum of a few integers.
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            calc.add(5);
            calc.add(10);
            calc.add(15);

            System.out.println("Current value: " + calc.getCurrentValue());
            calc.add(-20);
            System.out.println("After adding a negative integer, current value: " + calc.getCurrentValue());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
