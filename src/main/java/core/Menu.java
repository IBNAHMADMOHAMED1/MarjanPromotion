package core;

import controller.*;
import entity.*;
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
            System.out.println("1- Show All promotion Of center");
            System.out.println("2- Show Satus of All promotion By ville");
            System.out.println("3- Logout");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Show All promotion Of center");

                    break;
                case 2:
                    System.out.println("e");
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

    // adminCentreMenu create a rayon
    public static void adminCentreMenu(int idPersonne) {
        VilleController villeController = new VilleController();
        Ville ville = villeController.getVilleById(1);
        AdminCenterController n = new AdminCenterController();
        CentreController cC = new CentreController();
        Admincentre adminC = n.getAdminCentreByPersonne(idPersonne);
        Centre c = cC.getCentreByAdminC(adminC.getIdadmincentre());
        System.out.println("You are admin of " + ville.getNomville());
        while (true) {
            System.out.println("1- Create Responsable");
            System.out.println("2- Create Promotion");
            System.out.println("3- Logout");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Create Rayon");
                    CentreController centreController = new CentreController();
                    System.out.println(idPersonne+"idPersonne");
                    AdminCenterController adminCenterController = new AdminCenterController();

                    Admincentre adminCentre = adminCenterController.getAdminCentreByPersonne(idPersonne);
                    System.out.println(adminCentre.getIdadmincentre()+"idcentre");
                    Centre centre = centreController.getCentreByAdminC(adminCentre.getIdadmincentre());
                    PersonneController p = new PersonneController();
                    Personne personne = p.findPersonneById(idPersonne, "adminCentre");
                    System.out.println("You are admin of " + centre.getIdcentre());
                    String[] details = rayonProcced("Create Rayon", centre.getIdcentre());
                    break;
                case 2:
                    System.out.println("Create Promotion");
                    Categorie categorie = getCategorieDetails(c.getIdcentre());
                    // create promotion
                    String[] promotionDetails = getPromotionDetails(categorie.getIdcategorie());
                    break;
                case 3:
                    PersonneController personneController = new PersonneController();
                    personneController.logout("adminCentre");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

    // rayonProcced
    public static String[] rayonProcced(String title,int idCentre) {
        System.out.println("*** " + title + " ***");
        System.out.println("Select Centre");
        String souTitle = "Create";
        CentreController centreController = new CentreController();
        CategorieController categorieController = new CategorieController();
        List<Categorie> categories = categorieController.getAllCategoriesByCentre(idCentre,"");
        System.out.println("Categories List");
        for(int i = 0; i < categories.size(); i++) {
            System.out.println(i + 1 + " - " + categories.get(i).getNom());
        }
        Sout.sout("yellow", "0 - to add new Category");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                System.out.println("Enter The Category Name");
                Scanner s = new Scanner(System.in);
                String categoryName = s.nextLine();
                //int id  = categorieController.createCategorie(categoryName, idCentre);
                Sout.sout("green", "Category Added Successfully");
                rayonProcced(title, idCentre);
            default:

        }
        Sout.sout("green", "You Selected Category : " + categories.get(choice - 1).getNom());
        createResponsable(categories.get(choice - 1).getIdcategorie(), souTitle,idCentre);
        return new String[]{};


    }

    // createResponsable
    public static void createResponsable(int idCategorie, String souTitle,int idCentre) {
        System.out.println("*** " + souTitle + " Responsable ***");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Responsable Name");
        String fullname = sc.nextLine();
        System.out.println("Enter The Responsable Email");
        String email = sc.nextLine();
        System.out.println("Enter The Responsable Password");
        String password = sc.nextLine();
        if (fullname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Sout.sout("red", "All fields are required");
        } else {
            PersonneController personneController = new PersonneController();
            int idPersonne = personneController.createPersonneDetails(fullname, email, password);
            ResponsableController responsableController = new ResponsableController();
            Responsable rs = responsableController.createResponsable(idPersonne, idCategorie,idCentre);
            Sout.sout("green", "Responsable Added Successfully");
        }
    }
    // getCategorieDetails create a promotion
    public static Categorie getCategorieDetails(int idCentre) {
        System.out.println("*** Create promotion ***");
        System.out.println("Select centre");
        CentreController centreController = new CentreController();
        CategorieController categorieController = new CategorieController();
        List<Categorie> categories = categorieController.getAllCategoriesByCentre(idCentre,"all");
        System.out.println("Categories List");
        for(int i = 0; i < categories.size(); i++) {
            System.out.println(i + 1 + " - " + categories.get(i).getNom());
        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        Sout.sout("green", "You Selected Category : " + categories.get(choice - 1).getNom());

        return categories.get(choice - 1);
    }

    // getPromotionDetails
    public static String[] getPromotionDetails(int categorieId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Promotion Name");
        String nom = sc.nextLine();
        System.out.println("Enter The Promotion Description");
        String description = sc.nextLine();
        System.out.println("Enter The Promotion Start Date");
        String startDate = sc.nextLine();
        System.out.println("Enter The Promotion End Date");
        String endDate = sc.nextLine();
        System.out.println("Enter The Promotion Discount");
        String discount = sc.nextLine();
        if (nom.isEmpty() || description.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || discount.isEmpty()) {
            Sout.sout("red", "All fields are required");
        } else {
            PromotionController promotionController = new PromotionController();

            Promotion promotion = promotionController.createPromotion(nom, startDate, endDate, Double.parseDouble(discount),categorieId);
            Sout.sout("green", "Promotion Added Successfully");
        }
        return new String[]{};
    }

    // responsableMenu view a promotion of a category and validate it (in time 09-12 and 14-17)
    public static void responsableMenu(int idPersonne) {
        System.out.println("*** Responsable Menu ***");
        System.out.println(idPersonne);

        // get categorie by responsable
        ResponsableController responsableController = new ResponsableController();
        Responsable responsable = responsableController.getResponsableByPersonne(idPersonne);
        CategorieController cat = new CategorieController();
        Categorie categorie = cat.getCategorieByResponsable(responsable.getIdresponsable());
        System.out.println("Categorie : " + categorie.getNom());


        // get promotion by categorie
        PromotionController promotionController = new PromotionController();
        Promotion promotion = promotionController.getPromotionByCategorie(categorie.getIdcategorie());
        if (promotion == null)
            Sout.sout("red", "No promotion for this category");
        else {
            Sout.sout("green", "Promotion : " + promotion.getNompromotion());
            Sout.sout("green", "Description : " + promotion.getRatio());
            Sout.sout("green", "Start Date : " + promotion.getStartdate());
            Sout.sout("green", "End Date : " + promotion.getEnddate());
            // ask for validation or not
            System.out.println("Do you want to validate this promotion ? (y/n)");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if (choice.equals("y")) {
                promotionController.validatePromotion(promotion.getIdpromotion());
                Sout.sout("green", "Promotion Validated Successfully");
            } else {
                Sout.sout("red", "Promotion Not Validated");
            }
        }



    }



}
