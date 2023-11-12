public class Motorcycle extends AbstractVehicle {
    private String type;

    public Motorcycle(String name, String type) {
        super(name);
        this.type = type;
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
}
