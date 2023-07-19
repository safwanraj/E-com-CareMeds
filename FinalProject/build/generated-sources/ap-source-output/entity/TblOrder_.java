package entity;

import entity.TblOrderdetail;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(TblOrder.class)
public class TblOrder_ { 

    public static volatile SingularAttribute<TblOrder, Integer> pincode;
    public static volatile SingularAttribute<TblOrder, String> ispay;
    public static volatile SingularAttribute<TblOrder, Integer> orderId;
    public static volatile CollectionAttribute<TblOrder, TblOrderdetail> tblOrderdetailList;
    public static volatile SingularAttribute<TblOrder, String> updatesAt;
    public static volatile SingularAttribute<TblOrder, Users> userId;
    public static volatile SingularAttribute<TblOrder, String> orderDatetime;
    public static volatile SingularAttribute<TblOrder, Integer> totalPayment;
    public static volatile SingularAttribute<TblOrder, String> paymode;
    public static volatile SingularAttribute<TblOrder, String> addressline2;
    public static volatile SingularAttribute<TblOrder, String> addressline1;
    public static volatile SingularAttribute<TblOrder, String> landmark;
    public static volatile SingularAttribute<TblOrder, String> status;

}