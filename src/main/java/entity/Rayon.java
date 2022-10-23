package entity;

import jakarta.persistence.*;

@Entity
public class Rayon {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrayon")
    private int idrayon;
    @Basic
    @Column(name = "personne_id")
    private Integer personneId;
    @Basic
    @Column(name = "idadminc")
    private Integer idadminc;
    @Basic
    @Column(name = "idcategorie")
    private Integer idcategorie;
    @Basic
    @Column(name = "idcentre")
    private Integer idcentre;

    public int getIdrayon() {
        return idrayon;
    }

    public void setIdrayon(int idrayon) {
        this.idrayon = idrayon;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public Integer getIdadminc() {
        return idadminc;
    }

    public void setIdadminc(Integer idadminc) {
        this.idadminc = idadminc;
    }

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
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

        Rayon rayon = (Rayon) o;

        if (idrayon != rayon.idrayon) return false;
        if (personneId != null ? !personneId.equals(rayon.personneId) : rayon.personneId != null) return false;
        if (idadminc != null ? !idadminc.equals(rayon.idadminc) : rayon.idadminc != null) return false;
        if (idcategorie != null ? !idcategorie.equals(rayon.idcategorie) : rayon.idcategorie != null) return false;
        if (idcentre != null ? !idcentre.equals(rayon.idcentre) : rayon.idcentre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrayon;
        result = 31 * result + (personneId != null ? personneId.hashCode() : 0);
        result = 31 * result + (idadminc != null ? idadminc.hashCode() : 0);
        result = 31 * result + (idcategorie != null ? idcategorie.hashCode() : 0);
        result = 31 * result + (idcentre != null ? idcentre.hashCode() : 0);
        return result;
    }
}
