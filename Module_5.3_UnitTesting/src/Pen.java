public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    private Color inkColor;
    private boolean isCapOn;

    // Constructor with default color
    public Pen() {
        this.inkColor = Color.RED; // Default color
        this.isCapOn = true;
    }

    // Constructor with specified color
    public Pen(Color color) {
        this.inkColor = color;
        this.isCapOn = true;
    }

    // Method to draw
    public String draw() {
        if (isCapOn) {
            return "";
        } else {
            return "Drawing " + inkColor.toString();
        }
    }

    // Method to change color
    public void changeColor(Color newColor) {
        if (isCapOn) {
            this.inkColor = newColor;
        }
    }

    // Method to take the cap off
    public void capOff() {
        this.isCapOn = false;
    }

    // Method to put the cap on
    public void capOn() {
        this.isCapOn = true;
    }
}
