public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String name, int capacity) {
        super(name);
        this.capacity = capacity;
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
}
