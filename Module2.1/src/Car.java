import java.util.Scanner;
/*
 * Task 2: Modified Car class

Modify Car class so that it has an additional constructor
 with gasoline tank capacity and top speed arguments.
 */

/*Task 4: Cruise control
Add to Car class a cruise control feature. With cruise control feature,
 the driver can set the target speed, read the current target speed, 
 and turn cruise control on or off. For cruise control, there is 
 a minimum and maximum speed that can be set. After target speed 
 has been set and cruise control turned on, the car should accelerate 
 or decelerate to reach the target speed. If reaching the target speed 
 is not possible, cruise control must be turned off, and the driver be 
 informed about this (perhaps the returning value of turnOn method could 
 be used for this). Modify CarDriver class to test your cruise control. 
 Do this before you implement cruise control in Car class. 
 Why to modify CarDriver first? 
 */

public class Car {
    private float speed;
    private float gasolineLevel;
    private float tankCapacity;
    private float topSpeed;
    private String typeName;
    private boolean cruiseControlOn;
    private float cruiseControlSpeed;
    public final float MIN_CRUISE_CONTROL_SPEED = 30;
    public final float MAX_CRUISE_CONTROL_SPEED = 120;

    // Existing constructor
    public Car(String typeName) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.typeName = typeName;
    }

    // New constructor with gasoline tank capacity and top speed
    public Car(String typeName, float tankCapacity, float topSpeed) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.tankCapacity = tankCapacity;
        this.topSpeed = topSpeed;
        this.typeName = typeName;
    }

    // Existing methods
    public void accelerate() {
        if (gasolineLevel > 0 && speed < topSpeed) { // Check added for top speed
            speed = Math.min(speed + 10, topSpeed); // Accelerate only up to the top speed
        } else if (gasolineLevel > 0) {
            speed = topSpeed; // If the car is already at top speed, keep it there ;
        } else {
            speed = 0;
        }
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0 && amount > 0) {
            speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
        }
    }

    public float getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = tankCapacity; // Use tank capacity when filling the tank
    }

    public float getGasolineLevel() {
        return gasolineLevel;
    }

    // New methods for accessing the new instance variables
    public float getTankCapacity() {
        return tankCapacity;
    }

    public float getTopSpeed() {
        return topSpeed;
    }

    // Method to get cruise control status - acts as a "getter"
    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlTargetSpeed(float targetSpeed) {
        if (targetSpeed >= MIN_CRUISE_CONTROL_SPEED && targetSpeed <= MAX_CRUISE_CONTROL_SPEED) {
            cruiseControlSpeed = targetSpeed;
        } else {
            cruiseControlSpeed = 0; // Invalid speed, cruise control can't be activated
        }
    }

    public float getCruiseControlSpeed() {
        return cruiseControlSpeed;
    }

    public boolean turnCruiseControlOn() {
        if (cruiseControlSpeed >= MIN_CRUISE_CONTROL_SPEED && cruiseControlSpeed <= MAX_CRUISE_CONTROL_SPEED) {
            cruiseControlOn = true;
            return true; // Successfully turned on cruise control
        }
        return false; // Failed to activate cruise control due to invalid speed
    }

    public void turnCruiseControlOff() {
        cruiseControlOn = false;
    }

    public void maintainCruiseControlSpeed() {
        if (cruiseControlOn) {
            if (speed < cruiseControlSpeed) {
                accelerate();
            } else if (speed > cruiseControlSpeed) {
                decelerate(10);
            }
        }
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void decelerateToZero() {
        // Assuming there's a setSpeed method to update the car's speed
        this.setSpeed(0);
    }
}

class CarDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the car with a tank capacity and top speed
        Car myCar = new Car("NewCar", 50, 150);
        System.out.println("New Car Tank: " + myCar.getGasolineLevel() + " / " + myCar.getTankCapacity() +
                ", Top Speed: " + myCar.getTopSpeed());

        // Fill the car's tank
        myCar.fillTank();
        System.out.println("New Car Tank after fill: " + myCar.getGasolineLevel());

        boolean exit = false;
        while (!exit) {
            if (!myCar.isCruiseControlOn()) {
                System.out.println(
                        "If you want to accelerate press 'a', to set cruise control speed press 'c', to stop press 'b', to decelerate press 'd', to exit press 'q': ");
                String input = scanner.nextLine().toLowerCase();

                switch (input) {
                    case "a": // Accelerate
                        myCar.accelerate();
                        break;
                    case "c": // Set Cruise Control Speed
                        System.out.println("Enter the target speed for cruise control: ");
                        float targetSpeed = scanner.nextFloat();
                        scanner.nextLine(); // Consume the newline

                        if (targetSpeed < myCar.MIN_CRUISE_CONTROL_SPEED
                                || targetSpeed > myCar.MAX_CRUISE_CONTROL_SPEED) {
                            System.out.println("Invalid speed. Cruise control can only be set between " +
                                    myCar.MIN_CRUISE_CONTROL_SPEED + " and " + myCar.MAX_CRUISE_CONTROL_SPEED
                                    + " km/h.");
                        } else {
                            myCar.setCruiseControlTargetSpeed(targetSpeed);
                            if (myCar.turnCruiseControlOn()) {
                                System.out.println("Cruise control activated at " + targetSpeed + " km/h");
                            } else {
                                System.out.println("Cruise control failed to activate.");
                            }
                        }
                        break;
                    case "b": // Stop
                        myCar.decelerateToZero();
                        break;
                    case "d": // Decelerate
                        myCar.decelerate(15);
                        break;
                    case "q": // Quit
                        exit = true;
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid input. Try again.");
                }
            } else {
                System.out.println(
                        "Cruise control is on. Press 'o' to switch off, 'b' to brake, or 'Enter' to continue: ");
                String input = scanner.nextLine().toLowerCase();

                if (input.equals("o")) {
                    myCar.turnCruiseControlOff();
                    System.out.println("Cruise control deactivated.");
                } else if (input.equals("b")) {
                    myCar.turnCruiseControlOff();
                    myCar.decelerateToZero(); // Implement this method in the Car class.
                    System.out.println("Braking: Cruise control deactivated and speed reduced to 0 km/h.");
                } else {
                    // If the user does not switch off cruise control or press brake, maintain it
                    myCar.maintainCruiseControlSpeed();
                }
            }
            if (!exit) {
                System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
            }
        }

        scanner.close();
    }
}