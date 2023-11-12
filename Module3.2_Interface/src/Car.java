public class Car extends AbstractVehicle {
    private double fuelEfficiency;

    public Car(String name, double fuelEfficiency) {
        super(name);
        this.fuelEfficiency = fuelEfficiency;
    }

    @Override
    public void start() {
        System.out.println(getName() + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(getName() + " is stopping...");
    }

    @Override
    public String getInfo() {
        return "Car Information:\nType: Car\nName: " + getName() + "\nFuel: Petrol\nColor: Red";
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}
