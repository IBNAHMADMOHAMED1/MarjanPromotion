package entity;

import jakarta.persistence.*;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategorie")
    private int idcategorie;
    @Basic
    @Column(name = "nom")
    private String nom;

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        if (idcategorie != categorie.idcategorie) return false;
        if (nom != null ? !nom.equals(categorie.nom) : categorie.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategorie;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

}
