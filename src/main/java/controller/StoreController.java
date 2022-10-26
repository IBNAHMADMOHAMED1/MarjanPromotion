package controller;

import dao.HibernateDao;
import entity.Store;
import service.JpaService;
import utils.Sout;

public class StoreController extends HibernateDao<Store> {
    private  static final Store entity = new Store();

    public static void setItem(String key, String value) {
        entity.setKey(key);
        entity.setValue(value);
        System.out.println(entity.getKey()+ "****** " + entity.getValue());
        JpaService.getInstance().runInTransaction(entityManager -> {
            entityManager.persist(entity);
            return null;
        });
    }
    public StoreController() {
        setClazz(Store.class);
    }

    public static String getItem(String key) {
        String value = null;
        value = JpaService.getInstance().runInTransaction(entityManager -> {
            return entityManager.createQuery("select l from Store  l where l.key = :key order by l.id desc", Store.class)
                    .setParameter("key", key)
                    .getResultList().size() > 0 ? entityManager.createQuery("select l from Store l where l.key = :key order by l.id desc", Store.class)
                    .setParameter("key", key)
                    .getResultList().get(0).getValue() : null;

        });

        return value;
    }

    public  void removeItem(String key) {
      Boolean isDelet = delete(entity);
      Sout.sout("blue", "We are removing your token because it is expired");
    }

    public void  deleteItem(String key, String value) {
        System.out.println(key + " " + value);
        Store store = new Store();
        store.setKey(key);
        store.setValue(value);
        Boolean isDelet = deleteWhere("key", key);
    }


}
