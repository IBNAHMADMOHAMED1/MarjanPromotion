package entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Ville implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idville")
    private int idville;
    @Basic
    @Column(name = "nomville")
    private String nomville;
    @Basic
    @Column(name = "idadminv")
    private Integer idadminv;

    public int getIdville() {
        return idville;
    }

    public void setIdville(int idville) {
        this.idville = idville;
    }

    public String getNomville() {
        return nomville;
    }

    public void setNomville(String nomville) {
        this.nomville = nomville;
    }

    public Integer getIdadminv() {
        return idadminv;
    }

    public void setIdadminv(Integer idadminv) {
        this.idadminv = idadminv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ville ville = (Ville) o;

        if (idville != ville.idville) return false;
        if (nomville != null ? !nomville.equals(ville.nomville) : ville.nomville != null) return false;
        if (idadminv != null ? !idadminv.equals(ville.idadminv) : ville.idadminv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idville;
        result = 31 * result + (nomville != null ? nomville.hashCode() : 0);
        result = 31 * result + (idadminv != null ? idadminv.hashCode() : 0);
        return result;
    }
}
