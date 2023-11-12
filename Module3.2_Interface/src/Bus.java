public class Bus extends AbstractVehicle {
    private int capacity;
    private double fuelEfficiency;

    public Bus(String name, int capacity, double fuelEfficiency) {
        super(name);
        this.capacity = capacity;
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
        return "Bus Information:\nType: Bus\nName: " + getName() + "\nFuel: Diesel\nCapacity: " + capacity
                + " passengers";
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}
