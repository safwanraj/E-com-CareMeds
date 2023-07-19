/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author safwan
 */
@Stateless
public class UserBean implements UserBeanLocal {

   @PersistenceContext(unitName = "ProjectPU")
    EntityManager em;
//    @PostConstruct
//    public void init()
//    {
//        em = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
//    }

//    ---------------------------------------Users :--------------------------------------------
   
   
   
    @Override
    public void Registration(String EmailId, String Password, String FirstName,  String LastName,String Contact,String Gender) {
        Users users = new Users();
        users.setUserId(0);
        users.setEmailId(EmailId);
        String pass = getEncryptedPassword(Password);
        users.setPassword(pass);
        users.setFirstName(FirstName);
       
        users.setLastName(LastName);
        users.setContact(Contact);
        users.setGender(Gender);
        
         // em.getTransaction().begin();
        em.persist(users);
        
        em.flush();
        int userId = users.getUserId();
        Userrole userrole = new Userrole();
        userrole.setUserId(new Users(userId));
        userrole.setRoleId(new Roles(2));
        em.persist(userrole);
//        em.getTransaction().commit();
    }
   
        public String getEncryptedPassword(String password)
        {
            String encrypedPassword;
            Pbkdf2PasswordHashImpl encPass=new Pbkdf2PasswordHashImpl();
            encrypedPassword = encPass.generate(password.toCharArray());
            return encrypedPassword;
        }
      
        
        
        @Override
    public void UpdateProfile(int UserId ,String EmailId , String Password , String FirstName  , String LastName , String Contact , String Gender) 
    {
        Users u1 = em.find(Users.class, UserId);
        
        u1.setEmailId(EmailId);
        u1.setPassword(Password);
        u1.setFirstName(FirstName);
       
        u1.setLastName(LastName);
        u1.setContact(Contact);
       u1.setGender(Gender);
        
       
        em.getTransaction().begin();
        em.merge(u1);
        em.getTransaction().commit();
    }
    
    
    //    ---------------------------------------Category :--------------------------------------------
    
    @Override
    public Collection<Category> getAllCategory() 
    {
        Collection<Category> temp = em.createNamedQuery("Category.findAll").getResultList();
        for (Category category : temp) {
            System.out.println(category.getCatName());
        }
        return em.createNamedQuery("Category.findAll").getResultList();
    }
    
    @Override
    public Collection<Category> getAllCategoryName()
    {
        Collection<Category> temp = em.createNamedQuery("Category.findByCatName").getResultList();
        for (Category category : temp) {
            System.out.println(category.getCatName());
        }
        return em.createNamedQuery("Category.findByCatName").getResultList();
    }
    
     //    ---------------------------------------Brand :--------------------------------------------
    
    @Override
    public Collection<Brand> getAllBrand() 
    {
        Collection<Brand> temp = em.createNamedQuery("Brand.findAll").getResultList();
        for (Brand brand : temp) {
            System.out.println(brand.getBrandName());
        }
        return em.createNamedQuery("Brand.findAll").getResultList();
    }
    
    @Override
    public Collection<Brand> getAllBrandName()
    {
        Collection<Brand> temp = em.createNamedQuery("Brand.findByBrandName").getResultList();
        for (Brand brand : temp) {
            System.out.println(brand.getBrandName());
        }
        return em.createNamedQuery("Brand.findByCatName").getResultList();
    }
   ////////////////////////////////////////////////////cart 
     @Override
    public void addToCart(Integer prdId, Integer userId, Integer qty, String createdAt, String updatedAt) {
        TblCart tc = new TblCart();
        Products tp = em.find(Products.class, prdId);
         Users uid=em.find(Users.class, userId);
        
//        Collection<TblCart> cid= tp.getTblCartCollection();
//        Collection<TblCart> cuid=uid.getTblCartCollection();
        
//       
        
        tc.setPrdId(tp);
        tc.setUserId(uid);
        tc.setQty(qty);
        tc.setCreatedAt(createdAt);
        tc.setUpdatedAt(updatedAt);
//        em.merge(cid);
   //     em.merge(cuid);
        em.persist(tc);
    }
    
