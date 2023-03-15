package bibliotheque.utilitaires;

import bibliotheque.metier.DVD;
import bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DVDFactoryBeta {
    protected Scanner sc= new Scanner(System.in);
    public Ouvrage create() {

        System.out.println("titre");
        String titre= sc.nextLine();
        System.out.println("age minimum");
        int ageMin= sc.nextInt();
        sc.skip("\n");
        System.out.println("date de parution");
        LocalDate dp= Utilitaire.lecDate();
        System.out.println("prix de location");
        double ploc = sc.nextDouble();
        sc.skip("\n");
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();

        //détails propres à la classe DVD
        System.out.println("code : ");
        long code= sc.nextLong();
        System.out.println("durée totale :");
        LocalTime dureeTotale=Utilitaire.lecTime();
        System.out.println("nombre bonus :");
        byte nbreBonus= sc.nextByte();
        DVD dvd =new DVD(titre,ageMin,dp,ploc,langue,genre,code,dureeTotale,nbreBonus);
        System.out.println("autres langues");
        List<String> langues = new ArrayList<>(Arrays.asList("anglais","français","italien","allemand","fin"));
        int choix;
        do{
            boolean flag=false;
            choix=Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            if (dvd.getAutresLangues().isEmpty()){
                if (langues.get(choix-1).equals(langue)){
                    System.out.println("il s'agit de la langue d'origine");
                }
                else dvd.getAutresLangues().add(langues.get(choix-1));

            }
            else{
                for (String l : dvd.getAutresLangues()){
                    if (langues.get(choix-1).equals(langue)){
                        System.out.println("il s'agit de la langue d'origine");
                    }
                    else if (l.equals(langues.get(choix - 1))) {
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    System.out.println("langue déjà séléctionnée");
                }
                else {
                    dvd.getAutresLangues().add(langues.get(choix-1));
                }
            }
        }while(true);
        System.out.println("sous-titres");
        do{
            boolean flag=false;
            choix=Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            if (dvd.getSousTitres().isEmpty()){
                dvd.getSousTitres().add(langues.get(choix-1));
            }
            else{
                for (String s : dvd.getSousTitres()){
                    if (s.equals(langues.get(choix - 1))) {
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    System.out.println("langue déjà séléctionnée");
                }
                else {
                    dvd.getSousTitres().add(langues.get(choix-1));
                }
            }
        }while(true);
        return dvd;
    }
}
