package entity;

import entity.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(Brand.class)
public class Brand_ { 

    public static volatile SingularAttribute<Brand, String> brandName;
    public static volatile ListAttribute<Brand, Products> productsList;
    public static volatile SingularAttribute<Brand, String> brandDesc;
    public static volatile SingularAttribute<Brand, Integer> brandId;

}