package entity;

import jakarta.persistence.*;

@Entity
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproduit")
    private int idproduit;
    @Basic
    @Column(name = "nomproduit")
    private String nomproduit;
    @Basic
    @Column(name = "idcategorie")
    private Integer idcategorie;
    @Basic
    @Column(name = "prix")
    private Double prix;

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (idproduit != produit.idproduit) return false;
        if (nomproduit != null ? !nomproduit.equals(produit.nomproduit) : produit.nomproduit != null) return false;
        if (idcategorie != null ? !idcategorie.equals(produit.idcategorie) : produit.idcategorie != null) return false;
        if (prix != null ? !prix.equals(produit.prix) : produit.prix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idproduit;
        result = 31 * result + (nomproduit != null ? nomproduit.hashCode() : 0);
        result = 31 * result + (idcategorie != null ? idcategorie.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        return result;
    }
}
