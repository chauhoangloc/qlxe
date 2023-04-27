package com.chl.pojo;

import com.chl.pojo.Ctdatve;
import com.chl.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-27T15:27:15")
@StaticMetamodel(Datve.class)
public class Datve_ { 

    public static volatile SingularAttribute<Datve, Integer> total;
    public static volatile SingularAttribute<Datve, Users> iduser;
    public static volatile SingularAttribute<Datve, Date> ngaydatve;
    public static volatile SingularAttribute<Datve, Integer> iddatved;
    public static volatile SetAttribute<Datve, Ctdatve> ctdatveSet;

}