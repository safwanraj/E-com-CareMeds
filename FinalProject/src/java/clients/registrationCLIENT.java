/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:registrationREST
 * [registrationREST]<br>
 * USAGE:
 * <pre>
 *        registrationCLIENT client = new registrationCLIENT();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author safwan
 */
public class registrationCLIENT {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalProject/webresources";

    public registrationCLIENT() {
       client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("registrationREST");
    }
    
    
    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }
   
    

    public void RegistrationUser(String Email, String Password, String FirstName, String LastName, String Contact, String Gender) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("registration/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{Email, Password, FirstName, LastName, Contact, Gender})).request().post(null);
    }
    public <T> T getallUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUsers");
      //  return resource.get(responseType);
      return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
