/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.repository.impl;

import com.chl.pojo.Users;
import com.chl.repository.UserRepository;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author NC
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
     @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    @Transactional
    public Users getUserByUsername(String username) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Users> q = b.createQuery(Users.class);
        Root root = q.from(Users.class);
        q.select(root);
        
        q.where(b.equal(root.get("username"), username));
        
        Query query = s.createQuery(q);
        return (Users) query.getSingleResult();
    }


}
