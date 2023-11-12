public class ElectricMotorcycle extends AbstractVehicle implements ElectricVehicle {
    private double energyConsumption;

    public ElectricMotorcycle(String name, double energyConsumption) {
        super(name);
        this.energyConsumption = energyConsumption;
    }

    @Override
    public void start() {
        System.out.println(getName() + " (Electric Motorcycle) is starting...");
    }

    @Override
    public void stop() {
        System.out.println(getName() + " (Electric Motorcycle) is stopping...");
    }

    @Override
    public String getInfo() {
        return "Electric Motorcycle Information:\nType: Electric Motorcycle\nName: " + getName();
    }

    @Override
    public void charge() {
        System.out.println(getName() + " is charging...");
    }

    @Override
    public double calculateFuelEfficiency() {
        return energyConsumption;
    }
}
