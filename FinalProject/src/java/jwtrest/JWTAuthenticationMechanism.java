
package jwtrest;

import beans.LoginBean;
 import static jwtrest.Constants.AUTHORIZATION_HEADER;
import static jwtrest.Constants.BEARER;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//@RememberMe(
//       cookieMaxAgeSeconds = REMEMBERME_VALIDITY_SECONDS,
//       isRememberMeExpression = "self.isRememberMe(httpMessageContext)"
//)

// @ApplicationScoped
@RequestScoped
@Named
//@Alternative
public class JWTAuthenticationMechanism implements HttpAuthenticationMechanism , Serializable {

     
     private static final long serialVersionUID = 1L;
   // private static final Logger LOGGER = Logger.getLogger(JWTAuthenticationMechanism.class.getName());

    /**
     * Access to the
     * IdentityStore(AuthenticationIdentityStore,AuthorizationIdentityStore) is
     * abstracted by the IdentityStoreHandler to allow for multiple identity
     * stores to logically act as a single IdentityStore
     */
    @Inject private IdentityStoreHandler identityStoreHandler;
    @Inject private LoginBean loginBean;
    @Inject private TokenProvider tokenProvider;
private String token;
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) {
        
        
        System.out.println("In JWT Auth Mechanism");
       // LOGGER.log(Level.INFO, "validateRequest: {0}", request.getRequestURI()+ " "+ loginBean.getUsername()+"dsdsds");
        
        
       
                String token = extractToken(context);
        
        if (token==null && loginBean.getEmailid()!=null) {
         //    System.out.println("JWTAuthenticationMechanism - in login if");
              
        //    Credential credential = context.getAuthParameters().getCredential();
           Credential credential = new UsernamePasswordCredential(loginBean.getEmailid(),new Password(loginBean.getPassword()));
        
           //System.out.println("JWTAuthenticationMechanism - with user name and password");
               
//  Credential credential1 = new UsernamePasswordCredential(username, password);
//          System.out.print(credential.toString());
            CredentialValidationResult result = identityStoreHandler.validate(credential);
            if (result.getStatus() == CredentialValidationResult.Status.VALID) {
               System.out.println("JWTAuthenticationMechanism - CreatingCredential credential1 = new UserNamePasswordCredential token");
                
               AuthenticationStatus status= createToken(result, context);
               loginBean.setStatus(status);
               loginBean.setRoles(result.getCallerGroups());
                return status;
            }
            else
            {
                loginBean.setMessage("Login Error : Either Login or Password is Wrong. Try Again");
                loginBean.setStatus(AuthenticationStatus.SEND_FAILURE);
            }
            
            // if the authentication fastatusiled, we return the unauthorized status in the http response
      //      return context.responseUnauthorized();
        }
        
         else if (token != null) {
            // validation of the jwt credential
       
            return validateToken(token, context);
        } else if (context.isProtected()) {
            // A protected resource is a resource for which a constraint has been defined.
            // if there are no credentials and the resource is protected, we response with unauthorized status
            return context.responseUnauthorized();
        }
        // there are no credentials AND the resource is not protected, 
        // SO Instructs the container to "do nothing"
        return context.doNothing();
    }

    /**
     * To validate the JWT token e.g Signature check, JWT claims
     * check(expiration) etc
     *
     * @param token The JWT access tokens
     * @param context
     * @return the AuthenticationStatus to notify the container
     */
    private AuthenticationStatus validateToken(String token, HttpMessageContext context) {
        try {
            if (tokenProvider.validateToken(token)) {
                JWTCredential credential = tokenProvider.getCredential(token);
                  context.getRequest().getSession().setAttribute("token", token);
          
            System.out.println("JWTAuthenticationMechanism-Token Validated");
                return context.notifyContainerAboutLogin(credential.getPrincipal(), credential.getAuthorities());
            
            }
            // if token invalid, response with unauthorized status
            return context.responseUnauthorized();
        } catch (ExpiredJwtException eje) {
//            LOGGER.log(Level.INFO, "Security exception for user {0} - {1}", new String[]{eje.getClaims().getSubject(), eje.getMessage()});
            return context.responseUnauthorized();
        }
    }

    /**
     * Create the JWT using CredentialValidationResult received from
     * IdentityStoreHandler
     *
     * @param result the result from validation of UsernamePasswordCredential
     * @param context
     * @return the AuthenticationStatus to notify the container
     */
    private AuthenticationStatus createToken(CredentialValidationResult result, HttpMessageContext context) {
        if (!isRememberMe(context)) {
            // if (true) {
            String jwt = tokenProvider.createToken(result.getCallerPrincipal().getName(), result.getCallerGroups(), false);
          
            context.getResponse().addHeader(AUTHORIZATION_HEADER, BEARER + jwt);
           
            
            
            
            System.out.println("iToken="+jwt);
            context.getRequest().getSession().setAttribute("token", jwt);
        }
        System.out.println("JWTAuthenticationMechanism - Token Created");
        return context.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
    }

    /**
     * To extract the JWT from Authorization HTTP header
     *
     * @param context
     * @return The JWT access tokens
     */
    private String extractToken(HttpMessageContext context) {
        String authorizationHeader = context.getRequest().getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {
            String token = authorizationHeader.substring(BEARER.length(), authorizationHeader.length());
     System.out.println("JWTAuthenticationMechanism - Extract Tokens");
      context.getRequest().getSession().setAttribute("token", token);
          
            return token;
        }
        return null;
    }

    /**
     * this function invoked using RememberMe.isRememberMeExpression EL
     * expression
     *
     * @param context
     * @return The remember me flag
     */
    public Boolean isRememberMe(HttpMessageContext context) {
        return Boolean.valueOf(context.getRequest().getParameter("rememberme"));
    }

}
