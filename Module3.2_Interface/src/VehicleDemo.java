public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle car = new Car("My Car");
        car.start();
        car.stop();
        car.stop();
        System.out.println(car.getInfo() + "\n");

        Vehicle motorcycle = new Motorcycle("My Motorcycle", "Sports");
        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo() + "\n");

        Vehicle bus = new Bus("My Bus", 50);
        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
    }
}
