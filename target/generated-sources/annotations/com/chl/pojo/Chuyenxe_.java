package com.chl.pojo;

import com.chl.pojo.Datve;
import com.chl.pojo.Tuyenxe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-12T14:23:51")
@StaticMetamodel(Chuyenxe.class)
public class Chuyenxe_ { 

    public static volatile SingularAttribute<Chuyenxe, String> tenchuyenxe;
    public static volatile SingularAttribute<Chuyenxe, Integer> giave;
    public static volatile SingularAttribute<Chuyenxe, String> hinhanh;
    public static volatile SingularAttribute<Chuyenxe, Date> ngaydi;
    public static volatile SingularAttribute<Chuyenxe, Integer> idchuyenxe;
    public static volatile SingularAttribute<Chuyenxe, Integer> slve;
    public static volatile SingularAttribute<Chuyenxe, Integer> slvedaban;
    public static volatile SingularAttribute<Chuyenxe, Tuyenxe> idTX;
    public static volatile SetAttribute<Chuyenxe, Datve> datveSet;

}