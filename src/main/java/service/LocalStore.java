package service;

import entity.Store;

public class LocalStore {
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
    public static String getItem(String key) {
        String value = null;
        value = JpaService.getInstance().runInTransaction(entityManager -> {
            return entityManager.createQuery("select l from Store  l where l.key = :key order by l.id desc", Store.class)
                   // if exist return the last value if not return null
                    .setParameter("key", key)
                    .getResultList().size() > 0 ? entityManager.createQuery("select l from Store l where l.key = :key order by l.id desc", Store.class)
                    .setParameter("key", key)
                    .getResultList().get(0).getValue() : null;

        });

        return value;
    }

    public static void removeItem(String key) {
        JpaService.getInstance().runInTransaction(entityManager -> {
            entityManager.createQuery("delete from Store l where l.key = :key")
                    .setParameter("key", key)
                    .executeUpdate();
            return null;
        });
    }

}
