-- Drop the existing database if it exists
DROP DATABASE IF EXISTS currency_converter;

-- Create the new database
CREATE DATABASE currency_converter;

-- Use the newly created database
USE currency_converter;

-- Create the CURRENCY table
CREATE TABLE CURRENCY (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    abbreviation VARCHAR(10) NOT NULL,
    rateToUSD DECIMAL(10, 2) NOT NULL
);

-- Insert data into the CURRENCY table
INSERT INTO CURRENCY (name, abbreviation, rateToUSD) VALUES
('US Dollar', 'USD', 1.00),
('Euro', 'EUR', 1.08), -- Update with current rate
('British Pound', 'GBP', 1.26), -- Update with current rate
('Japanese Yen', 'JPY', 0.0068), -- Update with current rate
('Australian Dollar', 'AUD', 0.66), -- Update with current rate
('Canadian Dollar', 'CAD', 0.73), -- Update with current rate
('Swiss Franc', 'CHF', 1.14), -- Update with current rate
('Chinese Yuan', 'CNY', 0.14); -- Update with current rate


-- Drop the user account if it exists
DROP USER IF EXISTS 'appuser'@'localhost';


-- Create the user account
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password'; -- Replace with a secure password

-- Grant SELECT privilege to the appuser account
GRANT SELECT ON currency_converter.* TO 'appuser'@'localhost';
GRANT INSERT ON currency_converter.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;



