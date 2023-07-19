/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author safwan
 */
@Local
public interface UserBeanLocal {
    
//    ---------------------------------------Users :--------------------------------------------    
    void Registration(String EmailId , String Password , String FirstName , String LastName , String Contact , String Gender);
    void UpdateProfile(int UserId ,String EmailId , String Password , String FirstName , String LastName , String Contact , String Gender);
    //    void ForgotPassword();
    
    //    ---------------------------------------Category :--------------------------------------------    

    Collection<Category> getAllCategory();
    Collection<Category> getAllCategoryName();
     //    ---------------------------------------brand :--------------------------------------------    

    Collection<Brand> getAllBrand();
    Collection<Brand> getAllBrandName();
    
    
    /////////////////////////////////////////////Products///////////////////////////////////////////////
    
    
    Collection<Products> activeProducts();
    
    void addToCart(Integer prdId, Integer userId, Integer qty, String createdAt, String updatedAt);

    void removeProduct(Integer cart_id, Integer prdId, Integer userId, Integer qty, String updatedAt);

    void emptyCart(Integer user_id);
    
    Collection<TblCart> viewCart(Integer userId);
    
    
    //PART ORDER MODULE
//    void placeOrder(Integer orderId, Integer userId, Integer cityId, Integer totalPayment, String isPay, String payMode, String addressline1, String addressline2, String landmark, Integer pincode, String status, String orderDate, String updatedAt);
    void placeOrder(Integer userId,Integer total, String isPay, String payMode, String addressline1, String addressline2, String landmark, Integer pincode, String status, String orderDate, String updatedAt);

    Collection<TblOrder> getUserOrders(Integer userId);

    void cancelOrder(Integer orderId, Integer userId, String status);
    
    Collection<TblOrderdetail> orderDetails(Integer orderId);

}

