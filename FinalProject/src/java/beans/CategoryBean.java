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
import clients.CategoryClient;
import ejb.AdminBeanLocal;
import entity.Category;
import entity.Products;

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
@Named(value = "categoryBean")
@RequestScoped
public class CategoryBean {

    /**
     * Creates a new instance of CategoryBean
     */
    public CategoryBean() {
    }
    @Inject
    ServletContext context;
    @EJB
    UserBeanLocal ubl;
    @EJB
    AdminBeanLocal abl;
    CategoryClient cjc = new CategoryClient();

    Category category;
   
    int categoryId;
    String CategoryName, Description;
    private Collection<Category> portlist;
    Collection<Category> filteredparts;

    public Collection<Category> getPortlist() {
        Response response = cjc.getAllCategory(Response.class);
        ArrayList<Category> categorys = new ArrayList<Category>();
        GenericType<Collection<Category>> genericType = new GenericType<Collection<Category>>() {
        };
        categorys = (ArrayList<Category>) response.readEntity(genericType);
        portlist = categorys;
//        for (Photocategory photocategory1 : photocategorys) {
//            System.out.println("Name : " + photocategory1.getCategoryName());
//        }
        return portlist;
    }

    public void setPortlist(Collection<Category> portlist) {
        this.portlist = portlist;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    public Collection<Category> getFilteredparts() {
        return filteredparts;
    }

    public void setFilteredparts(Collection<Category> filteredparts) {
        this.filteredparts = filteredparts;
    }

   

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Category> getallCategoryName() {
        System.out.println("in col");
//        return ubl.getAllCategoryName();
return abl.getAllCategory();
    }
     public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        Category part = (Category) value;
        return part.getCatName().toLowerCase().contains(filtertext);
                
    }

//    public String addCategory() {
//        //System.out.println(file.getFileName());
//       // try (InputStream i = file.getInputStream()) {
//            try{
//            System.out.println("in add");
//            Category category = new Category();
//         //   String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Category";
//          //  CategoryPhotoPath = file.getFileName();
//          //  Files.copy(i, new File(path, CategoryPhotoPath).toPath());
//            category.setCatId(categoryId);
//            category.setCatName(CategoryName);
//            category.setCatDesc(Description);
//            System.out.println("Category Id = " + categoryId + " , Category Name = " + CategoryName );
//            cjc.addCategory(CategoryName, Description);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "CategoryDetails.xhtml?faces-redirect=true";
//    }

    public String getCategoryById(int categoryId) {
        Response response = cjc.getCategoryById(Response.class, categoryId);
        GenericType<Category> genericType = new GenericType<Category>() {
        };
        Category category = response.readEntity(genericType);
        this.categoryId = category.getCatId();
        CategoryName = category.getCatName();
        Description = category.getCatDesc();
        return "AddCategory.xhtml";
       

       // System.out.println(CategoryPhotoPath);
    }
    public String addCategory()
    {
        
        if(categoryId!=0)
        {
            Category c = new Category();
            c.setCatId(categoryId);
            c.setCatName(CategoryName);
            c.setCatDesc(Description);
            cjc.updateCategory(categoryId, CategoryName, Description);
        }
        else
        {
        
            Category c = new Category();
            //d.setDeptId(did);
           c.setCatName(CategoryName);
            c.setCatDesc(Description);
            cjc.addCategory(CategoryName, Description);            
        }
       // return "CategoryDetails.xhtml";
        return "CategoryDetails.xhtml?faces-redirect=true";
    }

//    public void updateCategory() {
//       // System.out.println(file.getFileName());
////        if (file.getFileName() == null) {
////            System.out.println("in without file update");
////            System.out.println("without file selects and goes to update");
////            System.out.println("Category Id = " + categoryId + " , Category Name = " + CategoryName + " , Category Path = " + CategoryPhotoPath);
////            portclient.updatePhotoCategory(categoryId, CategoryName, Description, CategoryPhotoPath);
////            getPortlist();
////        } else {
//           // try (InputStream i = file.getInputStream()) {
//           try{
//                System.out.println("in add");
//                Category category = new Category();
//              //  String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\web proect\\photographyProject\\web\\User\\Upload\\Category";
//              //  CategoryPhotoPath = file.getFileName();
//               // Files.copy(i, new File(path, CategoryPhotoPath).toPath());
//                category.setCatId(categoryId);
//                category.setCatName(CategoryName);
//                category.setCatDesc(Description);
//                System.out.println("Category Id = " + categoryId + " , Category Name = " + CategoryName );
//                cjc.updateCategory(categoryId, CategoryName, Description);
//                getPortlist();
//            } 
//           catch (Exception e) {
//                e.printStackTrace();
//            }
//        
//
//    }

    public void deleteCategory(int catId) {
        cjc.deleteCategory(Response.class,catId);
        getPortlist();
    }

//    public void GoToAllPhotos(int CategoryId) throws IOException {
////        return "allphotos.xhtml?faces-redirect=true?CategoryName="+CategoryName;
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        Object request = context.getRequest();
//        Object response = context.getResponse();
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        HttpSession session = req.getSession(false);
//
//        if (session.getAttribute("User") == null) {
//            res.sendRedirect(".../Login.xhtml");
//        }
//        if (session.getAttribute("User") != null) {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("allphotos.xhtml?CategoryId=" + CategoryId);
//        }
//    }

    public void reset(CloseEvent e) {

        System.out.println("in reset function");
        setCategoryId(0);
        setCategoryName("");
        
        setDescription("");
    }
}
