package controller;

import static org.junit.jupiter.api.Assertions.*;

class CategorieControllerTest {

    @org.junit.jupiter.api.Test
    void getAllCategoriesByCentre() {
        CategorieController categorieController = new CategorieController();
        categorieController.getAllCategoriesByCentre(1, "all");
    }

    @org.junit.jupiter.api.Test
    void updateIdResponsable() {
        CategorieController categorieController = new CategorieController();
        categorieController.updateIdResponsable(1, 1);
    }

    @org.junit.jupiter.api.Test
    void getCategorieByResponsable() {
        CategorieController categorieController = new CategorieController();
        categorieController.getCategorieByResponsable(1);
    }
}

