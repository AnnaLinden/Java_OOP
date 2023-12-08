package entity;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private String sourceCurrencyAbbreviation;
    private String targetCurrencyAbbreviation;
    private double amount;

    // Default constructor
    public Transaction() {
    }

    // Constructor with parameters
    public Transaction(String sourceCurrencyAbbreviation, String targetCurrencyAbbreviation, double amount) {
        this.sourceCurrencyAbbreviation = sourceCurrencyAbbreviation;
        this.targetCurrencyAbbreviation = targetCurrencyAbbreviation;
        this.amount = amount;
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getSourceCurrencyAbbreviation() {
        return sourceCurrencyAbbreviation;
    }

    public void setSourceCurrencyAbbreviation(String sourceCurrencyAbbreviation) {
        this.sourceCurrencyAbbreviation = sourceCurrencyAbbreviation;
    }

    public String getTargetCurrencyAbbreviation() {
        return targetCurrencyAbbreviation;
    }

    public void setTargetCurrencyAbbreviation(String targetCurrencyAbbreviation) {
        this.targetCurrencyAbbreviation = targetCurrencyAbbreviation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", sourceCurrencyAbbreviation='" + sourceCurrencyAbbreviation + '\'' +
                ", targetCurrencyAbbreviation='" + targetCurrencyAbbreviation + '\'' +
                ", amount=" + amount +
                '}';
    }
}