package entity;

import entity.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> catId;
    public static volatile ListAttribute<Category, Products> productsList;
    public static volatile SingularAttribute<Category, String> catDesc;
    public static volatile SingularAttribute<Category, String> catName;

}