package dao;

import datasource.MariaDbConnection;
import entity.Currency;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    public double getExchangeRate(String abbreviation) {
        String sql = "SELECT rateToUSD FROM CURRENCY WHERE abbreviation = ?";
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, abbreviation);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("rateToUSD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error appropriately
        }
        return -1; // Indicate error
    }
    public List<Currency> getAllCurrencies() {
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
            e.printStackTrace();
            // Handle error appropriately
        }
        return currencies;
    }
}
