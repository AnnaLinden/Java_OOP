public class SportsCar extends Car {
    public SportsCar(String typeName) {
        super(typeName);
    }

    @Override
    public void accelerate() {
        if (getGasolineLevel() > 0) {
            setSpeed(getSpeed() + 20); // Sports cars accelerate faster
            setGasolineLevel(getGasolineLevel() - 5); // And consume more fuel
        } else {
            setSpeed(0);
        }
    }

    @Override
    void decelerate(int amount) {
        if (getGasolineLevel() > 0) {
            if (amount > 0)
                setSpeed(Math.max(0, getSpeed() - amount * 2)); // Decelerates faster
        } else {
            setSpeed(0);
        }
    }

}
