/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import clients.OrderClient;
import ejb.AdminBeanLocal;
import entity.TblOrder;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.util.LangUtils;

/**
 *
 * @author vicky
 */
@Named(value = "orderBean")
@SessionScoped
public class OrderBean implements Serializable {
    @EJB
    AdminBeanLocal abl;

    OrderClient client = new OrderClient();
   // Response res;
    //Collection<TblOrder> orders = new ArrayList<TblOrder>();
    Collection<TblOrder> orders;
    Collection<TblOrder> filteredorder;
    TblOrder selectedorder;
    //GenericType<Collection<TblOrder>> gorders = new GenericType<Collection<TblOrder>>(){};
    String orderstatus;

    public Collection<TblOrder> getOrders() {
        
           Response res = client.getAllOrders(Response.class);
        ArrayList<TblOrder> ord = new ArrayList<TblOrder>();
        GenericType<Collection<TblOrder>> genericType = new GenericType<Collection<TblOrder>>() {
        };
        ord = (ArrayList<TblOrder>) res.readEntity(genericType);
       orders = ord;
        return orders;
    }

    public void setOrders(Collection<TblOrder> orders) {
        this.orders = orders;
    }
    
    public OrderBean() {
    }
    
//    @PostConstruct
//    public void init(){
////        res = client.getAllOrders(Response.class);
////        orders = res.readEntity(gorders);
////         res = client.getAllOrders(Response.class);
////        ArrayList<TblOrder> ord = new ArrayList<TblOrder>();
////        GenericType<Collection<TblOrder>> genericType = new GenericType<Collection<TblOrder>>() {
////        };
////        ord = (ArrayList<TblOrder>) res.readEntity(genericType);
////       orders = ord;
//    }

    public TblOrder getSelectedorder() {
        return selectedorder;
    }

    public void setSelectedorder(TblOrder selectedorder) {
        this.selectedorder = selectedorder;
    }
    
    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }
    
    public Collection<TblOrder> getFilteredorder() {
        return filteredorder;
    }

    public void setFilteredorder(Collection<TblOrder> filteredorder) {
        this.filteredorder = filteredorder;
    }

    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        TblOrder order = (TblOrder) value;
        return order.getOrderId().toString().toLowerCase().contains(filtertext)
               
                || order.getUserId().getFirstName().toLowerCase().contains(filtertext)
                || order.getPaymode().toLowerCase().contains(filtertext)
                || order.getStatus().toLowerCase().contains(filtertext);
    }
    
    public Collection<TblOrder> vieworders(){
//        Response res = client.getAllOrders(Response.class);
//        ArrayList<TblOrder> ord = new ArrayList<TblOrder>();
//        GenericType<Collection<TblOrder>> genericType = new GenericType<Collection<TblOrder>>() {
//        };
//        ord = (ArrayList<TblOrder>) res.readEntity(genericType);
//       orders = ord;
//        return orders;
    return abl.getAllOrders();
    }
    
    public String redirecttoupdate(){
        return "Updateord.xhtml?faces-redirect=true";
    }
    
    public String changestatus(){
        Date currenttimestamp;
        currenttimestamp = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        String updatetime = df.format(currenttimestamp);
        String status = selectedorder.getStatus();
        client.updateorderStatus(selectedorder.getOrderId(), status, updatetime);
        //client.updateorderStatus(selectedorder.getOrderId().toString(), status, updatetime);
//        res = client.getAllOrders(Response.class);
//        orders = res.readEntity(gorders);
        Response res = client.getAllOrders(Response.class);
        ArrayList<TblOrder> ord = new ArrayList<TblOrder>();
        GenericType<Collection<TblOrder>> genericType = new GenericType<Collection<TblOrder>>() {
        };
        ord = (ArrayList<TblOrder>) res.readEntity(genericType);
       orders = ord;
        
        return "OrderDetais.xhtml?faces-redirect=true";
    }
}
