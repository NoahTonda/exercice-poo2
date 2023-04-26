package bibliotheque.utilitaires;

import bibliotheque.metier.CD;
import bibliotheque.metier.Ouvrage;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre)throws Exception{
        LocalTime dureeTotale = null;
        System.out.println("code : ");
        long code= sc.nextLong();
        byte nbrePlages;
        boolean flag=false;

        System.out.println("nombre de plages :");
        nbrePlages= sc.nextByte();sc.skip("\n");
        try{
            if (nbrePlages<0) throw new Exception("Veuillez entrer un nombre positif");
        }
        catch (Exception e){
            System.out.println("une erreur est survenue : "+e.getMessage());
            flag=true;
        }
        boolean flag2=false;
        try {
            System.out.println("durée en H M S : ");
            dureeTotale = Utilitaire.lecTime();
        }
        catch (DateTimeException e){
                System.out.println("Format de date incorrect");
                flag2=true;
            }

        CD cd =new CD(titre,ageMin,dateParution,prixLocation,langue,genre,code,nbrePlages,dureeTotale);
        return cd;
    }
}
