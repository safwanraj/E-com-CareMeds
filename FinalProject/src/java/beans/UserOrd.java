/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import clients.OrderClient;
import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Category;
import entity.Products;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author safwan
 */
@Named(value = "userOrd")
@SessionScoped
public class UserOrd implements Serializable{

    /**
     * Creates a new instance of UserOrd
     */
    
    
      OrderClient arc = new OrderClient();
    @EJB AdminBeanLocal al;
    @EJB UserBeanLocal ul;
    DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String datetime = df.format(today);
    Response res;
    Collection<Products> prds;
    //Collection<TblModel> model;
  
    public Collection<Products> getProducts() {
        return prds;
    }

    public void setParts(Collection<Products> prds) {
        this.prds = prds;
    }

//    public Collection<TblModel> getModel() {
//        return model;
//    }
//
//    public void setModel(Collection<TblModel> model) {
//        this.model = model;
//    }
//    Collection<TblCompany> company;
    GenericType<Collection<Products>> gPrds = new GenericType<Collection<Products>>(){
    };  
    Integer prdId, price,catid,brid;
    String prname,prstatus,prqty,prdesc,primage;

    public Integer getPrdId() {
        return prdId;
    }

    public void setPrdId(Integer prdId) {
        this.prdId = prdId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public String getPrstatus() {
        return prstatus;
    }

    public void setPrstatus(String prstatus) {
        this.prstatus = prstatus;
    }

    public String getPrqty() {
        return prqty;
    }

    public void setPrqty(String prqty) {
        this.prqty = prqty;
    }

    public String getPrimage() {
        return primage;
    }

    public void setPrimage(String primage) {
        this.primage = primage;
    }
  
   
    public Collection<Products> allProducts(){
//        res =   arc.getAllParts(Response.class);
//        parts = res.readEntity(gParts);
//        return parts;
        return this.ul.activeProducts();
    }
    
    public Collection<Category> allCats(){
        return this.al.getAllCategory();
    }
    public UserOrd() {
    }
    
}
