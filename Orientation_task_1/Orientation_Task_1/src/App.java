public class App {
    public static void main(String[] args) throws Exception {
        ServicePoint servicePoint = new ServicePoint();
        CustomerGenerator generator = new CustomerGenerator(servicePoint);

        // Simulate serving customers
        servicePoint.serve();

        // Calculate and print the average service time
        double averageServiceTime = servicePoint.getAverageServiceTime();
        System.out.println("Average Service Time: " + averageServiceTime + " miliseconds");
    }
}
