package entity;

import jakarta.persistence.*;

@Entity
public class Stock {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idstock")
    private int idstock;
    @Basic
    @Column(name = "stockname")
    private String stockname;
    @Basic
    @Column(name = "idcentre")
    private Integer idcentre;
    @Basic
    @Column(name = "idproduit")
    private Integer idproduit;
    @Basic
    @Column(name = "quantite")
    private Integer quantite;

    public int getIdstock() {
        return idstock;
    }

    public void setIdstock(int idstock) {
        this.idstock = idstock;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public Integer getIdcentre() {
        return idcentre;
    }

    public void setIdcentre(Integer idcentre) {
        this.idcentre = idcentre;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (idstock != stock.idstock) return false;
        if (stockname != null ? !stockname.equals(stock.stockname) : stock.stockname != null) return false;
        if (idcentre != null ? !idcentre.equals(stock.idcentre) : stock.idcentre != null) return false;
        if (idproduit != null ? !idproduit.equals(stock.idproduit) : stock.idproduit != null) return false;
        if (quantite != null ? !quantite.equals(stock.quantite) : stock.quantite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idstock;
        result = 31 * result + (stockname != null ? stockname.hashCode() : 0);
        result = 31 * result + (idcentre != null ? idcentre.hashCode() : 0);
        result = 31 * result + (idproduit != null ? idproduit.hashCode() : 0);
        result = 31 * result + (quantite != null ? quantite.hashCode() : 0);
        return result;
    }
}
