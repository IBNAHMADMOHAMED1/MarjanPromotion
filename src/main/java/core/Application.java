package core;

import entity.Personne;
import service.JpaService;

import java.util.List;

public class Application {
    private static final JpaService jpaService = JpaService.getInstance();

    public static void main(String[] args) {
        printPersonData();

    }

    // print persone data
    public static void printPersonData() {
        List<Personne> personneList =jpaService
        .runInTransaction(entityManager ->
            entityManager.createQuery("select p from Personne p", Personne.class)
                    .getResultList());
        personneList.stream()
                .map(personne -> "Full Name: " + personne.getFullname() + " Email" + personne.getEmail())
                .forEach(System.out::println);

    }

}
