/*
 * Task 2: Modified Car class

Modify Car class so that it has an additional constructor
 with gasoline tank capacity and top speed arguments.
 */

public class Car {
    private float speed;
    private float gasolineLevel;
    private float tankCapacity;
    private float topSpeed;
    private String typeName;

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
}

class CarTest {
    public static void main(String[] args) {

        // Test the new constructor with tank capacity and top speed
        Car myNewCar = new Car("NewCar", 50, 150);
        myNewCar.fillTank();
        System.out.println("New Car Tank after fill: " + myNewCar.getGasolineLevel());

        // Accelerate the car and check if it respects the top speed limit
        for (int i = 0; i < 20; i++) { // Accelerate 20 times
            myNewCar.accelerate();
            System.out.println("New Car Speed after accelerate: " + myNewCar.getSpeed());
        }
        System.out.println("New Car Speed after accelerate: " + myNewCar.getSpeed());

        // Test deceleration
        myNewCar.decelerate(30);
        System.out.println("New Car Speed after decelerate: " + myNewCar.getSpeed());

    }
}