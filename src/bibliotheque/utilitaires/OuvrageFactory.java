package bibliotheque.utilitaires;


import bibliotheque.metier.Ouvrage;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public  abstract class OuvrageFactory {
   protected Scanner sc= new Scanner(System.in);
   public Ouvrage create() throws Exception {
       LocalDate dp=null;
       System.out.println("titre");
       String titre= sc.nextLine();
       System.out.println("age minimum");
       String ageMin= sc.nextLine();
       sc.skip("\n");
       int min = 0;
       try{
           min=Integer.parseInt(ageMin);
           if (min<0) throw new Exception("Veuillez entrer un nombre plus grand que 0");
       }
       catch (NumberFormatException e) {
           System.out.println("entrer un nombre valide");
       }
       catch (Exception e){
           System.out.println("une erreur est survenue : "+e.getMessage());
       }
       System.out.println("date de parution");
       try {
           dp = Utilitaire.lecDate();
       }
       catch (Exception e){
           System.out.println("une erreur est survenue : "+e.getMessage());
       }
       System.out.println("prix de location");
       double ploc = sc.nextDouble();
       sc.skip("\n");
       System.out.println("langue");
       String langue=sc.nextLine();
       System.out.println("genre");
       String genre=sc.nextLine();
       return addDetail(titre, min,dp,ploc, langue,  genre);
    }

    public abstract Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre) throws Exception;
}