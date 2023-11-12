public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        Vehicle electricCar = new ElectricCar("Tesla Model S", 18.0);
        electricCar.start();
        if (electricCar instanceof ElectricVehicle) {
            ((ElectricVehicle) electricCar).charge();
        }
        electricCar.stop();
        System.out.println(electricCar.getInfo() + "\n");
        System.out.println("Energy Consumption: " + electricCar.calculateFuelEfficiency() + " kWh/100km\n");

        Vehicle electricMotorcycle = new ElectricMotorcycle("Zero SR/F", 16.0);
        electricMotorcycle.start();
        if (electricMotorcycle instanceof ElectricVehicle) {
            ((ElectricVehicle) electricMotorcycle).charge();
        }
        electricMotorcycle.stop();
        System.out.println(electricMotorcycle.getInfo() + "\n");
        System.out.println("Energy Consumption: " + electricMotorcycle.calculateFuelEfficiency() + " kWh/100km\n");

        Vehicle car = new Car("Ford Mustang", 15.0); // 15 km/l
        car.start();
        car.stop();
        System.out.println(car.getInfo());
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " km/l\n");

        Vehicle motorcycle = new Motorcycle("My Motorcycle", "Sports", 21.0);
        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo() + "\n");
        System.out.println("Fuel Efficiency: " + motorcycle.calculateFuelEfficiency() + " km/l\n");

        Vehicle bus = new Bus("City Bus", 40, 6.0); // 6 km/l
        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
        System.out.println("Fuel Efficiency: " + bus.calculateFuelEfficiency() + " km/l\n");

    }
}
