package com.chl.pojo;

import com.chl.pojo.Chuyenxe;
import com.chl.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-04T10:03:07")
@StaticMetamodel(Datve.class)
public class Datve_ { 

    public static volatile SingularAttribute<Datve, Users> iduser;
    public static volatile SingularAttribute<Datve, Date> ngaydatve;
    public static volatile SingularAttribute<Datve, Integer> iddatved;
    public static volatile SingularAttribute<Datve, String> statusThanhtoan;
    public static volatile SingularAttribute<Datve, Integer> soluongve;
    public static volatile SingularAttribute<Datve, Boolean> thanhtoanOnl;
    public static volatile SingularAttribute<Datve, Chuyenxe> idchuyenxe;

}