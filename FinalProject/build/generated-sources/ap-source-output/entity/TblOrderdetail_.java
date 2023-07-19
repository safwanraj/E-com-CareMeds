package entity;

import entity.Products;
import entity.TblOrder;
import entity.TblOrderdetailPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-31T11:32:17")
@StaticMetamodel(TblOrderdetail.class)
public class TblOrderdetail_ { 

    public static volatile SingularAttribute<TblOrderdetail, String> createdAt;
    public static volatile SingularAttribute<TblOrderdetail, TblOrder> tblOrder;
    public static volatile SingularAttribute<TblOrderdetail, Integer> qty;
    public static volatile SingularAttribute<TblOrderdetail, TblOrderdetailPK> tblOrderdetailPK;
    public static volatile SingularAttribute<TblOrderdetail, String> updatedAt;
    public static volatile SingularAttribute<TblOrderdetail, Products> products;

}