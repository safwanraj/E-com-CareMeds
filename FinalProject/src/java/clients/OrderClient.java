/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:OrderREST [adminrest]<br>
 * USAGE:
 * <pre>
 *        OrderClient client = new OrderClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author safwan
 */
public class OrderClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalProject/webresources";

    public OrderClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("ordrest");
    }

    public <T> T getOrdersById(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("ordersbyid/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateorderStatus(int id, String status, String updatedat) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateorder/{0}/{1}/{2}", new Object[]{id, status, updatedat})).request().post(null);
    }
    
//     public void updateBrand(int brandId, String brandName, String description) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("updateBrand/{0}/{1}/{2}", new Object[]{brandId, brandName, description})).request().post(null);
//    }

    public <T> T getOrderDetailByOrderId(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("orderdetails/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllOrders(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allorders");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
//    public <T> T getAllCategory(Class<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("getAllCategory");
//      //  return resource.get(responseType);
//       return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }

    public void close() {
        client.close();
    }
    
}
