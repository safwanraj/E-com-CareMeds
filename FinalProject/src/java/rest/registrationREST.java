/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;


import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Users;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author safwan
 */
@Path("registrationREST")
//@DeclareRoles({"Admin","User"})
public class registrationREST {

    @EJB
    UserBeanLocal ubl;
    @EJB AdminBeanLocal abl;
    @Context
    private UriInfo context;

    
    public registrationREST() {
    }

    
     //    @RolesAllowed("User")
    @POST
    @Path("registration/{Email}/{Password}/{FirstName}/{LastName}/{Contact}/{Gender}")
    public void RegistrationUser(@PathParam("Email")String Email,@PathParam("Password")String Password,@PathParam("FirstName")String FirstName,@PathParam("LastName")String LastName,@PathParam("Contact")String Contact,@PathParam("Gender")String Gender)
    {
        ubl.Registration(Email, Password, FirstName, LastName, Contact, Gender);
    }
    
    
     //    @RolesAllowed("Admin")
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllUsers")
    public Collection<Users> getAllUsers()
    {
        return abl.getAllUsers();
    }
}
