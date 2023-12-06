package application;

import javafx.application.Application;
import entity.Currency;
import entity.CurrencyConverter;
import UI.CurrencyConverterView;
import dao.CurrencyDao;
import java.util.List;

public class CurrencyConverterController {
    private CurrencyConverterView view;
    private CurrencyConverter model;

    private CurrencyDao currencyDao;

    public CurrencyConverterController(CurrencyConverterView view, CurrencyConverter model) {
        this.view = view;
        this.model = model;
        this.currencyDao = new CurrencyDao();

        initializeCurrencies();
        view.getConvertButton().setOnAction(event -> convertCurrency());
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(view.getSourceAmount().getText());
            Currency fromCurrency = view.getSourceCurrencyBox().getValue();
            Currency toCurrency = view.getTargetCurrencyBox().getValue();

            double fromRate = currencyDao.getExchangeRate(fromCurrency.getAbbreviation());
            double toRate = currencyDao.getExchangeRate(toCurrency.getAbbreviation());

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
        List<Currency> currencies = currencyDao.getAllCurrencies();
        if (!currencies.isEmpty()) {
            view.getSourceCurrencyBox().getItems().addAll(currencies);
            view.getTargetCurrencyBox().getItems().addAll(currencies);
        } else {
            view.showError("Unable to fetch currencies from the database.");
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        Application.launch(CurrencyConverterView.class, args);
    }
}
