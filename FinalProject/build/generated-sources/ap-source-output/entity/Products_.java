package entity;

import entity.Brand;
import entity.Category;
import entity.TblCart;
import entity.TblOrderdetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, Category> catId;
    public static volatile SingularAttribute<Products, Brand> brId;
    public static volatile SingularAttribute<Products, String> prDesc;
    public static volatile SingularAttribute<Products, String> prName;
    public static volatile SingularAttribute<Products, String> prStatus;
    public static volatile SingularAttribute<Products, Integer> prPrice;
    public static volatile SingularAttribute<Products, Integer> prId;
    public static volatile CollectionAttribute<Products, TblCart> tblCartCollection;
    public static volatile SingularAttribute<Products, String> prQty;
    public static volatile SingularAttribute<Products, String> prImgpath;
    public static volatile CollectionAttribute<Products, TblOrderdetail> tblOrderdetailCollection;

}