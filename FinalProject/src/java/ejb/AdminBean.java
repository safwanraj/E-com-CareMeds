/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.*;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author safwan
 */
@Stateless
public class AdminBean implements AdminBeanLocal {
    
     @PersistenceContext(unitName = "ProjectPU")
    EntityManager em;
     
     
      Collection<TblOrder> TblOrder;
    Collection<TblOrderdetail> TblOrderdetail;
    Collection<Users> users;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //    ---------------------------------------Category :--------------------------------------------    
   
    @Override
    public Collection<Category> getAllCategory() 
    {
        System.out.println("Hello in ejvb");
//      EntityManager em1 = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
//        return em.createNamedQuery("Category.findAll").getResultList();
        Collection<Category> temp=em.createNamedQuery("Category.findAll").getResultList();
        for(Category pc:temp){
            System.out.println("get all category Name :"+pc.getCatName());
        }
        return temp;
    }
    
    @Override
    public void addCategory(String CategoryName , String Description) 
    {
        Category category = new Category();
//        category.setCategoryId(photoCategoryId);
        category.setCatName(CategoryName);
        category.setCatDesc(Description);
        
        
        System.out.println("in bean add method");
        em.persist(category);
        
    }

    @Override
    public void updateCategory(int CategoryId , String CategoryName , String Description) 
    {
        Category category = (Category) em.find(Category.class, CategoryId);
        
        category.setCatName(CategoryName);
        category.setCatDesc(Description);
       
//        
        em.merge(category);
        Collection<Category> temp=em.createNamedQuery("Category.findAll").getResultList();
        for(Category pc:temp){
            System.out.println("category"+pc.getCatName());
        }
        Category category1 = (Category) em.find(Category.class, CategoryId);
        System.err.println("updated name : " + category1.getCatName());
        
//        
    }
    
//     public void updateCompany(int CompanyId, String CompanyName, String ContactNo1, String ContactNo2, String EmailId,String AgencyName,String AgencyNumber) {
//        CompanyTB objCompany=(CompanyTB) em.find(CompanyTB.class, CompanyId);
//        objCompany.setCompanyName(CompanyName);
//        objCompany.setContactNo1(ContactNo1);
//        objCompany.setContactNo2(ContactNo2);
//        objCompany.setEmailId(EmailId);
//        objCompany.setAgencyName(AgencyName);
//        objCompany.setAgencyNumber(AgencyNumber);
//        objCompany.setIsActive(true);
//        objCompany.setModifiedOn(new Date());
//        em.merge(objCompany);
//    }
    
    @Override
    public void deleteCategory(int CategoryId) 
    {
        Category category = em.find(Category.class, CategoryId);
        
        em.remove(category);
        
    }
    
    @Override
    public Category getCategoryById(int categoryId)
    {
        return (Category) em.find(Category.class, categoryId);
    }

    
     //    ---------------------------------------Brand :--------------------------------------------    
   
    @Override
    public Collection<Brand> getAllBrand() 
    {
        System.out.println("Hello in ub");
//      EntityManager em1 = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
//        return em.createNamedQuery("Category.findAll").getResultList();
        Collection<Brand> temp=em.createNamedQuery("Brand.findAll").getResultList();
        for(Brand pc:temp){
            System.out.println("get all category Name :"+pc.getBrandName());
        }
        return temp;
    }
    
    @Override
    public void addBrand(String BrandName , String bDescription) 
    {
        Brand brand = new Brand();
//        category.setCategoryId(photoCategoryId);
        brand.setBrandName(BrandName);
        brand.setBrandDesc(bDescription);
        
        
        System.out.println("in bean add method");
        em.persist(brand);
        
    }

    @Override
    public void updateBrand(int brid , String BrandName , String bDescription) 
    {
        Brand brand = (Brand) em.find(Brand.class, brid);
        
        
        brand.setBrandName(BrandName);
        brand.setBrandDesc(bDescription);
        
       
//        
        em.merge(brand);
        Collection<Brand> temp=em.createNamedQuery("Brand.findAll").getResultList();
        for(Brand pc:temp){
            System.out.println("brand"+pc.getBrandName());
        }
        Brand brand1 = (Brand) em.find(Brand.class, brid);
        System.err.println("updated name : " + brand1.getBrandName());
        
//        
    }
    
//     public void updateCompany(int CompanyId, String CompanyName, String ContactNo1, String ContactNo2, String EmailId,String AgencyName,String AgencyNumber) {
//        CompanyTB objCompany=(CompanyTB) em.find(CompanyTB.class, CompanyId);
//        objCompany.setCompanyName(CompanyName);
//        objCompany.setContactNo1(ContactNo1);
//        objCompany.setContactNo2(ContactNo2);
//        objCompany.setEmailId(EmailId);
//        objCompany.setAgencyName(AgencyName);
//        objCompany.setAgencyNumber(AgencyNumber);
//        objCompany.setIsActive(true);
//        objCompany.setModifiedOn(new Date());
//        em.merge(objCompany);
//    }
    
    @Override
    public void deleteBrand(int brid) 
    {
        Brand brand = em.find(Brand.class, brid);
        
        em.remove(brand);
        
    }
    
