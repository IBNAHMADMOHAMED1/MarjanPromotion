package dao;

import entity.Personne;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.JpaService;

import java.io.Serializable;
import java.util.List;

public abstract class HibernateDao<T extends Serializable> {
    private Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;
    private static final JpaService jpaService = JpaService.getInstance();

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(long id) {
        return (T) jpaService.runInTransaction(entityManager -> {
            return entityManager.find(clazz, id);
        });
    }
    public T create(T entity) {
        return (T) jpaService.runInTransaction(entityManager -> {
            entityManager.persist(entity);
            return entity;
        });
    }
    public T update(T entity) {
        return (T) jpaService.runInTransaction(entityManager -> {
            entityManager.merge(entity);
            return entity;
        });
    }

    public Boolean delete(T entity) {
        return (Boolean) jpaService.runInTransaction(entityManager -> {
            entityManager.remove(entity);
            return true;
        });
    }
    public T authenticate(String email, String password,String tableJoin) {

        T entity = (T) jpaService.runInTransaction(entityManager -> {
            return entityManager.createNativeQuery("SELECT * FROM Personne p JOIN "+ tableJoin +" a ON p.id = a.personne_id WHERE p.email = :email AND p.password = :password", Personne.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        });

        return entity;
    }

    public List<T> findAll(int start, int limit) {
        return (List<T>) jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("from " + clazz.getName())
                    .setFirstResult(start)
                    .setMaxResults(limit)
                    .getResultList();
        });

    }

}
