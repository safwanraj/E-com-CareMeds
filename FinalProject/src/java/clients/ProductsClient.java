/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ProductsREST
 * [productsREST]<br>
 * USAGE:
 * <pre>
 *        ProductsClient client = new ProductsClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author safwan
 */
public class ProductsClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalProject/webresources";

    public ProductsClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("productsREST");
    }

    public <T> T getAllProducts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllProducts");
      //  return resource.get(responseType);
       return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public <T> T getProductsById(Class<T> responseType, int prid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProductsById/{0}", new Object[]{prid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
//    public void deleteProducts(Class<T> responseType,int prid) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("deleteProducts/{0}", new Object[]{prid})).request().delete();
//    }
     public <T> T deleteProducts(Class<T> responseType, int prid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("deleteProducts/{0}", new Object[]{prid}));
        //return resource.get(responseType);
         return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public void addProducts(int CategoryId, int BrandId, String PrdName, String PrdStatus, int PrdPrice, String PrdQty, String PrdDesc, String PrdImage) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addProducts/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{CategoryId, BrandId, PrdName, PrdStatus, PrdPrice, PrdQty, PrdDesc, PrdImage})).request().post(null);
    }
//     public void addProducts(Object requestEntity) throws ClientErrorException {
//        webTarget.path("addProducts").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
    
//     public void addCategory(String CategoryName, String Description) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("addCategory/{0}/{1}", new Object[]{CategoryName, Description})).request().post(null);
//    }
     
//     public void updateProducts(Object requestEntity) throws ClientErrorException {
//        webTarget.path("updateProducts").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
    public void updateProducts(int prid,int CategoryId, int BrandId, String PrdName, String PrdStatus, int PrdPrice, String PrdQty, String PrdDesc, String PrdImage) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateProducts/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{prid,CategoryId, BrandId, PrdName, PrdStatus, PrdPrice, PrdQty, PrdDesc, PrdImage})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
