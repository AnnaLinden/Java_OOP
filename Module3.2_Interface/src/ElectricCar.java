public class ElectricCar extends AbstractVehicle implements ElectricVehicle {
    public ElectricCar(String name) {
        super(name);
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
}
