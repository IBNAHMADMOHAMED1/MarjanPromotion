package core;

import controller.VilleController;
import entity.Ville;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public static  void adminGeneral ()
    {
        String[] details;
        Ville ville = new Ville();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1- Add Admin Ville");
            System.out.println("2- Update Admin Ville");
            System.out.println("3- Create New Promotion");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:

                    details = getRegisterDetails("Create Admin Ville");
                    break;
                case 2:
                    System.out.println("Update Admin Ville");
                    break;
                case 3:
                    System.out.println("Create New Promotion");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
    public static String[] getRegisterDetails(String title) {
        System.out.println("*** " + title + " ***");
        while (true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The fullname");
            String fullname = sc.nextLine();
            System.out.println("Enter The email");
            String email = sc.nextLine();
            System.out.println("Enter The password");
            String password = sc.nextLine();
            if (fullname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                System.out.println("Please enter your fullname, email and password");
            } else {
                return new String[]{fullname, email, password};
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
        System.out.println("0 - Add New Ville");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                System.out.println("Enter The Ville Name");
                String villeName = sc.nextLine();
                int id  = villeController.createVille(villeName);
                System.out.println("Ville Created Successfully"+id);
            default:

        }
        return choice;

    }
}
