public class Bus implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return "Bus Information:\nType: Bus\nFuel: Diesel\nCapacity: 40 passengers";
    }
}
