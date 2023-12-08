package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Currency targetCurrency;

    private double amount;

    // Constructors, getters, setters
    public Transaction() {
    }

    public Transaction(Currency sourceCurrency, Currency targetCurrency, double amount) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setSourceCurrency(Currency sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
