package br.com.jogodavelha.repository;

import br.com.jogodavelha.util.JPAUtil;
import javax.persistence.EntityManager;

public abstract class GenericRepository {
    
    protected static EntityManager entityManager;

    protected GenericRepository() {
        getEntityManager();
    }

    public void insert(Object obj) {
        try {
            if (!entityManager.isOpen()) {
                getEntityManager();
            }
            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void update(Object obj) {
        try {
            if (!entityManager.isOpen()) {
                getEntityManager();
            }
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void delete(Object obj) {
        try {
            if (!entityManager.isOpen()) {
                getEntityManager();
            }            
            entityManager.getTransaction().begin();
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
    
    protected static void getEntityManager() {
        entityManager = JPAUtil.getEntityManager();
    }
}
