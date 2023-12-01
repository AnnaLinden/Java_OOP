package model;

public class Pet {
    private double x, y; // Pet's current position
    private double speed; // Speed of the pet

    public Pet(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // Getters, setters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
