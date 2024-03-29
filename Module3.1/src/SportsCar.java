public class SportsCar extends Car {
    public SportsCar(String typeName) {
        super(typeName);
    }

    @Override
    public void accelerate() {
        if (getGasolineLevel() > 0) {
            setSpeed(getSpeed() + 20); // Sports cars accelerate faster
            setGasolineLevel(getGasolineLevel() - 5); // And consume more fuel
        } else {
            setSpeed(0);
        }
    }

    @Override
    void decelerate(int amount) {
        if (getGasolineLevel() > 0) {
            if (amount > 0)
                setSpeed(Math.max(0, getSpeed() - amount * 2)); // Decelerates faster
        } else {
            setSpeed(0);
        }
    }

}

class SportsCarTest {

    public static void shouldAccelerateFasterThanCar() {
        Car normalCar = new Car("Car");
        SportsCar sportsCar = new SportsCar("SportsCar");

        normalCar.fillTank();
        sportsCar.fillTank();

        normalCar.accelerate();
        sportsCar.accelerate();

        System.out.println("Test Acceleration: " + (sportsCar.getSpeed() > normalCar.getSpeed()));
    }

    public static void shouldConsumeMoreGasolineOnAcceleration() {
        SportsCar sportsCar = new SportsCar("SportsCar");
        sportsCar.fillTank();
        double beforeAcceleration = sportsCar.getGasolineLevel();

        sportsCar.accelerate();

        System.out.println("Test Gasoline Consumption: " +
                (Math.abs(beforeAcceleration - 5 - sportsCar.getGasolineLevel()) < 0.01));
    }

    public static void shouldDecelerateFasterThanCar() {
        Car normalCar = new Car("Car");
        SportsCar sportsCar = new SportsCar("SportsCar");

        normalCar.fillTank();
        sportsCar.fillTank();

        normalCar.setSpeed(100); //
        sportsCar.setSpeed(100);

        normalCar.decelerate(5); //
        sportsCar.decelerate(5); //

        System.out.println("Test Deceleration: " + (sportsCar.getSpeed() < normalCar.getSpeed()));
    }

    public static void shouldNotDecelerateBelowZero() {
        SportsCar sportsCar = new SportsCar("SportsCar");
        sportsCar.fillTank();
        sportsCar.setSpeed(10); //

        sportsCar.decelerate(10); //

        System.out.println("Test Deceleration Below Zero: " + (sportsCar.getSpeed() == 0));
    }

    public static void main(String[] args) {
        shouldAccelerateFasterThanCar();
        shouldConsumeMoreGasolineOnAcceleration();
        shouldDecelerateFasterThanCar();
        shouldNotDecelerateBelowZero();
    }
}
