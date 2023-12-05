package entity;


public class Currency {
    private String name;
    private String abbreviation;
    private double rateToUSD;

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