package view;

import controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PetView extends Application {
    private PetController controller;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(600, 600);
        controller = new PetController(this);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 600, 600);

        canvas.setOnMouseMoved(event -> controller.handleMouseMove(event.getX(), event.getY()));
        canvas.setOnMouseExited(event -> controller.handleMouseExit());
        canvas.setOnMouseEntered(event -> controller.handleMouseEnter());

        primaryStage.setTitle("Virtual Pet");
        primaryStage.setScene(scene);
        primaryStage.show();

        controller.initializePet();
        drawPet(300, 300);
    }

    public void drawPet(double x, double y) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image petImage = new Image(getClass().getResourceAsStream("/small_dog.png"));

        // Resize the image
        double newWidth = 100; //
        double newHeight = 100;

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.drawImage(petImage, x, y, newWidth, newHeight);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
