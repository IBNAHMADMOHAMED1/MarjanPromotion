package controller;

import dao.HibernateDao;
import entity.Admincentre;
import service.JpaService;

public class AdminCenterController extends HibernateDao<Admincentre> {

    private static Admincentre entity = new Admincentre();
    private static final JpaService jpaService = JpaService.getInstance();

    public AdminCenterController() {
        setClazz(Admincentre.class);
    }

    // getAdminCentreByPersonne
    public Admincentre getAdminCentreByPersonne(int id) {
        return (Admincentre) jpaService.runInTransaction(entityManager -> entityManager
                .createNativeQuery("select * from admincentre where personne_id = " + id, Admincentre.class)
                .getResultList().stream().findFirst().orElse(null));
    }

}
