public class Car extends AbstractVehicle {

    public Car(String name) {
        super(name);
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
}
