package entity;

import entity.TblCart;
import entity.TblOrder;
import entity.Userrole;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstName;
    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> gender;
    public static volatile CollectionAttribute<Users, TblOrder> tblOrderCollection;
    public static volatile SingularAttribute<Users, String> contact;
    public static volatile ListAttribute<Users, Userrole> userroleList;
    public static volatile CollectionAttribute<Users, TblCart> tblCartCollection;
    public static volatile SingularAttribute<Users, String> emailId;
    public static volatile SingularAttribute<Users, Integer> userId;

}