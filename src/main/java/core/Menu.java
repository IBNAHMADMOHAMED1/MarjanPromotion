package core;

import controller.AdminVilleController;
import controller.AdmingeneralController;
import controller.PersonneController;
import controller.VilleController;
import entity.Admingeneral;
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
            System.out.println("2- Update Admin Ville");
            System.out.println("3- Create New Promotion");
            System.out.println("4- Get All Personnes");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:

                    details = getRegisterDetails("Create Admin Ville");
                    AdminVilleController.createAdminVille(details);
                    break;
                case 2:
                    System.out.println("Update Admin Ville");
                    break;
                case 3:
                    System.out.println("Create New Promotion");
                    break;
                    case 4:
                        PersonneController personController = new PersonneController();
                      List<Personne> personneList = personController.findAllPersonne(0,3);
                        personneList.stream()
                                .map(personne -> "Full Name: " + personne.getFullname() + " Email" + personne.getEmail())
                                .forEach(System.out::println);

                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
    public static String[] getRegisterDetails(String title) {
        System.out.println("*** " + title + " ***");
        System.out.println("Select Ville");
        int idVille =  getVilleDetails();

        while (true)
        {
            System.out.println("Crating Admin  for Ville " + VilleController.getEntity().getNomville());
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
                return new String[]{fullname, email, password, String.valueOf(idVille)};
            }
        }
    }

    // select ville
    public static int getVilleDetails() {
       // print list ville and make choice if want to add new ville
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
        Sout.sout("green", "You Selected Ville : " + villes.get(choice - 1).getNomville());
        return villes.get(choice - 1).getIdville();
    }
}
