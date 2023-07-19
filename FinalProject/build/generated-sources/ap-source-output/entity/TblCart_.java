package entity;

import entity.Products;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(TblCart.class)
public class TblCart_ { 

    public static volatile SingularAttribute<TblCart, String> createdAt;
    public static volatile SingularAttribute<TblCart, Integer> cartId;
    public static volatile SingularAttribute<TblCart, Integer> qty;
    public static volatile SingularAttribute<TblCart, Products> prId;
    public static volatile SingularAttribute<TblCart, Users> userId;
    public static volatile SingularAttribute<TblCart, String> updatedAt;

}