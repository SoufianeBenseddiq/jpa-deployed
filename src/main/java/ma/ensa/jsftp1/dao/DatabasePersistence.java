package ma.ensa.jsftp1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DatabasePersistence {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("persistence_unit");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
