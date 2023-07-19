/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author safwan
 */
@Embeddable
public class TblOrderdetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_id")
    private int prdId;

    public TblOrderdetailPK() {
    }

    public TblOrderdetailPK(int orderId, int prdId) {
        this.orderId = orderId;
        this.prdId = prdId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPrdId() {
        return prdId;
    }

    public void setPrdId(int prdId) {
        this.prdId = prdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderId;
        hash += (int) prdId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrderdetailPK)) {
            return false;
        }
        TblOrderdetailPK other = (TblOrderdetailPK) object;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.prdId != other.prdId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblOrderdetailPK[ orderId=" + orderId + ", prdId=" + prdId + " ]";
    }
    
}
