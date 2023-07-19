package entity;

import entity.Roles;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(Userrole.class)
public class Userrole_ { 

    public static volatile SingularAttribute<Userrole, Roles> roleId;
    public static volatile SingularAttribute<Userrole, Integer> userRoleId;
    public static volatile SingularAttribute<Userrole, Users> userId;

}