package controller;

import entity.Admingeneral;
import service.JpaService;

public class AdmingeneralController  extends  PersonneController {

    private static final JpaService jpaService = JpaService.getInstance();
    private static Admingeneral entity = new Admingeneral();
    private static Boolean isLogin = false;

    public static Boolean getIsLogin() {
        return isLogin;
    }

    public static void setIsLogin(Boolean isLogin) {
        AdmingeneralController.isLogin = isLogin;
    }









}
