/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.AdminBeanLocal;


import entity.*;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Safwan
 */
@Path("ordrest")
public class OrderREST {

    @EJB AdminBeanLocal admin;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminrestResource
     */
    public OrderREST() {
    }

   
    
    
    
    
    
   
    
    
    
    
    
    
   
    
    @POST
    @Path("updateorder/{id}/{status}/{updatedat}")
    public void updateorderStatus(@PathParam("id")Integer OrderId, @PathParam("status")String status, @PathParam("updatedat")String updatedAt){
        admin.updateorderStatus(OrderId, status, updatedAt);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allorders")
    public Collection<TblOrder> getAllOrders(){
        return admin.getAllOrders();
    }
//  
    
    @GET
    @Path("ordersbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOrder> getOrdersById(@PathParam("id")Integer orderId){
        return admin.getOrdersById(orderId);
    }
    
    @GET
    @Path("orderdetails/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOrderdetail> getOrderDetailByOrderId(@PathParam("id")Integer orderId){
        return admin.getOrderDetailByOrderId(orderId);
    }
    
    
}
