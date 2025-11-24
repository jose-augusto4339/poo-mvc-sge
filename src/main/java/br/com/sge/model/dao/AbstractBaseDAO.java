package br.com.sge.model.dao;

import br.com.sge.configuration.hibernate.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public abstract class AbstractBaseDAO<T> {

    private final Class<T> entityClass;

    protected AbstractBaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void delete(T entity){
        Transaction transaction = null;
        try(Session session = this.getSession()){
            transaction = session.beginTransaction();

            T managed = entity;
            if (!session.contains(entity)) {
                managed = (T) session.merge(entity);
            }

            session.remove(managed);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
                throw e;
            }
        }
    }

    public void update(T entity){
        Transaction transaction = null;
        try(Session session = this.getSession()){
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
                throw e;
            }
        }
    }

    public void save(T entity){
        Transaction transaction = null;
        try(Session session = this.getSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            throw e;
        }

    }

    public List<T> findAll() {
        String hql = "from " + entityClass.getSimpleName();
        return getSession()
                .createSelectionQuery(hql, entityClass)
                .getResultList();
    }

    protected Session getSession() {
        return HibernateConnection.getSession();
    }
}
