/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @Inject
    private SecurityContext securityContext;

    private String name;
    private String password;
    private String Emailid;
    private String message;
    private AuthenticationStatus status;
    private Set<String> roles;

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    /**
     * AuthenticationStatus status= securityContext.authenticate(request,
     * response, // withParams().credential(creden Creates a new instance of
     * LoginBean
     */
    public LoginBean() {
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return Emailid;
    }

    public void setEmailid(String Emailid) {
        this.Emailid = Emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
//        try {
//
//            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//
//            request.getSession().setAttribute("logged-group", "");
//
//            Credential credential = new UsernamePasswordCredential(Emailid, new Password(password));
//            AuthenticationStatus status = securityContext.authenticate(request, response, withParams().credential(credential));
//
//            if (status.equals(SEND_CONTINUE)) {
//                // Authentication mechanism has send a redirect, should not
//                // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
//                context.responseComplete();
//            }
//
//            //      else if (status.equals(SEND_FAILURE)) {
////            message = "Login Failed";
////            System.out.println(message);
////            addError(context, "Authentication failed");
////        }
//            //  if(securityContext.isCallerInRole("Admin"))
//            System.out.println("In bean");
//            if (roles.contains("Admin")) {
//                System.out.println("In admin");
//                request.getSession().setAttribute("logged-group", "Admin");
//                return "/Users.xhtml";
//            } //   else if(securityContext.isCallerInRole("Supervisor"))
//            else if (roles.contains("User")) {
//                System.out.println("In User");
//                request.getSession().setAttribute("logged-group", "User");
//                return "/photoDemo.xhtml";
//            }
//            else
//            {
//                System.out.println("No Found!");
//            }
//
//            //} 
//        } catch (Exception e) {
//            message = "Out- Either user or login is wrong !!!";
//            e.printStackTrace();
//        }

        System.out.println("In Checking");
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            Credential credential = new UsernamePasswordCredential(getEmailid(), new Password(getPassword()));

            AuthenticationStatus status = securityContext.authenticate(request, response, withParams().credential(credential));

            System.err.println(status);
            System.out.println("email=" + getEmailid() + " pass=" + getPassword());
            if (status.equals(SUCCESS)) {
                HttpSession session = request.getSession(true);
//                    session.setAttribute("email",email);
//                    session.setAttribute("password",pass);
                System.out.println(securityContext.isCallerInRole("Admin"));
//                if (securityContext.isCallerInRole("Admin")) {
                if (roles.contains("Admin")) {

                    session.setAttribute("role", "Admin");
                    session.setAttribute("Admin", getEmailid());
                    response.sendRedirect("Admin/Dashboard.xhtml");
                    System.out.println(request.getSession().getAttribute("Admin"));
                    System.out.println(request.getSession().getAttribute("role"));
                    //return "/Admin/Roleindex.xhtml";

                } else if (roles.contains("User")) {
                    session.setAttribute("role", "User");
                    session.setAttribute("User", getEmailid());
                    response.sendRedirect("index.xhtml");
                    //return "/User/userindex.xhtml";
                } else {
                    System.out.println("No Role Found");
                }
            } else if (status.equals(SEND_FAILURE)) {
                message = "Username Or Password is Wrong";
                return "/Login.xhtml";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/Login.xhtml";
//return null;
    }

    private static void addError(FacesContext context, String message) {
        context = FacesContext.getCurrentInstance();
        context
                .addMessage(
                        null,
                        new FacesMessage(SEVERITY_ERROR, message, null));
    }

    public String logout() throws ServletException {
        System.out.println("In Log out");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().setAttribute("logged-group", "");
        request.logout();
        request.getSession().invalidate();

       // return "../Login.xhtml?faces-redirect=true";
      return "../Login.xhtml";
        
    }

}
