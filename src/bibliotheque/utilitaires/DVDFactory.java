package bibliotheque.utilitaires;

import bibliotheque.metier.DVD;
import bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DVDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre){
        System.out.println("code : ");
        long code= sc.nextLong();
        System.out.println("durée totale :");
        LocalTime dureeTotale=Utilitaire.lecTime();
        System.out.println("nombre bonus :");
        byte nbreBonus= sc.nextByte();
        DVD dvd =new DVD(titre,ageMin,dateParution,prixLocation,langue,genre,code,dureeTotale,nbreBonus);
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
