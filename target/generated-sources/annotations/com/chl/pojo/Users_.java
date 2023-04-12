package com.chl.pojo;

import com.chl.pojo.Danhgia;
import com.chl.pojo.Datve;
import com.chl.pojo.Nhaxe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-12T14:23:51")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> iduser;
    public static volatile SingularAttribute<Users, Integer> role;
    public static volatile SetAttribute<Users, Danhgia> danhgiaSet;
    public static volatile SingularAttribute<Users, String> pw;
    public static volatile SetAttribute<Users, Nhaxe> nhaxeSet;
    public static volatile SingularAttribute<Users, String> avatar;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SetAttribute<Users, Datve> datveSet;
    public static volatile SingularAttribute<Users, String> username;

}