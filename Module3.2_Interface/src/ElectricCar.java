public class ElectricCar extends AbstractVehicle implements ElectricVehicle {
    private double energyConsumption;

    public ElectricCar(String name, double energyConsumption) {
        super(name);
        this.energyConsumption = energyConsumption;
    }

    @Override
    public void start() {
        System.out.println(getName() + " (Electric Car) is starting...");
    }

    @Override
    public void stop() {
        System.out.println(getName() + " (Electric Car) is stopping...");
    }

    @Override
    public String getInfo() {
        return "Electric Car Information:\nType: Electric Car\nName: " + getName();
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
