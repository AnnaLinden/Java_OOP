package dao;

import entity.Transaction;
import datasource.MariaDbJpaConnection;
import java.util.logging.Logger;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    private static final Logger logger = Logger.getLogger(TransactionDao.class.getName());

    public void persist(Transaction transaction) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error persisting transaction", e);
        }
    }

    // Other methods...
}
