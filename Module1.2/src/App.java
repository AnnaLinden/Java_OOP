
// import javax.swing.JOptionPane;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // convertFahrenheitToCelsius();
        // calculateHypotenuse();
        // convertGramsToMedievalUnits();
        convertFahrenheitToCelsiusScanner();
        calculateHypotenuseScanner();
        convertGramsToMedievalUnitsScanner();
    }

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
    static void convertFahrenheitToCelsiusScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf(fahrenheit + " Fahrenheit is %.1f Celsius.\n", celsius);
    }

    static void calculateHypotenuseScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of the first leg of the right triangle: ");
        double leg1 = scanner.nextDouble();
        System.out.print("Enter length of the second leg of the right triangle: ");
        double leg2 = scanner.nextDouble();
        double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
        System.out.println("The hypotenuse of the triangle is " + hypotenuse);
    }

    static void convertGramsToMedievalUnitsScanner() {
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
        scanner.close();
    }
}
