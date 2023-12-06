package dao;

import datasource.MariaDbConnection;
import entity.Currency;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyDao {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyDao.class);

    public double getExchangeRate(String abbreviation) throws CurrencyDaoException {
        String sql = "SELECT rateToUSD FROM CURRENCY WHERE abbreviation = ?";
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, abbreviation);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("rateToUSD");
            } else {
                throw new CurrencyDaoException("No rate found for abbreviation: " + abbreviation);
            }
        } catch (SQLException e) {
            logger.error("SQL error while fetching exchange rate for " + abbreviation, e);
            throw new CurrencyDaoException("Error fetching exchange rate", e);
        }
    }

    public List<Currency> getAllCurrencies() throws CurrencyDaoException {
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT name, abbreviation, rateToUSD FROM CURRENCY";

        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String abbreviation = rs.getString("abbreviation");
                double rateToUSD = rs.getDouble("rateToUSD");

                currencies.add(new Currency(name, abbreviation, rateToUSD));
            }
        } catch (SQLException e) {
            logger.error("SQL error while fetching all currencies", e);
            throw new CurrencyDaoException("Error fetching currencies", e);
        }
        return currencies;
    }

    // Define a custom exception class
    public static class CurrencyDaoException extends Exception {
        public CurrencyDaoException(String message) {
            super(message);
        }

        public CurrencyDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

