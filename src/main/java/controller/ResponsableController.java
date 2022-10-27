package controller;

import dao.HibernateDao;
import entity.Categorie;
import entity.Personne;
import entity.Responsable;
import service.JpaService;

public class ResponsableController extends HibernateDao<Responsable> {
    private static Responsable entity = new Responsable();

    private static final JpaService jpaService = JpaService.getInstance();
    public ResponsableController() {
        setClazz(Responsable.class);
    }

    // create responsable
    public Responsable createResponsable(int personneId, int categorieId, int centreId) {
       Responsable responsable = new Responsable();
        CategorieController cg = new CategorieController();
         responsable.setPersonneId(personneId);
         responsable.setCategorieId(categorieId);
         responsable.setIdcentre(centreId);
        Responsable rs = create(responsable);
         cg.updateIdResponsable(categorieId, rs.getIdresponsable());
          return  rs;
    }
}
