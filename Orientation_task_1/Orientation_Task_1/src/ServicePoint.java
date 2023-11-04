import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue;
    private long totalServiceTime;
    private int customersServed;

    public ServicePoint() {
        queue = new LinkedList<>();
        totalServiceTime = 0;
        customersServed = 0;
    }

    public void addCustomer(Customer customer) {
        // long currentTime = System.currentTimeMillis();
        customer.setStartTime(System.currentTimeMillis());
        queue.addFirst(customer);
        System.out.println("Customer " + customer.getId() + " arrived at " + customer.getStartTime());

        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
    }

    private Customer removeFromQueue() {
        if (queue.size() > 0)
            return queue.removeLast();
        else
            return null;
    }

    public void serve() {
        Customer customer;

        customer = removeFromQueue();
        while (customer != null) {
            try {
                long serviceStartTime = System.currentTimeMillis();
                Thread.sleep(Math.round(Math.random() * 9000 + 1000));
                long serviceEndTime = System.currentTimeMillis();
                long serviceTime = serviceEndTime - serviceStartTime;

                customer.setEndTime(serviceEndTime);

                totalServiceTime += serviceTime;
                customersServed++;

                // customer served

                System.out.println("Customer " + customer.getId() + " left at " + customer.getEndTime()
                        + ", spending " + customer.duration() + " milliseconds.");

                customer = removeFromQueue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public double getAverageServiceTime() {
        if (customersServed == 0)
            return 0;
        else
            return (double) totalServiceTime / customersServed;
    }

}
