package task1;

public class Customer implements Runnable {
    private Theater theater;
    private String name;
    private int seatsToReserve;

    public Customer(Theater theater, String name, int seatsToReserve) {
        this.theater = theater;
        this.name = name;
        this.seatsToReserve = seatsToReserve;
    }

    @Override
    public void run() {
        theater.reserveSeat(seatsToReserve, name);
    }

}
