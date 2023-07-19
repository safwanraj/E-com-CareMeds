package entity;

import entity.Rolepermission;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(Permission.class)
public class Permission_ { 

    public static volatile SingularAttribute<Permission, Integer> permissionId;
    public static volatile SingularAttribute<Permission, String> permissionGroup;
    public static volatile SingularAttribute<Permission, String> permissionGroup2;
    public static volatile SingularAttribute<Permission, String> description;
    public static volatile SingularAttribute<Permission, String> permissionName;
    public static volatile ListAttribute<Permission, Rolepermission> rolepermissionList;

}