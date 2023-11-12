public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle electricCar = new ElectricCar("Tesla Model S");
        electricCar.start();
        if (electricCar instanceof ElectricVehicle) {
            ((ElectricVehicle) electricCar).charge();
        }
        electricCar.stop();
        System.out.println(electricCar.getInfo() + "\n");

        Vehicle electricMotorcycle = new ElectricMotorcycle("Zero SR/F");
        electricMotorcycle.start();
        if (electricMotorcycle instanceof ElectricVehicle) {
            ((ElectricVehicle) electricMotorcycle).charge();
        }
        electricMotorcycle.stop();
        System.out.println(electricMotorcycle.getInfo() + "\n");

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
