/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;


import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Category;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author safwan
 */

@Path("categoryRest")
//@DeclareRoles({"Admin","User"})
public class CategoryREST {
    
    @EJB AdminBeanLocal abl;
    @EJB UserBeanLocal ubl;
    
    @Context
    private UriInfo context;
    
    
    public CategoryREST() {
    }

    /**
     * Retrieves representation of an instance of rest.DepartmentResource
     * @return an instance of java.lang.String
     */
   //    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCategoryById/{categoryId}")
    public Category getCategoryById(@PathParam("categoryId")int categoryId)
    {
        return abl.getCategoryById(categoryId);
    }
    
//    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllCategory")
    public Collection<Category> getAllCategory()
    {
        return abl.getAllCategory();
    }
    
//    @RolesAllowed("Admin")
    @POST
    @Path("addCategory/{CategoryName}/{Description}")
    public void addCategory(@PathParam("CategoryName")String CategoryName,@PathParam("Description") String Description)
    {
        abl.addCategory(CategoryName, Description);
    }
    //    @RolesAllowed("Admin")
    @POST
    @Path("updateCategory/{categoryId}/{categoryName}/{description}/")
    public void updateCategory(@PathParam("categoryId")int categoryId,@PathParam("categoryName")String categoryName,@PathParam("description")String Description)
    {
        abl.updateCategory(categoryId, categoryName, Description);
    }
    
//    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleteCategory/{categoryId}")
    public void deleteCategory(@PathParam("categoryId")int categoryId)
    {
        abl.deleteCategory(categoryId);
    }
    //    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allCategory")
    public Collection<Category> allCategory()
    {
        return ubl.getAllCategoryName();
    }
//    .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
//    https://localhost:8181/photographyProject/webresources
    /**
     * PUT method for updating or creating an instance of DepartmentResource
     * @param content representation for the resource
     */
    
    
}
