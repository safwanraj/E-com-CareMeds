/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author safwan
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByPrId", query = "SELECT p FROM Products p WHERE p.prId = :prId"),
    @NamedQuery(name = "Products.findByPrName", query = "SELECT p FROM Products p WHERE p.prName = :prName"),
    @NamedQuery(name = "Products.findByPrStatus", query = "SELECT p FROM Products p WHERE p.prStatus = :prStatus"),
    @NamedQuery(name = "Products.findByPrPrice", query = "SELECT p FROM Products p WHERE p.prPrice = :prPrice"),
    @NamedQuery(name = "Products.findByPrQty", query = "SELECT p FROM Products p WHERE p.prQty = :prQty")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PrId")
    private Integer prId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PrName")
    private String prName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PrStatus")
    private String prStatus;
    @Basic(optional = false)
    @NotNull
   
    @Column(name = "PrPrice")
    private Integer prPrice;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "PrQty")
    private String prQty;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "PrDesc")
    private String prDesc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "PrImgpath")
    private String prImgpath;
    @JoinColumn(name = "BrId", referencedColumnName = "brand_id")
    @ManyToOne(optional = false)
    private Brand brId;
    @JoinColumn(name = "CatId", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Category catId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Collection<TblOrderdetail> tblOrderdetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prId")
    private Collection<TblCart> tblCartCollection;

    public Products() {
    }

    public Products(Integer prId) {
        this.prId = prId;
    }

    public Products(Integer prId, String prName, String prStatus, Integer prPrice, String prQty, String prDesc, String prImgpath) {
        this.prId = prId;
        this.prName = prName;
        this.prStatus = prStatus;
        this.prPrice = prPrice;
        this.prQty = prQty;
        this.prDesc = prDesc;
        this.prImgpath = prImgpath;
    }

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public String getPrStatus() {
        return prStatus;
    }

    public void setPrStatus(String prStatus) {
        this.prStatus = prStatus;
    }

    public Integer getPrPrice() {
        return prPrice;
    }

    public void setPrPrice(Integer prPrice) {
        this.prPrice = prPrice;
    }

    public String getPrQty() {
        return prQty;
    }

    public void setPrQty(String prQty) {
        this.prQty = prQty;
    }

    public String getPrDesc() {
        return prDesc;
    }

    public void setPrDesc(String prDesc) {
        this.prDesc = prDesc;
    }

    public String getPrImgpath() {
        return prImgpath;
    }

    public void setPrImgpath(String prImgpath) {
        this.prImgpath = prImgpath;
    }

    public Brand getBrId() {
        return brId;
    }

    public void setBrId(Brand brId) {
        this.brId = brId;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }
    @JsonbTransient
    public Collection<TblOrderdetail> getTblOrderdetailCollection() {
        return tblOrderdetailCollection;
    }

    public void setTblOrderdetailCollection(Collection<TblOrderdetail> tblOrderdetailCollection) {
        this.tblOrderdetailCollection = tblOrderdetailCollection;
    }

    @JsonbTransient
    public Collection<TblCart> getTblCartCollection() {
        return tblCartCollection;
    }

    public void setTblCartCollection(Collection<TblCart> tblCartCollection) {
        this.tblCartCollection = tblCartCollection;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prId != null ? prId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.prId == null && other.prId != null) || (this.prId != null && !this.prId.equals(other.prId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Products[ prId=" + prId + " ]";
    }
    
}
