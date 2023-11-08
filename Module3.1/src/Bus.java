public class Bus extends Car {
    private int passengers;

    public Bus(String typeName) {
        super(typeName);
        this.passengers = 0;
    }

    public void passengerEnter(int count) {
        if (count < 0) {
            System.out.println("Cannot enter a negative number of passengers.");
        } else {
            passengers += count; // Add passengers
        }
    }

    public void passengerExit(int count) {
        if (count < 0) {
            System.out.println("Cannot exit a negative number of passengers.");
        } else if (count > passengers) {
            System.out.println("Cannot exit more passengers than are on the bus.");
        } else {
            passengers -= count; // Remove passengers
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public static void main(String[] args) {
        // Test entering passengers
        Bus bus = new Bus("Bus");
        bus.passengerEnter(5);
        System.out.println("Passengers after entering 5: " + (bus.getPassengers() == 5));

        // Test exiting passengers
        bus.passengerExit(3);
        System.out.println("Passengers after exiting 3: " + (bus.getPassengers() == 2));

        // Test exiting more passengers than are on the bus
        bus.passengerExit(5);
        System.out.println("Passengers after trying to exit 5: " + (bus.getPassengers() == 2));

        // Test entering a negative number of passengers
        bus.passengerEnter(-1);

        // Test exiting a negative number of passengers
        bus.passengerExit(-1);
    }
}
