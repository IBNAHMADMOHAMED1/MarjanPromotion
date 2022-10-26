package controller;

import dao.HibernateDao;
import entity.Personne;
import service.*;
import utils.Sout;

import java.util.List;

public class PersonneController extends HibernateDao<Personne> {
    private static final JpaService jpaService = JpaService.getInstance();
    private static Personne entity = new Personne();
    private static Boolean isLogin = false;

    private static String fullname;
    private static String email;

    public static String getFullname() {
        return fullname;
    }
    public PersonneController() {
        setClazz(Personne.class);
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

        Personne res = authenticate(email, password,tableJoin);
        if (res != null) {
            setIsLogin(true);
            Sout.sout("green", "Login success");
            Sout.sout("green", "Welcome " + res.getFullname());
        } else {
            Sout.sout("red", "Login failed");
        }
    }


    // storeToken
    public void storeToken(String[] details,String role) {
        fullname = details[0];
        email = details[1];
        String token = Jwt.generateToken(email, role, fullname);
        System.out.println("Your Token is " + token);
        StoreController.setItem(role, token);
    }

    // methode to if user has token or not if have return person data
    public static Personne checkToken(String role) {
        String token = StoreController.getItem(role);
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
            else {
                StoreController rmToken = new StoreController();
                rmToken.removeItem(token);
            }
        }
        return null;
    }

    public static void logout(String key) {
        entity = new Personne();
        String token = StoreController.getItem(key);
        StoreController rmToken = new StoreController();
        rmToken.deleteItem(key, token);
        isLogin = false;
    }
    public int createPersonne(Personne personne) {
        Personne res = create(personne);
        return res.getId();
    }

    public List<Personne> findAllPersonne(int start, int limit) {
         return findAll(start, limit);
    }

    public Personne findPersonneById(int id,String tableJoin) {
        return findOneJoin(id,tableJoin);
    }





}
