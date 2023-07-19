/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UserOrdREST [user]<br>
 * USAGE:
 * <pre>
 *        UserOrdClient client = new UserOrdClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author safwan
 */
public class UserOrdClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalProject/webresources";

    public UserOrdClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("userordrest");
    }

    public void placeOrder(int userId,int total, String isPay, String payMode, String addressline1, String addressline2, String landmark, int pincode, String status, String orderDate, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("placeOrder/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{userId,total, isPay, payMode, addressline1, addressline2, landmark, pincode, status, orderDate, updatedAt})).request().post(null);
    }

    public void cancelOrder(int orderId, int userId, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("cancelOrder/{0}/{1}/{2}", new Object[]{orderId, userId, status})).request().put(null);
    }

    public <T> T getUserOrders(Class<T> responseType, int userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserOrders/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void emptyCart(int user_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("emptyCart/{0}", new Object[]{user_id})).request().delete();
    }

    public void addToCart(int prdtId, int userId, int qty, String createdAt, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addToCart/{0}/{1}/{2}/{3}/{4}", new Object[]{prdtId, userId, qty, createdAt, updatedAt})).request().post(null);
    }

    public void removePart(int cart_id, int prdId, int userId, int qty, String updatedAt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeProduct/{0}/{1}/{2}/{3}/{4}", new Object[]{cart_id, prdId, userId, qty, updatedAt})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
