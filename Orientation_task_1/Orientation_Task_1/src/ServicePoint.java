import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue;

    public ServicePoint() {
        queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.addFirst(customer);
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
                Thread.sleep(Math.round(Math.random() * 9000 + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // customer served

            customer = removeFromQueue();
        }

    }

}
