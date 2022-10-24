package controller;

import entity.Personne;
import service.JpaService;

public class PersonneController {
    private static final JpaService jpaService = JpaService.getInstance();
    private static Personne entity = new Personne();
    private static Boolean isLogin = false;

    private static String fullname;
    private static String email;

    public static String getFullname() {
        return fullname;
    }


    public static Boolean getIsLogin() {
        return isLogin;
    }

    public static void setIsLogin(Boolean isLogin) {
        PersonneController.isLogin = isLogin;
    }

    public static Personne getEntity() {
        return entity;
    }

    public static void setEntity(Personne entity) {
        PersonneController.entity = entity;
    }

    public  void login(String email, String password,String tableJoin) {
        // native query
        Personne personne = (Personne) jpaService.runInTransaction(entityManager -> {
            return entityManager.createNativeQuery("SELECT * FROM personne p JOIN "+tableJoin+" a ON p.id = a.personne_id WHERE p.email = ? AND p.password = ?", Personne.class)
                    .setParameter(1, email)
                    .setParameter(2, password)
                    .getSingleResult();
        });


        if (personne != null) {
            setEntity(personne);
            setIsLogin(true);
            System.out.println("Login Success");
        } else {
            setIsLogin(false);
            System.out.println("Login Failed");
        }

    }




    public static void logout() {
        entity = new Personne();
        isLogin = false;
    }





}
