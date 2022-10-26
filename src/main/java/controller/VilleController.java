package controller;

import dao.HibernateDao;
import entity.Ville;
import service.JpaService;
import utils.Sout;

import java.util.*;

public class VilleController extends HibernateDao<Ville> {
    private static final JpaService jpaService = JpaService.getInstance();
    private static Ville entity = new Ville();

    private  static List<Ville> villeList = new ArrayList<>();

    public VilleController() {
        setClazz(Ville.class);
    }

    public static Ville getEntity() {
        return entity;
    }

    public static void setEntity(Ville entity) {
        VilleController.entity = entity;
    }

    public static List<Ville> getAllVille() {
        villeList = jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select v from Ville v", Ville.class)
                    .getResultList();
        });
        return villeList;
    }

    // create ville
    public static int createVille(String nom) {
        Ville ville = new Ville();
        int lastId = 0;
        Boolean isAlreadyExist = chekIfVilleExist(nom);
        if (!isAlreadyExist) {
            ville.setNomville(nom);
            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(ville);
                return  null;
            });
            lastId = ville.getIdville();
            return lastId;
        } else {
            Sout.sout("red", "Ville already exist");
            return 0;
        }
    }

    // check if ville exist
    public static Boolean chekIfVilleExist(String nom) {
        Boolean isAlreadyExist = jpaService
                .runInTransaction(entityManager -> {
                    return entityManager.createQuery("select v from Ville v where v.nomville = :nom", Ville.class)
                            .setParameter("nom", nom)
                            .getResultList().size() > 0;
                });
        return isAlreadyExist;
    }
    public static Ville getVilleById(int id) {
        Ville ville = jpaService.runInTransaction(entityManager -> {
            return entityManager.find(Ville.class, id);
        });
        return ville;
    }


    // checkIfVilleHasAdmin
    public  Ville checkIfVilleHasAdmin(int id) {
      return findOne(id);
    }

}
