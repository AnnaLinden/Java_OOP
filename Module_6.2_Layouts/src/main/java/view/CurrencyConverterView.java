package view;

import controller.CurrencyConverterController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
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

        VBox layout = new VBox(10);

        sourceCurrencyBox = new ComboBox<>();
        targetCurrencyBox = new ComboBox<>();
        sourceAmount = new TextField();
        targetAmount = new TextField();
        convertButton = new Button("Convert");

        layout.getChildren().addAll(
                new Label("Source Currency"), sourceCurrencyBox,
                new Label("Amount"), sourceAmount,
                new Label("Target Currency"), targetCurrencyBox,
                convertButton,
                new Label("Converted Amount"), targetAmount);

        // Initialize controller
        this.controller = new CurrencyConverterController(this, new CurrencyConverter());

        // populate ComboBoxes with currencies
        controller.initializeCurrencies();

        Scene scene = new Scene(layout, 400, 250);
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
