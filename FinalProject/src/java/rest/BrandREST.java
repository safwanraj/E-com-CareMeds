/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Brand;
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
public class BrandREST {
    
      @EJB AdminBeanLocal abl;
    @EJB UserBeanLocal ubl;
    
    @Context
    private UriInfo context;
    
    
    public BrandREST() {
    }

    /**
     * Retrieves representation of an instance of rest.DepartmentResource
     * @return an instance of java.lang.String
     */
   //    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getBrandById/{brandId}")
    public Brand getBrandById(@PathParam("brandId")int brId)
    {
        return abl.getBrandById(brId);
    }
    
//    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllBrand")
    public Collection<Brand> getAllBrand()
    {
        return abl.getAllBrand();
    }
    
//    @RolesAllowed("Admin")
    @POST
    @Path("addBrand/{BrandName}/{Description}")
    public void addBrand(@PathParam("BrandName")String BrandName,@PathParam("Description") String Description)
    {
        abl.addBrand(BrandName, Description);
    }
    
    @POST
    @Path("updateBrand/{brandId}/{brandName}/{description}/")
    public void updateBrand(@PathParam("brandId")int brandId,@PathParam("brandName")String brandName,@PathParam("description")String Description)
    {
        abl.updateBrand(brandId, brandName, Description);
    }
    
//    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleteBrand/{brandId}")
    public void deleteBrand(@PathParam("brandId")int brandId)
    {
        abl.deleteBrand(brandId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allBrand")
    public Collection<Brand> allBrand()
    {
        return ubl.getAllBrandName();
    }
//    .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
//    https://localhost:8181/photographyProject/webresources
    /**
     * PUT method for updating or creating an instance of DepartmentResource
     * @param content representation for the resource
     */
    
    
}
