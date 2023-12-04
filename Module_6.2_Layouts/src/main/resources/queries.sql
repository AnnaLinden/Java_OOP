-- Retrieve all currencies:
SELECT * FROM currency_converter.CURRENCY;

-- Retrieve the currency with the abbreviation EUR:
SELECT * FROM currency_converter.CURRENCY WHERE abbreviation = 'EUR';

-- Retrieve the number of currencies:
SELECT COUNT(*) FROM currency_converter.CURRENCY;

-- Retrieve the currency with the highest exchange rate:
SELECT * FROM currency_converter.CURRENCY ORDER BY rateToUSD DESC LIMIT 1;
