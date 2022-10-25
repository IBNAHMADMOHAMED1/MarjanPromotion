package controller;

import entity.Adminville;
import entity.Personne;
import service.JpaService;
import utils.Sout;

public class AdminVilleController {
    private static final JpaService jpaService = JpaService.getInstance();
    private static Boolean isLogin = false;
    private static Adminville entity = new Adminville();

    // using hibernate and stram create admin ville
    public static void createAdminVille(String[] data) {
        Adminville adminville = new Adminville();
        PersonneController personneController = new PersonneController();
        Personne personne = new Personne();
        personne.setFullname(data[0]);
        personne.setEmail(data[1]);
        personne.setPassword(data[2]);
        int idPersonne = personneController.createPersonne(personne);
        adminville.setPersonneId(idPersonne);
        adminville.setIdville(Integer.parseInt(data[3]));
        jpaService.runInTransaction(entityManager -> {
            entityManager.persist(adminville);
            if (adminville.getIdville() != null) {
                Sout.sout("green", "Admin" + adminville.getPersonneId() + " created, with ville Name " + VilleController.getVilleById(adminville.getIdville()).getNomville());

            } else {
                Sout.sout("red", "Error");
            }
            return null;
        });

    }
}
