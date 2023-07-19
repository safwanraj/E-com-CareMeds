/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:BrandREST [categoryRest]<br>
 * USAGE:
 * <pre>
 *        BrandClient client = new BrandClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author safwan
 */
public class BrandClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalProject/webresources";

    public BrandClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("categoryRest");
    }

    public <T> T getAllBrand(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllBrand");
       // return resource.get(responseType);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T allBrand(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allBrand");
       // return resource.get(responseType);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T deleteBrand(Class<T> responseType, int brandId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("deleteBrand/{0}", new Object[]{brandId}));
       // return resource.get(responseType);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateBrand(int brandId, String brandName, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateBrand/{0}/{1}/{2}", new Object[]{brandId, brandName, description})).request().post(null);
    }

    public <T> T getBrandById(Class<T> responseType, int brandId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getBrandById/{0}", new Object[]{brandId}));
      //  return resource.get(responseType);
       return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addBrand(String BrandName, String Description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addBrand/{0}/{1}", new Object[]{BrandName, Description})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
