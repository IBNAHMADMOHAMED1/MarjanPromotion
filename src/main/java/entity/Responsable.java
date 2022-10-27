package entity;

import jakarta.persistence.*;

@Entity
public class Responsable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idresponsable")
    private int idresponsable;
    @Basic
    @Column(name = "personne_id")
    private Integer personneId;
    @Basic
    @Column(name = "categorie_id")
    private Integer categorieId;
    @Basic
    @Column(name = "idcentre")
    private Integer idcentre;

    public int getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(int idresponsable) {
        this.idresponsable = idresponsable;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
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

        Responsable that = (Responsable) o;

        if (idresponsable != that.idresponsable) return false;
        if (personneId != null ? !personneId.equals(that.personneId) : that.personneId != null) return false;
        if (categorieId != null ? !categorieId.equals(that.categorieId) : that.categorieId != null) return false;
        if (idcentre != null ? !idcentre.equals(that.idcentre) : that.idcentre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idresponsable;
        result = 31 * result + (personneId != null ? personneId.hashCode() : 0);
        result = 31 * result + (categorieId != null ? categorieId.hashCode() : 0);
        result = 31 * result + (idcentre != null ? idcentre.hashCode() : 0);
        return result;
    }
}
