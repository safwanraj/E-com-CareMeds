/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package rest;

import java.util.Set;
import javax.ws.rs.core.Application;
/**
 *
 * @author safwan
 */

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        
        resources.add(rest.BrandREST.class);
        resources.add(rest.CategoryREST.class);
        resources.add(rest.OrderREST.class);
        resources.add(rest.ProductsREST.class);
        resources.add(rest.UserOrdREST.class);
        resources.add(rest.registrationREST.class);
        
    }
    
}
