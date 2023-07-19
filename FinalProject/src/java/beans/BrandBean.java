/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import ejb.UserBeanLocal;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import clients.BrandClient;
import ejb.AdminBeanLocal;
import entity.Brand;
import entity.Category;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.*;
//import org.primefaces.PrimeFaces;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.util.LangUtils;

/**
 *
 * @author safwan
 */
@Named(value = "brandBean")
@RequestScoped
public class BrandBean {

    /**
     * Creates a new instance of BrandBean
     */
    public BrandBean() {
    }
     @Inject
    ServletContext context;
    @EJB
    UserBeanLocal ubl;
    @EJB
    AdminBeanLocal abl;
    BrandClient bjc = new BrandClient();

    Brand brand;
   
    int brandId;
    
    String BrandName, Description;
    private Collection<Brand> portlist;
    Collection<Brand> filteredparts;

    public Collection<Brand> getPortlist() {
        Response response = bjc.getAllBrand(Response.class);
        ArrayList<Brand> brands = new ArrayList<Brand>();
        GenericType<Collection<Brand>> genericType = new GenericType<Collection<Brand>>() {
        };
        brands = (ArrayList<Brand>) response.readEntity(genericType);
        portlist = brands;
//        for (Photocategory photocategory1 : photocategorys) {
//            System.out.println("Name : " + photocategory1.getCategoryName());
//        }
        return portlist;
    }

    public void setPortlist(Collection<Brand> portlist) {
        this.portlist = portlist;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    public Collection<Brand> getFilteredparts() {
        return filteredparts;
    }

    public void setFilteredparts(Collection<Brand> filteredparts) {
        this.filteredparts = filteredparts;
    }
    
    public Collection<Brand> getallBrandName() {
        System.out.println("in col");
//        return ubl.getAllCategoryName();
            return abl.getAllBrand();
    }
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        Brand part = (Brand) value;
        return part.getBrandName().toLowerCase().contains(filtertext);
               
    }
    
    public String getBrandById(int brandId) {
        Response response = bjc.getBrandById(Response.class, brandId);
        GenericType<Brand> genericType = new GenericType<Brand>() {
        };
        Brand brand = response.readEntity(genericType);
        this.brandId = brand.getBrandId();
        BrandName = brand.getBrandName();
        Description = brand.getBrandDesc();
        return "AddBrand.xhtml";
       

       // System.out.println(CategoryPhotoPath);
    }
    public String addBrand()
    {
        
        if(brandId!=0)
        {
            Brand b = new Brand();
            b.setBrandId(brandId);
            b.setBrandName(BrandName);
            b.setBrandDesc(Description);
            bjc.updateBrand(brandId, BrandName, Description);
        }
        else
        {
        
            Brand b = new Brand();
            //d.setDeptId(did);
           b.setBrandName(BrandName);
            b.setBrandDesc(Description);
            bjc.addBrand(BrandName, Description);            
        }
       // return "CategoryDetails.xhtml";
        return "BrandDetails.xhtml?faces-redirect=true";
    }

     public void deleteBrand(int brdId) {
        bjc.deleteBrand(Response.class,brdId);
        getPortlist();
    }
     
     public void reset(CloseEvent e) {

        System.out.println("in reset function");
        setBrandId(0);
        setBrandName("");
        
        setDescription("");
    }
}
