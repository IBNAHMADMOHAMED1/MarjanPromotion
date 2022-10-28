package controller;

import dao.HibernateDao;
import entity.Categorie;
import service.JpaService;

import java.util.List;

public class CategorieController extends HibernateDao<Categorie> {
    private static final JpaService jpaService = JpaService.getInstance();
    private static Categorie entity = new Categorie();
    public CategorieController() {
        setClazz(Categorie.class);
    }

    // getAllCategoriesByCentre
    public List<Categorie> getAllCategoriesByCentre(int idCentre, String type) {
        List<Categorie>  list = (List<Categorie>) jpaService.runInTransaction(entityManager -> entityManager
                .createNativeQuery("select * from categorie where idCentre = " + idCentre, Categorie.class)
                .getResultList());
        if (type.equals("all")){
            System.out.println(idCentre);
            return list;
        }
        list.removeIf(categorie -> categorie.getIdresponsable() != null);
        return list;
    }

    public void  updateIdResponsable(int idCategorie, int idResponsable) {
        Boolean isResponsable = (Boolean) jpaService.runInTransaction(entityManager -> entityManager
                .createNativeQuery("select exists(select * from categorie where idresponsable = " + idResponsable + ")")
                .getSingleResult());
        if (isResponsable) {
            jpaService.runInTransaction(entityManager -> entityManager
                    .createQuery("update Categorie set idresponsable = " + idResponsable + " where idcategorie = " + idCategorie)
                    .executeUpdate());
        }
        else {
            System.out.println("This categorie is not responsable");
        }
    }

    // getCategorieByResponsable
    public Categorie getCategorieByResponsable(int idResponsable) {
        return (Categorie) jpaService.runInTransaction(entityManager -> entityManager
                .createNativeQuery("select * from categorie where idresponsable = " + idResponsable, Categorie.class)
                .getResultList().stream().findFirst().orElse(null));
    }
}
