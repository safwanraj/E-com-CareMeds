/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.UserBeanLocal;
import entity.TblOrder;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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
@Path("userordrest")
//@DeclareRoles({"Admin","User"})
public class UserOrdREST {

    @Context
    private UriInfo context;
    
    @EJB UserBeanLocal user;
    public UserOrdREST() {
    }
    
    
    
    //CART MODULE
    //    @RolesAllowed("User")
    @POST
    @Path("addToCart/{prdtId}/{userId}/{qty}/{createdAt}/{updatedAt}")
    public void addToCart(@PathParam("prdId") Integer prdId, @PathParam("userId") Integer userId, @PathParam("qty") Integer qty, @PathParam("createdAt") String createdAt, @PathParam("updatedAt") String updatedAt){
        user.addToCart(prdId, userId, qty, createdAt, updatedAt);
    }
    
    
     //    @RolesAllowed("User")
    @DELETE
    @Path("removeProduct/{cart_id}/{prdId}/{userId}/{qty}/{updatedAt}")
    public void removePart(@PathParam("cart_id") Integer cart_id, @PathParam("prdId") Integer prdId, @PathParam("userId") Integer userId, @PathParam("qty") Integer qty, @PathParam("updatedAt") String updatedAt){
        user.removeProduct(cart_id, prdId, userId, qty, updatedAt);
    }
    
    @DELETE
    @Path("emptyCart/{user_id}")
    public void emptyCart(@PathParam("cart_id") Integer user_id){
        user.emptyCart(user_id);
    }
    
   
    
    
    //PART ORDER MODULE
     //    @RolesAllowed("User")
    @POST
    @Path("placeOrder/{userId}/{total}/{isPay}/{payMode}/{addressline1}/{addressline2}/{landmark}/{pincode}/{status}/{orderDate}/{updatedAt}")
    public void placeOrder(@PathParam("userId") Integer userId,@PathParam("total") Integer total, @PathParam("isPay") String isPay, @PathParam("payMode") String payMode, @PathParam("addressline1") String addressline1, @PathParam("addressline2") String addressline2, @PathParam("landmark") String landmark, @PathParam("pincode") Integer pincode, @PathParam("status") String status, @PathParam("orderDate") String orderDate, @PathParam("updatedAt") String updatedAt){
        user.placeOrder(userId,total, isPay, payMode, addressline1, addressline2, landmark, pincode, status, orderDate, updatedAt);
    }
    
    @GET
    @Path("getUserOrders/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOrder> getUserOrders(@PathParam("userId") Integer userId){
        return user.getUserOrders(userId);
    }
    
    @PUT
    @Path("cancelOrder/{orderId}/{userId}/{status}")
    public void cancelOrder(@PathParam("orderId") Integer orderId, @PathParam("userId") Integer userId, @PathParam("status") String status){
        user.cancelOrder(orderId, userId, status);
    }
    
    

}
