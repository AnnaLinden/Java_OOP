package dao;

import entity.Currency;
import datasource.MariaDbJpaConnection;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.logging.Logger;
public class CurrencyDao {
    private static final Logger logger = Logger.getLogger(CurrencyDao.class.getName());

    public void persist(Currency currency) throws CurrencyDaoException {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            logger.info("Beginning transaction to persist new currency");
            em.getTransaction().begin();
            logger.info("Persisting currency: " + currency);
            em.persist(currency);
            logger.info("Committing transaction");
            em.getTransaction().commit();
            logger.info("Transaction committed successfully, currency persisted");
        } catch (Exception e) {
            logger.severe("Exception occurred while persisting currency: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                logger.info("Transaction is active, rolling back");
                em.getTransaction().rollback();
                logger.info("Transaction rolled back");
            }
            e.printStackTrace();  // Log stack trace for detailed error
            throw new CurrencyDaoException("Error inserting new currency", e);
        }
    }

    public Currency find(String abbreviation) throws CurrencyDaoException {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            return em.find(Currency.class, abbreviation);
        } catch (Exception e) {
            throw new CurrencyDaoException("Error finding currency: " + abbreviation, e);
        }
    }

    public List<Currency> getAllCurrencies() throws CurrencyDaoException {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c", Currency.class);
            return new ArrayList<>(query.getResultList());
        } catch (Exception e) {
            throw new CurrencyDaoException("Error fetching all currencies", e);
        }
    }

    // You can add update and delete methods similarly if needed

    public static class CurrencyDaoException extends Exception {
        public CurrencyDaoException(String message) {
            super(message);
        }

        public CurrencyDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}