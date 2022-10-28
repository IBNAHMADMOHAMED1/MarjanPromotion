package controller;

import static org.junit.jupiter.api.Assertions.*;

class AdminCenterControllerTest {

    @org.junit.jupiter.api.Test
    void getAdminCentreByPersonne() {
        AdminCenterController adminCenterController = new AdminCenterController();
        adminCenterController.getAdminCentreByPersonne(1);
    }
}


