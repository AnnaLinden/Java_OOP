public class CustomerGenerator {
    private ServicePoint servicePoint;

    // Constructor that takes a ServicePoint as an argument
    public CustomerGenerator(ServicePoint servicePoint) {
        this.servicePoint = servicePoint;
        for (int i = 0; i < 10; i++) {
            this.servicePoint.addCustomer(new Customer());
        }
    }

}
