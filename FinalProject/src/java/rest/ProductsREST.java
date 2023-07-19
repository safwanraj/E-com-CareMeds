/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Products;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author safwan
 */
@Path("productsREST")
//@DeclareRoles({"Admin","User"})
@RequestScoped
public class ProductsREST {
    
    
     @EJB AdminBeanLocal abl;
    @EJB UserBeanLocal ubl;
    
    @Context
    private UriInfo context;
    
    public ProductsREST() {
    }
    //    @RolesAllowed("Admin")
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllProducts")
    public Collection<Products> getAllProducts()
    {
        return abl.getAllProducts();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getProductsById/{prid}")
    public Products getProductsById(@PathParam("prid") int prid)
    {
        return abl.getProductsById(prid);
    }
    
    //    @RolesAllowed("Admin")
    @POST
    @Path("addProducts/{CategoryId}/{BrandId}/{PrdName}/{PrdStatus}/{PrdPrice}/{PrdQty}/{PrdDesc}/{PrdImage}")
    public void addProducts(@PathParam("CategoryId")int catid,@PathParam("BrandId") int brid,@PathParam("PrdName") String prname,@PathParam("PrdStatus") String prstatus,@PathParam("PrdPrice") int prprice,@PathParam("PrdQty") String prqty,@PathParam("PrdDesc") String prdesc,@PathParam("PrdImage") String primage)
    {
       abl.addProducts(catid, brid, prname, prstatus, prprice, prqty, prdesc, primage);
    }
    //    @RolesAllowed("Admin")
//    @POST
//    @Path("addCategory/{CategoryName}/{Description}")
//    public void addCategory(@PathParam("CategoryName")String CategoryName,@PathParam("Description") String Description)
//    {
//        abl.addCategory(CategoryName, Description);
//    }
//    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("addProducts")
//    public void addProducts(Products prd)
//    {
//      //  abl.addProducts(emp.getName(), emp.getSalary(), emp.getDeptId().getDeptId());
//        abl.addProducts(prd.getCatId().getCatId(), prd.getBrId().getBrandId(),prd.getPrName(), prd.getPrStatus(), prd.getPrPrice(), prd.getPrQty(), prd.getPrDesc(), prd.getPrImgpath());
//    }
    
    //    @RolesAllowed("Admin")
   @POST
    @Path("updateProducts/{ProductId}/{CategoryId}/{BrandId}/{PrdName}/{PrdStatus}/{PrdPrice}/{PrdQty}/{PrdDesc}/{PrdImage}")
    public void updateProducts(@PathParam("ProductId")int prid,@PathParam("CategoryId")int catid,@PathParam("BrandId") int brid,@PathParam("PrdName") String prname,@PathParam("PrdStatus") String prstatus,@PathParam("PrdPrice") int prprice,@PathParam("PrdQty") String prqty,@PathParam("PrdDesc") String prdesc,@PathParam("PrdImage") String primage)
    {
        // abl.updateProducts(prd.getPrId(),prd.getCatId().getCatId(), prd.getBrId().getBrandId(),prd.getPrName(), prd.getPrStatus(), prd.getPrPrice(), prd.getPrQty(), prd.getPrDesc(), prd.getPrImgpath());
         abl.updateProducts(prid,catid, brid, prname, prstatus, prprice, prqty, prdesc, primage);
        
    }
    
//    @DELETE
//    @Path("deleteProducts/{prid}")
//    public void deleteProducts(@PathParam("prid") int prid)
//    {
//        abl.deleteProducts(prid);
//    }
    //    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleteProducts/{prid}")
    public void deleteProducts(@PathParam("prid")int prid)
    {
        abl.deleteProducts(prid);
    }
}
