/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.*;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author safwan
 */
@Local
public interface AdminBeanLocal {
    
    //////////////////////////////////////////// for category//////////////////////////////////////////////////////
    Collection<Category> getAllCategory();
    Category getCategoryById(int catid);
    void addCategory(String CategoryName,String Description);
    void deleteCategory(int catid);
    void updateCategory(int catid,String CategoryName,String Description);
    
    
    ////////////////////////////////////// for brand////////////////////////////////////////////////////////////
     Collection<Brand> getAllBrand();
    Brand getBrandById(int brid);
    void addBrand(String BrandName,String bDescription);
    void deleteBrand(int brid);
    void updateBrand(int brid,String BrandName,String bDescription);
    
    
   ////////////////////////////////////// for product////////////////////////////////////////////////////////
   
     Collection<Products> getAllProducts();
    Products getProductsById(int ProductId);
    void addProducts(int catid,int brid,String prname,String prstatus,int prprice,String prqty,String prdesc,String primage);
    void updateProducts(int prid,int catid,int brid,String prname,String prstatus,int prprice,String prqty,String prdesc,String primage);
    void deleteProducts(int ProductId);
  
     //orders
    //void orderDetail(Integer orderId, Integer PartId, String createdAt, String updatedAt);
    void updateorderStatus(Integer OrderId, String status, String updatedAt);
    Collection<TblOrder> getAllOrders();
    Collection<TblOrder> getOrdersById(Integer orderId);
    Collection<TblOrderdetail> getOrderDetailByOrderId(Integer orderId);
    
      //Users
    Collection<Users> getAllUsers();
    Collection<Users> getUsersByName(String userName);
}
