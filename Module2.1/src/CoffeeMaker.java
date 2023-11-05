import java.util.Scanner;
/*
 * Task 3: Create CoffeeMaker class
 * A coffee maker has a selector for coffee type (normal/espresso) 
 * and a selector for coffee amount (10–80 ml). It also has 
 * an of/off switch that behaves in the same way as TV of/off switch. 
 * Coffee type and amount selectors behave like TV channel switch, 
 * i.e., they can only be changed when the device is on, 
 * and the device remembers the selections even when it is switched off.
 */

public class CoffeeMaker {
    private String coffeeType;
    private int coffeeAmount;
    private boolean isOn;

    public CoffeeMaker() {
        this.coffeeType = "normal";
        this.coffeeAmount = 10;
        this.isOn = false;
    }

    public void pressOnOff() {
        this.isOn = !this.isOn;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        if (isOn) {
            this.coffeeType = coffeeType;
        }
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public void setCoffeeAmount(int coffeeAmount) {
        if (isOn) {
            this.coffeeAmount = coffeeAmount;
        }
    }

    public boolean isOn() {
        return isOn;
    }

}

class CoffeMakerTest {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        System.out.println("Coffee maker is on: " + coffeeMaker.isOn());
        System.out.println("Do you want to start the coffee maker? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            coffeeMaker.pressOnOff();
            System.out.println("Coffee maker is on: " + coffeeMaker.isOn());
            System.out.println("Coffee type: " + coffeeMaker.getCoffeeType());
            System.out.println("Coffee amount: " + coffeeMaker.getCoffeeAmount());
            System.out.println("Do you want to change the coffee type? (y/n)");
            answer = scanner.nextLine();
            if (answer.equals("y")) {
                System.out.println("Enter the coffee type (normal/espresso): ");
                String coffeeType = scanner.nextLine();
                coffeeMaker.setCoffeeType(coffeeType);
                System.out.println("Coffee type: " + coffeeMaker.getCoffeeType());
            }
            System.out.println("Do you want to change the coffee amount? (y/n)");
            answer = scanner.nextLine();
            if (answer.equals("y")) {
                System.out.println("Enter the coffee amount (10-80): ");
                int coffeeAmount = scanner.nextInt();
                coffeeMaker.setCoffeeAmount(coffeeAmount);
                System.out.println("Coffee amount: " + coffeeMaker.getCoffeeAmount());
            }
        }

    }
}
