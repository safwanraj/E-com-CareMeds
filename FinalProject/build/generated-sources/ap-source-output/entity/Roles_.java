package entity;

import entity.Rolepermission;
import entity.Userrole;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, Integer> roleId;
    public static volatile ListAttribute<Roles, Userrole> userroleList;
    public static volatile SingularAttribute<Roles, String> roleName;
    public static volatile SingularAttribute<Roles, String> description;
    public static volatile ListAttribute<Roles, Rolepermission> rolepermissionList;

}