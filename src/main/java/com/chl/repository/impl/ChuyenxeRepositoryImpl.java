/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.repository.impl;

import com.chl.pojo.Chuyenxe;
import com.chl.repository.ChuyenxeReposity;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NC
 */
@Repository
@Transactional
public class ChuyenxeRepositoryImpl implements ChuyenxeReposity{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Chuyenxe> getChuyenXes() {
         Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Chuyenxe");
        return q.getResultList();
    }
    
}
