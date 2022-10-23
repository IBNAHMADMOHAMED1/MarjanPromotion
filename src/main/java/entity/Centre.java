package entity;

import jakarta.persistence.*;

@Entity
public class Centre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcentre")
    private int idcentre;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "idville")
    private Integer idville;
    @Basic
    @Column(name = "idadminc")
    private Integer idadminc;

    public int getIdcentre() {
        return idcentre;
    }

    public void setIdcentre(int idcentre) {
        this.idcentre = idcentre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getIdville() {
        return idville;
    }

    public void setIdville(Integer idville) {
        this.idville = idville;
    }

    public Integer getIdadminc() {
        return idadminc;
    }

    public void setIdadminc(Integer idadminc) {
        this.idadminc = idadminc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Centre centre = (Centre) o;

        if (idcentre != centre.idcentre) return false;
        if (nom != null ? !nom.equals(centre.nom) : centre.nom != null) return false;
        if (idville != null ? !idville.equals(centre.idville) : centre.idville != null) return false;
        if (idadminc != null ? !idadminc.equals(centre.idadminc) : centre.idadminc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcentre;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (idville != null ? idville.hashCode() : 0);
        result = 31 * result + (idadminc != null ? idadminc.hashCode() : 0);
        return result;
    }
}
