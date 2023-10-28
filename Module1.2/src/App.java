
// import javax.swing.JOptionPane;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        int activity;

        do {
            System.out.println("Enter the number of activity you would like to run: 1-3. Or enter 0 to exit.");
            activity = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            switch (activity) {
                case 1:
                    convertFahrenheitToCelsius();
                    break;
                case 2:
                    calculateHypotenuse();
                    break;
                case 3:
                    convertGramsToMedievalUnits();
                    break;
                default:
                    if (activity != 0) {
                        System.out.println("Invalid input.");
                    }
                    break;
            }
        } while (activity != 0);
    }

    // Fahrenheit to Celsius Converter Write a program that prompts the user to
    // enter a temperature in Fahrenheit and converts it to Celsius. Display the
    // converted temperature on the console with one decimal place.

    static void convertFahrenheitToCelsius() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf(fahrenheit + " Fahrenheit is %.1f Celsius.\n", celsius);
    }

    // Write a program that asks the user for the lengths of the legs of a right
    // triangle and prints the length of the hypotenuse of the triangle.

    static void calculateHypotenuse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of the first leg of the right triangle: ");
        double leg1 = scanner.nextDouble();
        System.out.print("Enter length of the second leg of the right triangle: ");
        double leg2 = scanner.nextDouble();
        double hypotenuse = Math.sqrt((Math.pow(leg1, 2)) + (Math.pow(leg2, 2)));
        System.out.printf("The hypotenuse of the triangle is %.2f \n", hypotenuse);
    }

    /*
     * Leiviskä, naula and luoti are medieval Finnish units of measurement.
     * 
     * One leiviskä is 20 naula.
     * One naula is 32 luoti.
     * One luoti is 13.28 grams.
     * Write a program that asks the user for a weight in grams and converts it to
     * medieval measurements: leiviskä, naula, and luoti. The program should work in
     * the following way:
     * 
     * Weight (g): 30000
     * 30000 grams is 3 leiviskä, 10 naula, and 19.04 luoti.
     * That is, leiviskä and naula are printed as integers, and luoti is printed
     * with two decimal places.
     */

    static void convertGramsToMedievalUnits() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Weight (g): ");
        double weight = scanner.nextDouble();
        double originalWeight = weight; // Store the original weight

        int leiviska = (int) (weight / (20 * 32 * 13.28));
        weight -= leiviska * 20 * 32 * 13.28;

        int naula = (int) (weight / (32 * 13.28));
        weight -= naula * 32 * 13.28;

        double luoti = weight / 13.28;

        System.out.printf(originalWeight + " grams is %d leiviskä, %d naula, and %.2f luoti.\n", leiviska, naula,
                luoti);

        /*
         * static void convertFahrenheitToCelsius() {
         * String input =
         * JOptionPane.showInputDialog("Enter temperature in Fahrenheit:");
         * double fahrenheit = Double.parseDouble(input);
         * double celsius = (fahrenheit - 32) * 5 / 9;
         * JOptionPane.showMessageDialog(null,
         * fahrenheit + " Fahrenheit is " + String.format("%.1f", celsius) +
         * " Celsius.");
         * }
         * 
         * static void calculateHypotenuse() {
         * String leg1Input = JOptionPane.
         * showInputDialog("Enter length of the first leg of the right triangle:");
         * String leg2Input = JOptionPane.
         * showInputDialog("Enter length of the second leg of the right triangle:");
         * double leg1 = Double.parseDouble(leg1Input);
         * double leg2 = Double.parseDouble(leg2Input);
         * double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
         * JOptionPane.showMessageDialog(null, "The hypotenuse of the triangle is " +
         * hypotenuse);
         * }
         * 
         * static void convertGramsToMedievalUnits() {
         * String weightInput = JOptionPane.showInputDialog("Weight (g):");
         * double weight = Double.parseDouble(weightInput);
         * 
         * int leiviska = (int) (weight / (20 * 32 * 13.28));
         * weight -= leiviska * 20 * 32 * 13.28;
         * 
         * int naula = (int) (weight / (32 * 13.28));
         * weight -= naula * 32 * 13.28;
         * 
         * double luoti = weight / 13.28;
         * 
         * JOptionPane.showMessageDialog(null, weightInput + " grams is " + leiviska +
         * " leiviskä, " + naula
         * + " naula, and " + String.format("%.2f", luoti) + " luoti.");
         * }
         */
    }
}
