/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.*;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Safwan
 */
@Named(value = "userorderbean")
@SessionScoped
public class UserOrderBean implements Serializable {
    @EJB UserBeanLocal ul;
    @EJB AdminBeanLocal al;
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    HttpSession session = (HttpSession) ec.getSession(true);
    String userName = (String) session.getAttribute("User");
    
    /////////////////////////////////////////Change UserId///////////////////////////////////////////////////////
    
    Integer userId = 12 ;
   // Integer userId = al.getUserId(userName);
//    Integer userId=al.
    Integer prdId,qty=1,total,pincode;
    TblOrder currentOrder;
    String username = (String) session.getAttribute("User");
    public TblOrder getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(TblOrder currentOrder) {
        this.currentOrder = currentOrder;
    }
    

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
   
    String state,address1,address2,landmark;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    
    public String addToCart(Integer prId){
        if(session.getAttribute("User")!=null){
//           System.out.println(userName);

//        TblCart tc= new TblCart();
//        
//        tc.setPrdId(new Products(prId));
//        tc.setUserId(new Users(userId));
//        tc.setQty(qty);
//        tc.setCreatedAt(datetime);
//        tc.setUpdatedAt(datetime);
            this.ul.addToCart(prId, userId, qty, datetime, datetime);
            return "Usercart.xhtml"; 
        }
        else
        {
            return "Login.xhtml?faces-redirect=true";
        }
        
    }

    public Integer getProductId() {
        return prdId;
    }

    public void setProductId(Integer prdId) {
        this.prdId = prdId;
    }
    
    public Collection<TblCart> viewCart(){
        total=0;
        return this.ul.viewCart(userId);
    }
    
    
    
    public String placeOrder(){
        this.ul.placeOrder(userId,total, "N", "COD", address1, address2, landmark, pincode, "Pending", datetime, datetime);
       // return "userOrders?faces-redirect=true";
       return "Userords.xhtml";
    }
    
    public Collection<TblOrder> allOrders(){
        return this.ul.getUserOrders(userId);
    }
    
    public String removeProduct(Integer cartId, Integer prdId){
        this.ul.removeProduct(cartId, prdId, userId, qty, datetime);
        return "";
    }
    
    public Collection<TblOrderdetail> orderDetails(Integer orderId){
        total = 0;
        return this.ul.orderDetails(orderId);
    }
    
    public String getDetails(){
        return "Userordid.jsf?faces-redirect=true";
    }
    public UserOrderBean() {
    }
    
}
