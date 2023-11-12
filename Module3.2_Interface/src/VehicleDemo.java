public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle car = new Car();
        car.start();
        car.stop();
        System.out.println(car.getInfo() + "\n");

        Vehicle motorcycle = new Motorcycle();
        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo() + "\n");

        Vehicle bus = new Bus();
        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
    }
}
