/*
 * Task 1: Read a CSV file from the network location
 * There is a network file (https://users.metropolia.fi/~jarkkov/temploki.csv)
 * where we have periodical temperature measurements at 10 minutes interval.
 * Create an application which reads the file, reads the 'UlkoTalo' column,
 * and calculates the average temperature for the 1st day of January 2023.
 * 
 */

package Task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AverageTemperatureCalculator {

    public static void main(String[] args) {
        String urlString = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        try {
            URL url = new URL(urlString);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                double totalTemp = 0;
                int count = 0;

                while ((line = reader.readLine()) != null) {
                    String[] columns = line.split(";"); // Assuming ';' is the delimiter

                    // Check if the line is valid and has enough columns
                    if (columns.length > 1 && isDateFirstJanuary2023(columns[0])) {
                        try {
                            double temp = Double.parseDouble(columns[1].replace(",", ".")); // Assuming 'UlkoTalo' is
                                                                                            // the second column and
                                                                                            // uses comma as decimal
                                                                                            // separator
                            totalTemp += temp;
                            count++;
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid temperature format: " + columns[1]);
                        }
                    }
                }

                if (count > 0) {
                    double averageTemp = totalTemp / count;
                    System.out.println("Average temperature for 1st January 2023: " + averageTemp);
                } else {
                    System.out.println("No data found for 1st January 2023.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static boolean isDateFirstJanuary2023(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date date = format.parse(dateString);
            return date.equals(format.parse("01.01.2023"));
        } catch (Exception e) {
            return false;
        }
    }
}