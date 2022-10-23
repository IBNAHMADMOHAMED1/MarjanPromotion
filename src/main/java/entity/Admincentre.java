package entity;

import jakarta.persistence.*;

@Entity
public class Admincentre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idadmincentre")
    private int idadmincentre;
    @Basic
    @Column(name = "personne_id")
    private Integer personneId;
    @Basic
    @Column(name = "idadminville")
    private Integer idadminville;

    public int getIdadmincentre() {
        return idadmincentre;
    }

    public void setIdadmincentre(int idadmincentre) {
        this.idadmincentre = idadmincentre;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public Integer getIdadminville() {
        return idadminville;
    }

    public void setIdadminville(Integer idadminville) {
        this.idadminville = idadminville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admincentre that = (Admincentre) o;

        if (idadmincentre != that.idadmincentre) return false;
        if (personneId != null ? !personneId.equals(that.personneId) : that.personneId != null) return false;
        if (idadminville != null ? !idadminville.equals(that.idadminville) : that.idadminville != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idadmincentre;
        result = 31 * result + (personneId != null ? personneId.hashCode() : 0);
        result = 31 * result + (idadminville != null ? idadminville.hashCode() : 0);
        return result;
    }
}
