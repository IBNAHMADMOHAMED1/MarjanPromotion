package controller;

import dao.HibernateDao;
import entity.Centre;
import service.JpaService;

import java.util.List;

public class CentreController extends HibernateDao<Centre> {
    private static final JpaService jpaService = JpaService.getInstance();
    private static Centre entity = new Centre();
    private static Boolean isLogin = false;

    private static String fullname;
    private static String email;

    public static String getFullname() {
        return fullname;
    }
    public CentreController() {
        setClazz(Centre.class);
    }

    // list all
    public List<Centre> listAll() {
        return findAll(0, 100);
    }

    // getCentreByPersonne
    public Centre getCentreByAdminC(int id) {
        return (Centre) jpaService.runInTransaction(entityManager -> entityManager
                .createNativeQuery("select * from centre where idAdminC = " + id, Centre.class)
                .getResultList().stream().findFirst().orElse(null));
    }
    // getCentreByPersonne


}
