package entity;

import jakarta.persistence.*;

@Entity
public class Adminville {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idadminville")
    private int idadminville;
    @Basic
    @Column(name = "personne_id")
    private Integer personneId;
    @Basic
    @Column(name = "idadming")
    private Integer idadming;

    public int getIdadminville() {
        return idadminville;
    }

    public void setIdadminville(int idadminville) {
        this.idadminville = idadminville;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public Integer getIdadming() {
        return idadming;
    }

    public void setIdadming(Integer idadming) {
        this.idadming = idadming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adminville that = (Adminville) o;

        if (idadminville != that.idadminville) return false;
        if (personneId != null ? !personneId.equals(that.personneId) : that.personneId != null) return false;
        if (idadming != null ? !idadming.equals(that.idadming) : that.idadming != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idadminville;
        result = 31 * result + (personneId != null ? personneId.hashCode() : 0);
        result = 31 * result + (idadming != null ? idadming.hashCode() : 0);
        return result;
    }
}
