/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import clients.registrationCLIENT;
import ejb.UserBeanLocal;
import entity.Users;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author safwan
 */
@Named(value = "registrationBean")
@ApplicationScoped
public class registrationBean {

    
     int UserId;
    String EmailId,Password,FirstName,LastName,Contact,Gender;
   
    
    
    @EJB UserBeanLocal ubl;
//    registrationCLIENT rclient = new registrationCLIENT();
    /**
     * Creates a new instance of registrationBean
     */
    public registrationBean() {
    }
    
public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

  

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

   
    
    
    public String registration()
    {
//        try
//        {
//            InputStream inputStream = file.getInputStream();
////            String path = "E:\\Mcs(IT)\\8th sem\\JAVA EE\\Project\\Project\\Project-war\\web\\User\\Upload\\Users";
//            Random random = new Random();
//            StringBuilder sb = new StringBuilder();
//            
//              sb.append(random.nextInt(9) + 1 );
//            for (int i = 0; i < 11; i++) {
//                sb.append(random.nextInt(10));
//            }
//            String temp = sb.toString();
//            ProfilePhoto = temp + file.getSubmittedFileName();
//            Files.copy(inputStream,new File(path,ProfilePhoto).toPath());
//            
//            Users users = new Users();
//            
//            users.setUserId(0);
//            users.setEmailId(EmailId);
//            users.setPassword(Password);
//            users.setFirstName(FirstName);
//            users.setMiddleName(MiddleName);
//            users.setLastName(LastName);
//            users.setProfilePhoto(ProfilePhoto);
//            users.setIsDisable(false);
//            
//            ubl.Registration(EmailId, Password, FirstName, MiddleName, LastName, ProfilePhoto, UserProfileURL, IsDisable);
//            
//        }catch(Exception e)
//        {  
//            e.printStackTrace();
//        }
       
        try{
           
            
            Users users = new Users();
            
            users.setUserId(UserId);
            users.setEmailId(EmailId);
            users.setPassword(Password);
            users.setFirstName(FirstName);
           
            users.setLastName(LastName);
            users.setContact(Contact);
            users.setGender(Gender);
            
            ubl.Registration(EmailId, Password, FirstName, LastName, Contact, Gender);
            //return "login.xhtml";
            
        }catch(Exception e){
            e.printStackTrace();
           // return "Registration.xhtml";
        }

//        rclient.RegistrationUser(EmailId, Password, FirstName, MiddleName, LastName, ProfilePhoto, FirstName);
       return "Login.xhtml?faces-redirect=true";
   }
    
    
}

