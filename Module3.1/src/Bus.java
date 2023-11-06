public class Bus extends Car {
    private int passengers;

    public Bus(String typeName) {
        super(typeName);
        passengers = 0;
    }

    public void passengerEnter(int count) {
        passengers += count; // Add passengers
    }

    public void passengerExit(int count) {
        passengers = Math.max(0, passengers - count); // Remove passengers
    }

    public int getPassengers() {
        return passengers;
    }

}
