package view;

import controller.CurrencyConverterController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Currency;
import model.CurrencyConverter;

public class CurrencyConverterView extends Application {
    private CurrencyConverterController controller;
    private ComboBox<Currency> sourceCurrencyBox;
    private ComboBox<Currency> targetCurrencyBox;
    private TextField sourceAmount;
    private TextField targetAmount;
    private Button convertButton;

    @Override
    public void start(Stage primaryStage) {
        GridPane layout = new GridPane();
        layout.setVgap(10); // Vertical gap between rows
        layout.setHgap(10); // Horizontal gap between columns
        layout.setPadding(new Insets(10, 10, 10, 10)); // Padding around the grid

        sourceCurrencyBox = new ComboBox<>();
        targetCurrencyBox = new ComboBox<>();
        sourceAmount = new TextField();
        targetAmount = new TextField();
        convertButton = new Button("Convert");

        // Add components to the GridPane
        layout.add(new Label("Source Currency"), 0, 0);
        layout.add(sourceCurrencyBox, 1, 0);
        layout.add(new Label("Amount"), 2, 0);
        layout.add(sourceAmount, 3, 0);
        layout.add(new Label("Target Currency"), 0, 1);
        layout.add(targetCurrencyBox, 1, 1);
        layout.add(new Label("Converted Amount"), 2, 1);
        layout.add(targetAmount, 3, 1);
        layout.add(convertButton, 1, 4); // Spanning across 2 columns

        // Initialize controller
        this.controller = new CurrencyConverterController(this, new CurrencyConverter());

        // Populate ComboBoxes with currencies
        controller.initializeCurrencies();

        Scene scene = new Scene(layout, 600, 250);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Currency Converter");
        primaryStage.show();
    }

    public ComboBox<Currency> getSourceCurrencyBox() {
        return sourceCurrencyBox;
    }

    public ComboBox<Currency> getTargetCurrencyBox() {
        return targetCurrencyBox;
    }

    public TextField getSourceAmount() {
        return sourceAmount;
    }

    public TextField getTargetAmount() {
        return targetAmount;
    }

    public Button getConvertButton() {
        return convertButton;
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
