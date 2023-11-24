# Calculator Program

This is a simple Java program that implements a Calculator class capable of summing positive integers. If a negative integer is encountered, it will throw an exception. The Calculator class follows the Model in the Model-View-Controller (MVC) pattern and provides the following methods:

1. A method that resets the calculator to zero.
2. A method that adds an integer to the calculator.
3. A method that returns the current value of the calculator.

```java
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
```

The code above works by creating a class called Calculator. The class has a private integer variable called value. The class has a constructor that sets the value to 0. The class has a method called clear that sets the value to 0. The class has a method called add that adds an integer to the calculator. The method add throws an exception if the integer is negative. The class has a method called getCurrentValue that returns the value. The class has a main method that creates an instance of the Calculator class and uses it to calculate the sum of a few integers. The main method also catches any exceptions thrown by the add method.
