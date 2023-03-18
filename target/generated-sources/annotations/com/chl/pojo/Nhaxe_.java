package com.chl.pojo;

import com.chl.pojo.Danhgia;
import com.chl.pojo.Giaohang;
import com.chl.pojo.Khoanhaxe;
import com.chl.pojo.Tuyenxe;
import com.chl.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-18T17:15:23")
@StaticMetamodel(Nhaxe.class)
public class Nhaxe_ { 

    public static volatile SetAttribute<Nhaxe, Giaohang> giaohangSet;
    public static volatile SingularAttribute<Nhaxe, String> diachi;
    public static volatile SingularAttribute<Nhaxe, String> sdt;
    public static volatile SingularAttribute<Nhaxe, Users> iduser;
    public static volatile SetAttribute<Nhaxe, Tuyenxe> tuyenxeSet;
    public static volatile SingularAttribute<Nhaxe, Integer> idnx;
    public static volatile SetAttribute<Nhaxe, Danhgia> danhgiaSet;
    public static volatile SetAttribute<Nhaxe, Khoanhaxe> khoanhaxeSet;
    public static volatile SingularAttribute<Nhaxe, String> tennhaxe;
    public static volatile SingularAttribute<Nhaxe, Boolean> giaohang;
    public static volatile SingularAttribute<Nhaxe, String> avatar;
    public static volatile SingularAttribute<Nhaxe, String> email;

}