    @Override
    public void removeProduct(Integer cart_id, Integer prdId, Integer userId, Integer qty, String updatedAt) {
        TblCart tc = em.find(TblCart.class, cart_id);
        Products tp = em.find(Products.class, prdId);
        Users um = em.find(Users.class, userId);
        if(tc.getPrdId()==tp && tc.getUserId()==um){
            em.remove(tc);
        }
    }

    @Override
    public void emptyCart(Integer user_id) {
        Query query = em.createNativeQuery("delete t from tbl_cart t where t.user_id = "+user_id);
        query.executeUpdate();
    }
    
    
    @Override
    public Collection<TblOrder> getUserOrders(Integer userId) {
        Users u = em.find(Users.class, userId);
        List orders = em.createNamedQuery("TblOrder.findByUserId").setParameter("userId", u).getResultList();
        return orders;
    }
    
    @Override
    public void placeOrder(Integer userId,Integer total, String isPay, String payMode, String addressline1, String addressline2, String landmark, Integer pincode, String status, String orderDate, String updatedAt) {
        TblOrder to = new TblOrder();
        Users u = em.find(Users.class, userId);
       
    Iterable<TblCart> carts = em.createNamedQuery("TblCart.findByUserId").setParameter("userId", u).getResultList();
        Collection<Integer> parts = new ArrayList<>();
        for(TblCart cart: carts){
            Integer temp =(cart.getPrdId().getPrPrice()* cart.getQty());
            parts.add(temp);
        }
//        Integer totalpay = 0;
//        for(Integer part: parts){
//            totalpay = (totalpay + part);
//        }
        to.setUserId(u);
        
//        to.setTotalPayment(totalpay);
        to.setTotalPayment(total);
        to.setIspay(isPay);
        to.setPaymode(payMode);
        to.setAddressline1(addressline1);
        to.setAddressline2(addressline2);
        to.setLandmark(landmark);
        to.setPincode(pincode);
        to.setStatus(status);
        to.setOrderDatetime(orderDate);
        to.setUpdatesAt(updatedAt);
        em.persist(to);
        em.flush();
        Integer orderId = to.getOrderId();
        for(TblCart cart: carts){
            TblOrderdetail td = new TblOrderdetail();
            TblOrderdetailPK tk = new TblOrderdetailPK();
            tk.setOrderId(orderId);
            tk.setPrdId(cart.getPrdId().getPrId());
            td.setQty(cart.getQty());
            td.setTblOrderdetailPK(tk);
            td.setCreatedAt(orderDate);
            td.setUpdatedAt(updatedAt);
            em.persist(td);
            em.remove(cart);
        }
    }
    
    @Override
    public void cancelOrder(Integer orderId, Integer userId, String status) {
        TblOrder to = em.find(TblOrder.class, orderId);
        to.setStatus("cancelled");
        em.merge(to);
    }
    
    
     @Override
    public Collection<TblCart> viewCart(Integer userId) {
        Users u = em.find(Users.class, userId);
        List tc = em.createNamedQuery("TblCart.findByUserId").setParameter("userId", u).getResultList();
        return tc;
    }
    
    
    @Override
    public Collection<TblOrderdetail> orderDetails(Integer orderId) {
        List od = em.createNamedQuery("TblOrderdetail.findByOrderId").setParameter("orderId", orderId).getResultList();
        return od;
    }
    
    
    @Override
    public Collection<Products> activeProducts() {
      //  List products = em.createNamedQuery("TblParts.findByIsactive").setParameter("isactive", "yes").getResultList();
    List products = em.createNamedQuery("Products.findAll").getResultList();      
        return products;
    }

    
}
