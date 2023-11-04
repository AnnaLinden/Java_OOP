public class App {
    public static void main(String[] args) throws Exception {
        ServicePoint servicePoint = new ServicePoint();
        CustomerGenerator generator = new CustomerGenerator(servicePoint);
    }
}
