package controller;

import javafx.application.Application;
import model.Currency;
import model.CurrencyConverter;
import view.CurrencyConverterView;

public class CurrencyConverterController {
    private CurrencyConverterView view;
    private CurrencyConverter model;

    public CurrencyConverterController(CurrencyConverterView view, CurrencyConverter model) {
        this.view = view;
        this.model = model;

        initializeCurrencies();
        // Setup event handlers
        view.getConvertButton().setOnAction(event -> convertCurrency());
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(view.getSourceAmount().getText());
            Currency fromCurrency = view.getSourceCurrencyBox().getValue();
            Currency toCurrency = view.getTargetCurrencyBox().getValue();

            double convertedAmount = model.convert(amount, fromCurrency, toCurrency);
            view.getTargetAmount().setText(String.format("%.2f", convertedAmount));
        } catch (NumberFormatException e) {
            // Handle invalid number format
            view.showError("Invalid number format.");
        } catch (Exception e) {
            // Handle other exceptions
            view.showError("An error occurred: " + e.getMessage());
        }
    }

    public void initializeCurrencies() {
        Currency usd = new Currency("US Dollar", "USD", 1.0);
        Currency eur = new Currency("Euro", "EUR", 1.12); // Example rate
        Currency gbp = new Currency("British Pound", "GBP", 1.30); // Example rate

        view.getSourceCurrencyBox().getItems().addAll(usd, eur, gbp);
        view.getTargetCurrencyBox().getItems().addAll(usd, eur, gbp);
    }

    // Main method to launch the application
    public static void main(String[] args) {
        Application.launch(CurrencyConverterView.class, args);
    }
}
