public abstract class AbstractVehicle implements Vehicle {
    protected String name;

    public AbstractVehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