    @Override
    public Brand getBrandById(int brid)
    {
        return (Brand) em.find(Brand.class, brid);
    }

     
   /////////////////////////////////////////////Products///////////////////////////////////////////////////////////////////
     @Override
    public Collection<Products> getAllProducts() 
    {
        System.out.println("Hello in ub");
//      EntityManager em1 = Persistence.createEntityManagerFactory("ProjectPU").createEntityManager();
//        return em.createNamedQuery("Category.findAll").getResultList();
        Collection<Products> temp=em.createNamedQuery("Products.findAll").getResultList();
        for(Products pc:temp){
            System.out.println("get all Product Name :"+pc.getPrName());
        }
        return temp;
    }
    
    
    
    
    
    @Override
    public void addProducts(int catid,int brid,String prname,String prstatus,int prprice,String prqty,String prdesc,String primage)
    {
    
        
//          Tblemployee e=new Tblemployee();
//        e.setName(name);
//        e.setSalary(salary);
//        
//        Tbldepartment d=em.find(Tbldepartment.class, deptId);
//        Collection<Tblemployee> emplst=d.getTblemployeeCollection();
//        e.setDeptId(d);
//        emplst.add(e);
//        
//        em.merge(d);
//        em.persist(e);

        
        Products prd= new Products();
        Category cid = em.find(Category.class, catid);
        Brand bid = em.find(Brand.class,brid);
        
        Collection<Products> prdforcid= cid.getProductsList();
        Collection<Products> prdforbid=bid.getProductsList();
        
        prd.setCatId(cid);
        prd.setBrId(bid);
        prd.setPrName(prname);
        prd.setPrStatus(prstatus);
        prd.setPrPrice(prprice);
        prd.setPrQty(prqty);
        prd.setPrDesc(prdesc);
        prd.setPrImgpath(primage);
        prdforcid.add(prd);
        prdforbid.add(prd);
        
        em.merge(cid);
        em.merge(bid);
        em.persist(prd);
    
    
    
    
    
    }
    
    @Override
    public void updateProducts(int prid,int catid,int brid,String prname,String prstatus,int prprice,String prqty,String prdesc,String primage){
    
    
//        Photographytips photograohytips = new Photographytips();
//        Tipstype tipstypeid = em.find(Tipstype.class, TipsId);
//        
//        Collection<Photographytips> photograohytipsfortipsid = tipstypeid.getPhotographytipsCollection();
//        
//        photograohytips.setTipsTypeId(tipstypeid);
//        photograohytips.setPhtographyTipsPhotoPath(PhotographyTipsPhoto);
//        photograohytips.setPhotographyTipsDescription(PhotographyTipsDescription);
//        photograohytipsfortipsid.add(photograohytips);
//        
//        
//        em.merge(tipstypeid);
//        em.merge(photograohytips);
        Products prd= new Products();
        Category cid = em.find(Category.class, catid);
        Brand bid = em.find(Brand.class,brid);
        
        Collection<Products> prdforcid= cid.getProductsList();
        Collection<Products> prdforbid=bid.getProductsList();
        
        prd.setPrId(prid);
        prd.setCatId(cid);
        prd.setBrId(bid);
        prd.setPrName(prname);
        prd.setPrStatus(prstatus);
        prd.setPrPrice(prprice);
        prd.setPrQty(prqty);
        prd.setPrDesc(prdesc);
        prd.setPrImgpath(primage);
        prdforcid.add(prd);
        prdforbid.add(prd);
        
        em.merge(cid);
        em.merge(bid);
        em.merge(prd);
    
    
    
    
    
    
    }
    
    
    @Override
    public void deleteProducts(int ProductId)
    {
//   
    
    
    Products prd = em.find(Products.class, ProductId);
        
        em.remove(prd);
    
    
    
    }
    @Override
    public Products getProductsById(int ProductId)
    {
        return (Products) em.find(Products.class, ProductId);
    }
    @Override
    public Collection<TblOrder> getAllOrders() {
        TblOrder = em.createNamedQuery("TblOrder.findAll").getResultList();
        return TblOrder;
    }

    @Override
    public Collection<TblOrder> getOrdersById(Integer orderId) {
        TblOrder = em.createNamedQuery("TblOrder.findByOrderId").setParameter("orderId", orderId).getResultList();
        return TblOrder;
    }

    @Override
    public Collection<TblOrderdetail> getOrderDetailByOrderId(Integer orderId) {
        TblOrderdetail = em.createNamedQuery("TblOrderdetail.findByOrderId").setParameter("orderId", orderId).getResultList();
        return TblOrderdetail;
    }

   

    @Override
    public void updateorderStatus(Integer OrderId, String status, String updatedAt) {
        TblOrder to = em.find(TblOrder.class, OrderId);
        to.setStatus(status);
        to.setUpdatesAt(updatedAt);
        em.merge(to);
    }
    
    ////////////////////////////////////users///////////////////////////////////
    @Override
    public Collection<Users> getAllUsers() {
       // users = em.createNamedQuery("Users.findAll").getResultList();
        
         Collection<Users> temp=em.createNamedQuery("Users.findAll").getResultList();
        return temp;
    }

    @Override
    public Collection<Users> getUsersByName(String userName) {
        List u = em.createNamedQuery("Users.findByEmailId").setParameter("username", userName).getResultList();
        return users;
    }

}
