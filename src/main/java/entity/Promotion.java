package entity;

import jakarta.persistence.*;

@Entity
public class Promotion {
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpromotion;
        result = 31 * result + (categorieId != null ? categorieId.hashCode() : 0);
        result = 31 * result + (nompromotion != null ? nompromotion.hashCode() : 0);
        result = 31 * result + (ratio != null ? ratio.hashCode() : 0);
        result = 31 * result + (isaccepted != null ? isaccepted.hashCode() : 0);
        return result;
    }
}
