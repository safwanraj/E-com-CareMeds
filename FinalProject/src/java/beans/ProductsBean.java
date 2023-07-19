/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;



import clients.ProductsClient;
import ejb.AdminBeanLocal;
import ejb.UserBeanLocal;
import entity.Products;
import entity.Category;
import entity.Brand;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.util.LangUtils;

/**
 *
 * @author safwan
 */
@Named(value = "productsBean")
@ViewScoped
public class ProductsBean implements Serializable{

    /**
     * Creates a new instance of ProductsBean
     */
    public ProductsBean() {
    }
    
   
    @EJB
    UserBeanLocal ubl;
    @EJB
    AdminBeanLocal abl;
    
    int prid,catid,brid,prprice;
    String prname,prstatus,prqty,prdesc,primage;
    UploadedFile file;
     Collection<Category> CollectionCategory;
     Collection<Brand> CollectionBrand;
    Collection<Products> plist;
    Collection<Products> filteredparts;
    ProductsClient pjc= new ProductsClient();
    

    public int getPrid() {
        return prid;
    }

    public void setPrid(int prid) {
        this.prid = prid;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public int getBrid() {
        return brid;
    }

    public void setBrid(int brid) {
        this.brid = brid;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public String getPrstatus() {
        return prstatus;
    }

    public void setPrstatus(String prstatus) {
        this.prstatus = prstatus;
    }

    public Integer getPrprice() {
        return prprice;
    }

    public void setPrprice(Integer prprice) {
        this.prprice = prprice;
    }

    public String getPrqty() {
        return prqty;
    }

    public void setPrqty(String prqty) {
        this.prqty = prqty;
    }

    public String getPrdesc() {
        return prdesc;
    }

    public void setPrdesc(String prdesc) {
        this.prdesc = prdesc;
    }

    public String getPrimage() {
        return primage;
    }

    public void setPrimage(String primage) {
        this.primage = primage;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Collection<Category> getCollectionCategory() {
        return CollectionCategory;
    }

    public void setCollectionCategory(Collection<Category> CollectionCategory) {
        this.CollectionCategory = CollectionCategory;
    }

    public Collection<Brand> getCollectionBrand() {
        return CollectionBrand;
    }

    public void setCollectionBrand(Collection<Brand> CollectionBrand) {
        this.CollectionBrand = CollectionBrand;
    }
     public Collection<Products> getFilteredparts() {
        return filteredparts;
    }

    public void setFilteredparts(Collection<Products> filteredparts) {
        this.filteredparts = filteredparts;
    }
    
    @PostConstruct
    public  void init()
    {
       CollectionCategory=abl.getAllCategory();
       CollectionBrand = abl.getAllBrand();
    }
    public boolean globalfilterfunction(Object value, Object filter, Locale locale){
        String filtertext = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if(LangUtils.isBlank(filtertext)){
            return true;
        }
        Products part = (Products) value;
        return part.getPrName().toLowerCase().contains(filtertext)
                || part.getCatId().getCatName().toLowerCase().contains(filtertext)
                || part.getBrId().getBrandName().toLowerCase().contains(filtertext);
    }
    public Collection<Products> getPlist() {
         Response response = pjc.getAllProducts(Response.class);
        ArrayList<Products> products = new ArrayList<Products>();
        GenericType<Collection<Products>> genericType = new GenericType<Collection<Products>>() {
        };
        products = (ArrayList<Products>) response.readEntity(genericType);
        plist = products;
        return plist;
    }

    public void setPlist(Collection<Products> plist) {
        this.plist = plist;
    }
    
    
     public Collection<Products> getAllProducts()
    {
//        Response response=pjc.getAllProducts(Response.class);
//        ArrayList<Products> prlist=new ArrayList<Products>();
//        GenericType<ArrayList<Products>> gemp=new GenericType<ArrayList<Products>>(){};
//        prlist=(ArrayList<Products>)response.readEntity(gemp);
//        return prlist;
        
        
         System.out.println("in col");
//        return ubl.getAllCategoryName();
            return abl.getAllProducts();
    }
    public String getProductsById(int prId) {
        Response response = pjc.getProductsById(Response.class, prId);
        GenericType<Products> genericType = new GenericType<Products>() {
        };
        Products pr = response.readEntity(genericType);
        this.prid = pr.getPrId();
        this.catid=pr.getCatId().getCatId();
        this.brid=pr.getBrId().getBrandId();
        this.prname=pr.getPrName();
        this.prstatus=pr.getPrStatus();
        this.prprice=pr.getPrPrice();
        this.prqty=pr.getPrQty();
        this.prdesc=pr.getPrDesc();
        this.primage=pr.getPrImgpath();
//    
    

        return "AddProduct.xhtml";
//       
//
//       // System.out.println(CategoryPhotoPath);
    }
    
    
    public String addProducts()
            //throws IOException
    {
//     
        
        
//      
//        if(prid!=0){
//            try (InputStream i = file.getInputStream()) {
//            Products prd = new Products();
//            String path = "C:\\Msc_ict_34\\FinalProjectSem-1\\FinalProject\\web\\Uploads\\Products";
//            primage = file.getFileName();
//            Files.copy(i, new File(path, primage).toPath());
//            prd.setPrId(prid);
//            prd.setCatId(new Category(catid));
//            prd.setBrId(new Brand(brid));
//            prd.setPrName(prname);
//            prd.setPrStatus(prstatus);
//            prd.setPrPrice(prprice);
//            prd.setPrQty(prqty);
//            prd.setPrDesc(prdesc);
//            prd.setPrImgpath(primage);
//            
//            pjc.updateProducts(prd);
//            } catch (Exception e) {
//            System.out.println(e);
//            return "AddProduct.xhtml";
//        }
//        }
//        else{
////       try (
//               InputStream i = file.getInputStream() ;
//            Products prd = new Products();
//            String path = "C:\\Msc_ict_34\\FinalProjectSem-1\\FinalProject\\web\\Uploads\\Products";
//            primage = file.getFileName();
//            Files.copy(i, new File(path, primage).toPath());
        if(prid!=0){
        try (InputStream i = file.getInputStream()) {
            String path ="C:\\Msc_ict_34\\FinalProjectSem-1\\FinalProject\\web\\Uploads\\Products";
            primage = file.getFileName();
            Files.copy(i, new File(path, primage).toPath());
            Products prd= new Products();
            prd.setPrId(prid);
            prd.setCatId(new Category(catid));
            prd.setBrId(new Brand(brid));
            prd.setPrName(prname);
            prd.setPrStatus(prstatus);
            prd.setPrPrice(prprice);
            prd.setPrQty(prqty);
            prd.setPrDesc(prdesc);
            prd.setPrImgpath(primage);
            
           // pjc.addProducts(prd);
           pjc.updateProducts(prid,catid, brid, prname, prstatus, prprice, prqty, prdesc, primage);
          // pjc.addProducts(catid, brid, prname, prstatus, prprice, prqty, prdesc, primage);
         } catch (Exception e) {
            System.out.println(e);
            //return "AddProduct.xhtml";
      }}
        else{ try (InputStream i = file.getInputStream()) {
            String path ="C:\\Msc_ict_34\\FinalProjectSem-1\\FinalProject\\web\\Uploads\\Products";
            primage = file.getFileName();
            Files.copy(i, new File(path, primage).toPath());
            Products prd= new Products();
            
            prd.setCatId(new Category(catid));
            prd.setBrId(new Brand(brid));
            prd.setPrName(prname);
            prd.setPrStatus(prstatus);
            prd.setPrPrice(prprice);
            prd.setPrQty(prqty);
            prd.setPrDesc(prdesc);
            prd.setPrImgpath(primage);
            
           // pjc.addProducts(prd);
           pjc.addProducts(catid, brid, prname, prstatus, prprice, prqty, prdesc, primage);
          // pjc.addProducts(catid, brid, prname, prstatus, prprice, prqty, prdesc, primage);
         } catch (Exception e) {
            System.out.println(e);
            //return "AddProduct.xhtml";
      }
        
            
        }
        
        
//        

        return "ProductDetails.xhtml?faces-redirect=true";
    }
     public void deleteProduct(int prId) {
          // cjc.deleteCategory(Response.class,catId);
       pjc.deleteProducts(Response.class,prId);
        getPlist();
    }
}
