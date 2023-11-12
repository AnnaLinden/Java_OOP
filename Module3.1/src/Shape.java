public abstract class Shape {
    // Inside the Shape class, declare a method named calculateArea() that returns
    // the area of the shape. The method should return an area of 0.
    public abstract double calculateArea();
}

// Create three subclasses: Circle, Rectangle, and Triangle, each extending the
// Shape class.

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

class ShapeCalculator {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Triangle(3.0, 8.0);

        System.out.println("Shape Calculator\n");
        for (Shape shape : shapes) {
            // Check for the type of shape and print the dimensions accordingly
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println("Area of Circle with radius " + circle.getRadius() + ": " + circle.calculateArea());
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                System.out.println("Area of Rectangle with width " + rectangle.getWidth() + " and height "
                        + rectangle.getHeight() + ": " + rectangle.calculateArea());
            } else if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                System.out.println("Area of Triangle with base " + triangle.getBase() + " and height "
                        + triangle.getHeight() + ": " + triangle.calculateArea());
            }
        }
    }
}
