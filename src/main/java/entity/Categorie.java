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
    @Basic
    @Column(name = "idcentre")
    private Integer idcentre;

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

    public Integer getIdcentre() {
        return idcentre;
    }

    public void setIdcentre(Integer idcentre) {
        this.idcentre = idcentre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        if (idcategorie != categorie.idcategorie) return false;
        if (nom != null ? !nom.equals(categorie.nom) : categorie.nom != null) return false;
        if (idcentre != null ? !idcentre.equals(categorie.idcentre) : categorie.idcentre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategorie;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (idcentre != null ? idcentre.hashCode() : 0);
        return result;
    }
}
