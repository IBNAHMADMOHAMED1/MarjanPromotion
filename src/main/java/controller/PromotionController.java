package controller;

import dao.HibernateDao;
import entity.Promotion;
import service.JpaService;

public class PromotionController extends HibernateDao<Promotion> {
    private static final JpaService jpaService = JpaService.getInstance();
    public PromotionController() {
        setClazz(Promotion.class);
    }

    // create promotion
    public Promotion createPromotion(String nom, String dateDebut, String dateFin, Double discount, int idCategorie ) {
        Promotion promotion = new Promotion();
        promotion.setCategorieId(idCategorie);
        promotion.setNompromotion(nom);
        promotion.setIsaccepted(false);
        promotion.setEnddate(dateFin);
        promotion.setStartdate(dateDebut);
        promotion.setRatio(discount);
        return create(promotion);
    }
}
