package bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Auteur {
    private  String nom,prenom;
    private String nationalite;
    private List<Ouvrage> louvrage = new ArrayList<>();

    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
    }
    public void addOuvrage(Ouvrage ouvrage){
        this.getLouvrage().add(ouvrage);
        ouvrage.getLauteurs().add(this);
    }
    public void suppOuvrage(Ouvrage ouvrage){
        ouvrage.getLauteurs().remove(this);
    }
    public void listerOuvrages(){
        // TODO: 16/02/2023 coder la methode listerOuvrages
    }
    public void listerOuvrages(TypeOuvrage to,TypeLivre tl){
        // TODO: 16/02/2023 coder la methode listerOuvrages
    }
    public void listerOuvrages(Ouvrage o){
    // TODO: 16/02/2023 coder la methode listerOuvrages et mettre genre en parametre a la place de Ouvrage
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public List<Ouvrage> getLouvrage() {
        return louvrage;
    }

    public void setLouvrage(List<Ouvrage> louvrage) {
        this.louvrage = louvrage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return Objects.equals(nom, auteur.nom) && Objects.equals(prenom, auteur.prenom) && Objects.equals(nationalite, auteur.nationalite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, nationalite);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nationalite='" + nationalite + '\'' +
                '}';
    }
}
