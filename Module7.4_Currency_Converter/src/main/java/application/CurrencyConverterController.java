package application;

import javafx.application.Application;
import entity.Currency;
import entity.CurrencyConverter;
import UI.CurrencyConverterView;
import dao.CurrencyDao;
import dao.CurrencyDao.CurrencyDaoException;
import dao.TransactionDao;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.logging.Logger;
import entity.Transaction;

import java.util.List;

public class CurrencyConverterController {
    private CurrencyConverterView view;
    private CurrencyConverter model;
    private CurrencyDao currencyDao;
    private static final Logger logger = Logger.getLogger(CurrencyConverterController.class.getName());

    public CurrencyConverterController(CurrencyConverterView view, CurrencyConverter model) {
        this.view = view;
        this.model = model;
        this.currencyDao = new CurrencyDao();

        initializeCurrencies();
        view.getConvertButton().setOnAction(event -> convertCurrency());
        view.getAddCurencyButton().setOnAction(event -> addNewCurrency());
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(view.getSourceAmount().getText());
            Currency fromCurrency = view.getSourceCurrencyBox().getValue();
            Currency toCurrency = view.getTargetCurrencyBox().getValue();

            double convertedAmount = model.convert(amount, fromCurrency, toCurrency);
            view.getTargetAmount().setText(String.format("%.2f", convertedAmount));

            Transaction transaction = new Transaction();
            transaction.setSourceCurrencyAbbreviation(fromCurrency.getAbbreviation());
            transaction.setTargetCurrencyAbbreviation(toCurrency.getAbbreviation());
            transaction.setAmount(amount);
            new TransactionDao().persist(transaction);
        } catch (NumberFormatException e) {
            view.showError("Invalid number format.");
        } catch (Exception e) {
            view.showError("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void initializeCurrencies() {
        try {
            List<Currency> currencies = currencyDao.getAllCurrencies();
            if (!currencies.isEmpty()) {
                view.getSourceCurrencyBox().getItems().addAll(currencies);
                view.getTargetCurrencyBox().getItems().addAll(currencies);
            } else {
                view.showError("No currencies available.");
            }
        } catch (CurrencyDaoException e) {
            view.showError("Unable to fetch currencies from the database: " + e.getMessage());
        }
    }

    private void addNewCurrency() {
        // Create a new Stage (window) for currency addition
        Stage newCurrencyStage = new Stage();
        newCurrencyStage.setTitle("Add New Currency");

        // Create layout and form elements (TextFields and Button)
        VBox layout = new VBox(10);
        TextField currencyCodeField = new TextField();
        currencyCodeField.setPromptText("Currency Abbreviation");
        TextField currencyNameField = new TextField();
        currencyNameField.setPromptText("Currency Name");
        TextField exchangeRateField = new TextField();
        exchangeRateField.setPromptText("Exchange Rate");

        Button submitButton = new Button("Add Currency");
        submitButton.setOnAction(event -> {
            try {
                // Parse input and create new Currency
                String code = currencyCodeField.getText();
                String name = currencyNameField.getText();
                double rate = Double.parseDouble(exchangeRateField.getText());

                Currency newCurrency = new Currency(name, code, rate);

                // Persist new currency using CurrencyDao
                currencyDao.persist(newCurrency);

                // Optionally, update UI and close the window
                view.addCurrencyToView(newCurrency);
                newCurrencyStage.close();
            } catch (NumberFormatException e) {
                view.showError("Invalid exchange rate format.");
            } catch (CurrencyDaoException e) {
                view.showError("Database error: " + e.getMessage());
            }
        });

        // Add elements to layout and set Scene
        layout.getChildren().addAll(currencyCodeField, currencyNameField, exchangeRateField, submitButton);
        Scene scene = new Scene(layout, 300, 200);
        newCurrencyStage.setScene(scene);
        newCurrencyStage.showAndWait(); // Show and wait for it to be closed
    }

    // Main method to launch the application
    public static void main(String[] args) {
        Application.launch(CurrencyConverterView.class, args);
    }
}
