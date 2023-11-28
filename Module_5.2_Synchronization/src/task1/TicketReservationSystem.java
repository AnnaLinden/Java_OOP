package task1;

public class TicketReservationSystem {
    public static void main(String[] args) {
        Theater theater = new Theater(10);

        Thread customer1 = new Thread(new Customer(theater, "Customer 1", 2));
        Thread customer2 = new Thread(new Customer(theater, "Customer 2", 3));
        Thread customer3 = new Thread(new Customer(theater, "Customer 3", 4));
        Thread customer4 = new Thread(new Customer(theater, "Customer 4", 1));
        Thread customer5 = new Thread(new Customer(theater, "Customer 5", 2));

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();

        try {
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
            customer5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
