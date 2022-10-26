package controller;

import dao.HibernateDao;
import entity.Adminville;
import entity.Personne;
import entity.Ville;
import service.JpaService;
import service.Mail;
import utils.Sout;

import java.util.List;

public class AdminVilleController extends HibernateDao<Adminville> {
    private static final JpaService jpaService = JpaService.getInstance();
    private static Boolean isLogin = false;
    private static Adminville entity = new Adminville();

    public AdminVilleController() {
        setClazz(Adminville.class);
    }

    // using hibernate and stram create admin ville
    public void createAdminVille(String[] data) {
        Adminville adminville = new Adminville();
        VilleController villeController = new VilleController();
        PersonneController personneController = new PersonneController();
            Personne personne = new Personne();
            personne.setFullname(data[0]);
            personne.setEmail(data[1]);
            personne.setPassword(data[2]);
            int idPersonne = personneController.createPersonne(personne);
            adminville.setPersonneId(idPersonne);
            adminville.setIdville(Integer.parseInt(data[3]));
            Adminville res = create(adminville);
            Mail.sendMail("Bonjour " + data[0] + " votre compte a été crée avec succés Votre mot de passe est : " + data[2] ,"Création de compte", data[1]);
            Sout.sout("green", "Admin ville created");
    }
    public void updateAdminVille(String[] data) {
        Adminville adminville = new Adminville();
        VilleController villeController = new VilleController();
        PersonneController personneController = new PersonneController();
        Personne personne = new Personne();
        personne.setFullname(data[0]);
        personne.setEmail(data[1]);
        personne.setPassword(data[2]);
        int idPersonne = personneController.createPersonne(personne);
        adminville.setPersonneId(idPersonne);
        adminville.setIdville(Integer.parseInt(data[3]));
        Adminville res = update(adminville);
        Sout.sout("green", "Admin ville updated");
    }

    // getAll with person and ville
    public void getAllAdminVille() {
        VilleController villeController = new VilleController();
        PersonneController personneController = new PersonneController();
        List<Adminville> res = findAll(0,100);
        for (Adminville adminville : res) {
            Ville ville = villeController.findOne(adminville.getIdville());
            Personne personne = personneController.findOne(adminville.getPersonneId());
            // table
            System.out.println("id: " + adminville.getIdville() + " | fullname: " + personne.getFullname() + " | email: " + personne.getEmail() + " | ville: " + ville.getNomville());
        }
    }




}
