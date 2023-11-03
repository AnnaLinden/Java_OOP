/*
/*
 * (P) Write the Customer class. The customer has an id (int), a start time (long),
 * an end time (long), methods to handle them (getters and setters), and a method 
 * to find out the time spent (end time-start time).
 * Write a test program to test the operation of the method. The id of the first customer = 1.
 *  When a new customer is created, it will have an id one larger to the previous customer.
 * 
 * For this task, you can use the integers you specify, or the values given by the 
 * System.currentTimeMillis() or System.nanotime() methods as time stamps (start time/stop time).
 */
public class Customer {

    private int id;
    private long startTime;
    private long endTime;
    private static int NEXT_ID = 0;

    public Customer() {
        this.id = ++NEXT_ID;
        this.startTime = 0;
        this.endTime = 0;
    }

    // Getters and setters
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    // Calculate duration
    public long duration() {
        return endTime - startTime;
    }

    // Override toString() for better customer information representation
    @Override
    public String toString() {
        return "Customer " + id + " arrived at " + startTime + " and left at " + endTime + ", spending " + duration()
                + " milliseconds.";
    }

    // Test program
    public static void main(String[] args) {
        System.out.println("Customer class tester");

        // Instantiate and test customer instances
        Customer customer1 = new Customer();
        customer1.setStartTime(System.currentTimeMillis());

        // Simulate time passing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle thread interruption properly
            return;
        }

        customer1.setEndTime(System.currentTimeMillis());
        System.out.println(customer1);

        // Further tests could be added here
    }
}