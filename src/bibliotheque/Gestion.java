package bibliotheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {


    private static List<Auteur> laut = new ArrayList<>();
    private static List<Lecteur> llect = new ArrayList<>();
    private static List<Ouvrage> louv = new ArrayList<>();
    private static List<Exemplaire> lex = new ArrayList<>();
    private static List<Rayon> lrayon = new ArrayList<>();
    private static List<Location> lloc = new ArrayList<>();


    public static void populate() {
        Auteur a = new Auteur("Oda", "Echiro", "Japonais");
        laut.add(a);

        Livre l = new Livre("One piece Tome 1", 10, LocalDate.of(1997, 12, 24), 10, "Français", "Manga", "FR 978-2-7654-0912-0", 208, TypeLivre.ROMAN, "L'histoire d'un jeune homme nommé Luffy qui veut devenir le roi des pirates");
        louv.add(l);

        a.addOuvrage(l);

        a = new Auteur("Spielberg", "Steven", "USA");
        laut.add(a);

        DVD d = new DVD("AI", 12, LocalDate.of(2000, 10, 1), 2.50, "anglais", "SF", 4578l, "120 min", (byte) 2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        a.addOuvrage(d);

        a = new Auteur("Kubrick", "Stanley", "GB");
        laut.add(a);

        a.addOuvrage(d);

        CD c = new CD("The Compil 2023", 0, LocalDate.of(2023, 1, 1), 2, "English", "POP", 1245, (byte) 20, "100 min");
        louv.add(c);

        Rayon r = new Rayon("r12", "aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12", "état neuf", l);
        lex.add(e);

        r.addExemplaire(e);
        r = new Rayon("r45", "science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12", "griffé", d);
        lex.add(e);

        r.addExemplaire(e);

        Lecteur lec = new Lecteur(1, "Dupont", "Jean", LocalDate.of(2000, 1, 4), "Mons", "jean.dupont@mail.com", "0458774411");
        llect.add(lec);

        Location loc = new Location(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 3, 1), lec, e);
        lloc.add(loc);

        lec = new Lecteur(1, "Durant", "Aline", LocalDate.of(1980, 10, 10), "Binche", "aline.durant@mail.com", "045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023, 2, 5), LocalDate.of(2023, 3, 5), lec, e);
        lloc.add(loc);
    }

    public static void main(String[] args) {
        int choix;
        populate();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.Auteurs\n2.Ouvrages\n8.Fin");
            choix=sc.nextInt();
            switch (choix){
                case 1->gestAuteurs();
                case 2->gestOuvrages();
                case 3->gestLecteur();
                case 4->gestRayon();
                case 5->gestExemplaire();
                case 6->gestLouer();
                case 7->gestRendre();
                case 8-> System.out.println("au revoir");
            }
        }while(choix!=8);

    }

    private static void gestLouer() {
        // TODO: 16/02/2023 coder gestLouer
    }

    private static void gestExemplaire() {
        // TODO: 16/02/2023 gestExemplaire
    }

    private static void gestRayon() {
        // TODO: 16/02/2023 gestRayon
    }

    private static void gestLecteur() {
        // TODO: 16/02/2023 gestLecteur
    }

    private static void gestRendre() {
        // TODO: 16/02/2023 gestRendre
    }

    private static void gestOuvrages() {
        // TODO: 16/02/2023 gestOuvrages
    }

    private static void gestAuteurs() {
        // TODO: 16/02/2023 gestAuteurs
    }
}
