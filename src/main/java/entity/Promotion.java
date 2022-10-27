package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Promotion implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpromotion")
    private int idpromotion;
    @Basic
    @Column(name = "categorie_id")
    private Integer categorieId;
    @Basic
    @Column(name = "nompromotion")
    private String nompromotion;
    @Basic
    @Column(name = "ratio")
    private Double ratio;
    @Basic
    @Column(name = "isaccepted")
    private Boolean isaccepted;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "startdate")
    private String startdate;
    @Basic
    @Column(name = "enddate")
    private String enddate;

    public int getIdpromotion() {
        return idpromotion;
    }

    public void setIdpromotion(int idpromotion) {
        this.idpromotion = idpromotion;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public String getNompromotion() {
        return nompromotion;
    }

    public void setNompromotion(String nompromotion) {
        this.nompromotion = nompromotion;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Boolean getIsaccepted() {
        return isaccepted;
    }

    public void setIsaccepted(Boolean isaccepted) {
        this.isaccepted = isaccepted;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (idpromotion != promotion.idpromotion) return false;
        if (categorieId != null ? !categorieId.equals(promotion.categorieId) : promotion.categorieId != null)
            return false;
        if (nompromotion != null ? !nompromotion.equals(promotion.nompromotion) : promotion.nompromotion != null)
            return false;
        if (ratio != null ? !ratio.equals(promotion.ratio) : promotion.ratio != null) return false;
        if (isaccepted != null ? !isaccepted.equals(promotion.isaccepted) : promotion.isaccepted != null) return false;
        if (createdAt != null ? !createdAt.equals(promotion.createdAt) : promotion.createdAt != null) return false;
        if (startdate != null ? !startdate.equals(promotion.startdate) : promotion.startdate != null) return false;
        if (enddate != null ? !enddate.equals(promotion.enddate) : promotion.enddate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpromotion;
        result = 31 * result + (categorieId != null ? categorieId.hashCode() : 0);
        result = 31 * result + (nompromotion != null ? nompromotion.hashCode() : 0);
        result = 31 * result + (ratio != null ? ratio.hashCode() : 0);
        result = 31 * result + (isaccepted != null ? isaccepted.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        return result;
    }
}
