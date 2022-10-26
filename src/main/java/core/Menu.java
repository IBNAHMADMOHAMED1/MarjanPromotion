package core;

import controller.AdminVilleController;
import controller.PersonneController;
import controller.VilleController;
import entity.Personne;
import entity.Ville;
import utils.Sout;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public static  void adminGeneralMenu ()
    {
        String[] details;
        Ville ville = new Ville();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1- Add Admin Ville");
            System.out.println("2- Get All Admin Ville");
            System.out.println("4- Get All Personnes");
            System.out.println("5- Logout");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    AdminVilleController ad = new AdminVilleController();
                    details = villeProcced("Create Admin Ville");
                    if (details[4].equals("Create")) ad.createAdminVille(details);
                    else ad.updateAdminVille(details);
                    break;
                case 2:
                    AdminVilleController ad1 = new AdminVilleController();
                    ad1.getAllAdminVille();
                    break;
                case 3:
                    System.out.println("Create New Promotion");
                    break;
                    case 4:
                        PersonneController personController = new PersonneController();
                        List<Personne> personneList = personController.findAllPersonne(0,100);
                        personneList.stream()
                                .map(personne -> "Full Name: " + personne.getFullname() + " Email" + personne.getEmail())
                                .forEach(System.out::println);

                    break;
                case 5:
                    PersonneController personneController = new PersonneController();
                    personneController.logout("adminGeneral");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
    public static String[] villeProcced(String title) {
        System.out.println("*** " + title + " ***");
        System.out.println("Select Ville");
        String souTitle = "Create";
        VilleController villeController = new VilleController();
        Ville selectedVille = getVilleDetails();
        int idVille =  selectedVille.getIdville();
        System.out.println(idVille);
        Ville villeHasAdmin = villeController.checkIfVilleHasAdmin(idVille);
        if (villeHasAdmin.getIdadminv() != null ){
            Sout.sout("red", "Ville has Admin Ville");
            Sout.sout("yellow", "Do you want to update Admin Ville ? (y/n)");
            Scanner s = new Scanner(System.in);
            String choiceUpdate = s.nextLine();
            if (choiceUpdate.equals("y")) {
                souTitle = "Update";
                Sout.sout("green", "Proceed to update Admin Ville");
            } else {
                Sout.sout("green", "Go Back to Menu");
                getVilleDetails();
            }
        }
        while (true)
        {
            System.out.println(souTitle + "Admin  for Ville " + selectedVille.getNomville());
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The fullname");
            String fullname = sc.nextLine();
            System.out.println("Enter The email");
            String email = sc.nextLine();
            System.out.println("Enter The password");
            String password = sc.nextLine();
            if (fullname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Sout.sout("red", "All fields are required");
            } else {
                return new String[]{fullname, email, password, String.valueOf(idVille), souTitle};
            }
        }
    }

    // select ville
    public static Ville getVilleDetails() {
        VilleController villeController = new VilleController();
        List<Ville> villes = villeController.getAllVille();
        Ville ville = new Ville();
        System.out.println("Villes List");
        for (Ville v : villes) {
            System.out.println(v.getIdville() + " - " + v.getNomville());
        }
        Sout.sout("yellow", "0 - to add new Ville");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                System.out.println("Enter The Ville Name");
                Scanner s = new Scanner(System.in);
                String villeName = s.nextLine();
                int id  = villeController.createVille(villeName);
                Sout.sout("green", "Ville Added Successfully");
                getVilleDetails();
            default:

        }
        villes = villeController.getAllVille();
        Sout.sout("green", "You Selected Ville : " + villes.get(choice - 1).getNomville());
        return villes.get(choice - 1);
    }

    // adminVilleMenu create a center and adminCenter
    public static void adminVilleMenu() {
        VilleController villeController = new VilleController();
        Ville ville = villeController.getVilleById(1);
        System.out.println("You are admin of " + ville.getNomville());
        while (true) {
            System.out.println("1- Show All promotion By ville");
            System.out.println("2- Show Satus of All promotion By ville");
            System.out.println("3- Logout");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Create New Center");

                    break;
                case 2:
                    System.out.println("Get All Centers");
                    break;
                case 3:
                    PersonneController personneController = new PersonneController();
                    personneController.logout("adminVille");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // centerProcced

}
