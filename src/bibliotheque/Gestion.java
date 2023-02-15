package bibliotheque;

import java.time.LocalDate;

public class Gestion {
    public static void main(String[] args) {
        Auteur auteur=new Auteur("Oda","Echiro","Japonais");
        Livre livre=new Livre("One piece Tome 1",10, LocalDate.of(1997,12,24),10,"Français","Manga","FR 978-2-7654-0912-0",208,TypeLivre.ROMAN,"L'histoire d'un jeune homme nommé Luffy qui veut devenir le roi des pirates");
        addOuvrage(auteur, livre);
        Rayon rayon=new Rayon("M1","Manga");
        Exemplaire exemplaire=new Exemplaire("1","un peu usagé",livre);
        rayon.getLex().add(exemplaire);
        exemplaire.setRayon(rayon);
        Lecteur lecteur=new Lecteur(1,"Tonda","Noah",LocalDate.of(2002,6,3),"Houdeng-goegnies","noah.tonda@condorcet.be","0493412940");
        Location location=new Location(LocalDate.of(2023,2,2),LocalDate.of(2023,2,9),lecteur,exemplaire);
        lecteur.getLloc().add(location);
        exemplaire.getLloc().add(location);
        System.out.println(auteur);
        System.out.println(livre);
        suppOuvrage(auteur,livre);
        System.out.println(livre);
        System.out.println(rayon);
        System.out.println(exemplaire);
        System.out.println(lecteur);
        System.out.println(location);

    }
    public static void addOuvrage(Auteur auteur, Ouvrage ouvrage){
        auteur.getLouvrage().add(ouvrage);
        ouvrage.getLauteurs().add(auteur);
    }
    public static void suppOuvrage(Auteur auteur,Ouvrage ouvrage){
        ouvrage.getLauteurs().remove(auteur);
    }

}
