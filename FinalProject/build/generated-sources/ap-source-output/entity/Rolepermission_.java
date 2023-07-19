package entity;

import entity.Permission;
import entity.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(Rolepermission.class)
public class Rolepermission_ { 

    public static volatile SingularAttribute<Rolepermission, Integer> rolePermissionId;
    public static volatile SingularAttribute<Rolepermission, Permission> permissionId;
    public static volatile SingularAttribute<Rolepermission, Roles> roleId;

}