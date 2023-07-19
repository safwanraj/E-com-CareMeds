/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author safwan
 */
@Entity
@Table(name = "tbl_orderdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOrderdetail.findAll", query = "SELECT t FROM TblOrderdetail t"),
    @NamedQuery(name = "TblOrderdetail.findByOrderId", query = "SELECT t FROM TblOrderdetail t WHERE t.tblOrderdetailPK.orderId = :orderId"),
    @NamedQuery(name = "TblOrderdetail.findByPrdId", query = "SELECT t FROM TblOrderdetail t WHERE t.tblOrderdetailPK.prdId = :prdId"),
    @NamedQuery(name = "TblOrderdetail.findByQty", query = "SELECT t FROM TblOrderdetail t WHERE t.qty = :qty")})
public class TblOrderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblOrderdetailPK tblOrderdetailPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "created_at")
    private String createdAt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "updated_at")
    private String updatedAt;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblOrder tblOrder;
     
    @JoinColumn(name = "prd_id", referencedColumnName = "PrId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;

    public TblOrderdetail() {
    }

    public TblOrderdetail(TblOrderdetailPK tblOrderdetailPK) {
        this.tblOrderdetailPK = tblOrderdetailPK;
    }

    public TblOrderdetail(TblOrderdetailPK tblOrderdetailPK, int qty, String createdAt, String updatedAt) {
        this.tblOrderdetailPK = tblOrderdetailPK;
        this.qty = qty;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TblOrderdetail(int orderId, int prdId) {
        this.tblOrderdetailPK = new TblOrderdetailPK(orderId, prdId);
    }

    public TblOrderdetailPK getTblOrderdetailPK() {
        return tblOrderdetailPK;
    }

    public void setTblOrderdetailPK(TblOrderdetailPK tblOrderdetailPK) {
        this.tblOrderdetailPK = tblOrderdetailPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TblOrder getTblOrder() {
        return tblOrder;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
    

    public void setTblOrder(TblOrder tblOrder) {
        this.tblOrder = tblOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblOrderdetailPK != null ? tblOrderdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrderdetail)) {
            return false;
        }
        TblOrderdetail other = (TblOrderdetail) object;
        if ((this.tblOrderdetailPK == null && other.tblOrderdetailPK != null) || (this.tblOrderdetailPK != null && !this.tblOrderdetailPK.equals(other.tblOrderdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblOrderdetail[ tblOrderdetailPK=" + tblOrderdetailPK + " ]";
    }
    
}
