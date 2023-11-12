public class Motorcycle extends AbstractVehicle {
    private double fuelEfficiency;
    private String type;

    public Motorcycle(String name, String type, double fuelEfficiency) {
        super(name);
        this.type = type;
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
        return "Motorcycle Information:\nType: Motorcycle\nName: " + getName() + "\nModel: " + type;
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}
