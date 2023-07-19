/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import clients.registrationCLIENT;
import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.util.LangUtils;

/**
 *
 * @author safwan
 */
@Named(value = "usersBean")
@RequestScoped
public class UsersBean {

    /**
     * Creates a new instance of Users
     */
    public UsersBean() {
    }
     @Inject
    ServletContext context;
    
    @EJB
    AdminBeanLocal abl;
    
    registrationCLIENT rjc= new registrationCLIENT();
    
    int uid;
    String fname,lname,gender,email,phone;
     private Collection<UsersBean> portlist;
    Collection<UsersBean> filteredparts;
    UsersBean users;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UsersBean getUsers() {
        return users;
    }

    public void setUsers(UsersBean users) {
        this.users = users;
    }
    

    public Collection<UsersBean> getPortlist() {
        
         Response response = rjc.getallUsers(Response.class);
        ArrayList<UsersBean> users = new ArrayList<UsersBean>();
        GenericType<Collection<UsersBean>> genericType = new GenericType<Collection<UsersBean>>() {
        };
        users = (ArrayList<UsersBean>) response.readEntity(genericType);
        portlist = users;
        return portlist;
    }

    public void setPortlist(Collection<UsersBean> portlist) {
        this.portlist = portlist;
    }

    public Collection<UsersBean> getFilteredparts() {
        return filteredparts;
    }

    public void setFilteredparts(Collection<UsersBean> filteredparts) {
        this.filteredparts = filteredparts;
    }
    
    public Collection<Users> getallUsers() {
        System.out.println("in col");
//        return ubl.getAllCategoryName();
            return abl.getAllUsers();
    }
     public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        Users part = (Users) value;
        return part.getFirstName().toLowerCase().contains(filtertext)
                || part.getLastName().toLowerCase().contains(filtertext)
                || part.getEmailId().toLowerCase().contains(filtertext);
                
    }
    
    
    
}
