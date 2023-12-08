package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation", unique = true, nullable = false)
    private String abbreviation;

    @Column(name = "rateToUSD")
    private double rateToUSD;

    public Currency() {
        // JPA requires a default constructor
    }
    public Currency(String name, String abbreviation, double rateToUSD) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.rateToUSD = rateToUSD;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setRateToUSD(double rateToUSD) {
        this.rateToUSD = rateToUSD;
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}