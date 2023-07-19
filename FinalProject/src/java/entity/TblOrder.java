/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author safwan
 */
@Entity
@Table(name = "tbl_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOrder.findAll", query = "SELECT t FROM TblOrder t"),
    @NamedQuery(name = "TblOrder.findByOrderId", query = "SELECT t FROM TblOrder t WHERE t.orderId = :orderId"),
    @NamedQuery(name = "TblOrder.findByTotalPayment", query = "SELECT t FROM TblOrder t WHERE t.totalPayment = :totalPayment"),
    @NamedQuery(name = "TblOrder.findByIspay", query = "SELECT t FROM TblOrder t WHERE t.ispay = :ispay"),
    @NamedQuery(name = "TblOrder.findByPaymode", query = "SELECT t FROM TblOrder t WHERE t.paymode = :paymode"),
    @NamedQuery(name = "TblOrder.findByPincode", query = "SELECT t FROM TblOrder t WHERE t.pincode = :pincode"),
     @NamedQuery(name = "TblOrder.findByUserId", query = "SELECT t FROM TblOrder t WHERE t.userId = :userId"),
    @NamedQuery(name = "TblOrder.findByStatus", query = "SELECT t FROM TblOrder t WHERE t.status = :status")})
public class TblOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
//    @Size(min = 1, max = 30)
    @Column(name = "total_payment")
    private int totalPayment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ispay")
    private String ispay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "paymode")
    private String paymode;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "addressline1")
    private String addressline1;
    @Lob
    @Size(max = 65535)
    @Column(name = "addressline2")
    private String addressline2;
    @Lob
    @Size(max = 65535)
    @Column(name = "landmark")
    private String landmark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pincode")
    private int pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "order_datetime")
    private String orderDatetime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "updates_at")
    private String updatesAt;
    @JoinColumn(name = "user_id", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Users userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOrder")
    private Collection<TblOrderdetail> tblOrderdetailList;

    public TblOrder() {
    }

    public TblOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public TblOrder(Integer orderId, int totalPayment, String ispay, String paymode, String addressline1, int pincode, String status, String orderDatetime, String updatesAt) {
        this.orderId = orderId;
        this.totalPayment = totalPayment;
        this.ispay = ispay;
        this.paymode = paymode;
        this.addressline1 = addressline1;
        this.pincode = pincode;
        this.status = status;
        this.orderDatetime = orderDatetime;
        this.updatesAt = updatesAt;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getIspay() {
        return ispay;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getUpdatesAt() {
        return updatesAt;
    }

    public void setUpdatesAt(String updatesAt) {
        this.updatesAt = updatesAt;
    }
     public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

//    @XmlTransient
   // @JsonbTransient
    @JsonbTransient
    public Collection<TblOrderdetail> getTblOrderdetailList() {
        return tblOrderdetailList;
    }

    public void setTblOrderdetailList(Collection<TblOrderdetail> tblOrderdetailList) {
        this.tblOrderdetailList = tblOrderdetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrder)) {
            return false;
        }
        TblOrder other = (TblOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblOrder[ orderId=" + orderId + " ]";
    }
    
}
