package controller;

import entity.Personne;
import service.*;

import javax.swing.*;

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

        Personne personne = jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select p from Personne p where p.email = :email and p.password = :password", Personne.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getResultList().stream().findFirst().orElse(null);
        });
        if (personne != null) {
            setIsLogin(true);
            setEntity(personne);
            System.out.println("Welcome 1 " + personne.getFullname());
            fullname = personne.getFullname();
            this.email = email;
        } else {
            System.out.println("Error");
        }
    }


    // storeToken
    public void storeToken(String[] details,String role) {
        fullname = details[0];
        email = details[1];
        String token = Jwt.generateToken(email, role, fullname);
        System.out.println("Your Token is " + token);
        LocalStore.setItem(role, token);
    }

    // methode to if user has token or not if have return person data
    public static Personne checkToken(String role) {
        String token = LocalStore.getItem(role);
        if (token != null) {
            // check if token is valid
            if (! Jwt.isTokenExpired(token)) {
                // get user data from token
                String[] userData = Jwt.decodeToken(token);
                // get user data from database
                Personne personne = (Personne) jpaService.runInTransaction(entityManager -> {
                    return entityManager.createNativeQuery("SELECT * FROM personne p WHERE p.email = ? ", Personne.class)
                            .setParameter(1, userData[0])
                            .getSingleResult();
                });
                return personne;
            }

        }
        return null;
    }




    public static void logout() {
        entity = new Personne();
        isLogin = false;
    }





}
