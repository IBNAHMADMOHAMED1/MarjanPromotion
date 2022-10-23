package entity;

import jakarta.persistence.*;

@Entity
public class Admingeneral {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idadmingeneral")
    private int idadmingeneral;
    @Basic
    @Column(name = "personne_id")
    private Integer personneId;

    public int getIdadmingeneral() {
        return idadmingeneral;
    }

    public void setIdadmingeneral(int idadmingeneral) {
        this.idadmingeneral = idadmingeneral;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admingeneral that = (Admingeneral) o;

        if (idadmingeneral != that.idadmingeneral) return false;
        if (personneId != null ? !personneId.equals(that.personneId) : that.personneId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idadmingeneral;
        result = 31 * result + (personneId != null ? personneId.hashCode() : 0);
        return result;
    }
}
