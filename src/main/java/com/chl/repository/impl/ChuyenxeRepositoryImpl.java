/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.repository.impl;

import com.chl.pojo.Chuyenxe;
import com.chl.repository.ChuyenxeReposity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NC
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class ChuyenxeRepositoryImpl implements ChuyenxeReposity {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Chuyenxe> getChuyenXes(Map<String, String> params, int page) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Chuyenxe> q = b.createQuery(Chuyenxe.class);
        Root root = q.from(Chuyenxe.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("tenchuyenxe").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }
            /*
        String fromPrice = params.get("fromPrice");
        if (fromPrice != null && !fromPrice.isEmpty()) {
            Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Double.class),
                    Double.parseDouble(fromPrice));
            predicates.add(p);
        }

        String toPrice = params.get("toPrice");
        if (toPrice != null && !toPrice.isEmpty()) {
            Predicate p = b.lessThanOrEqualTo(root.get("price").as(Double.class),
                    Double.parseDouble(toPrice));
            predicates.add(p);
        }*/

            String idTX = params.get("idTX");
            if (idTX != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("idTX"), Integer.parseInt(idTX));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[predicates.size()]));

        }

        q.orderBy(b.desc(root.get("idchuyenxe")));
        Query query = s.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size"));
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int count() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Chuyenxe");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean AddOrUpdateCX(Chuyenxe cx) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
              if (cx.getIdchuyenxe()> 0)
                session.update(cx);
            else
                 session.save(cx);
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }

    @Override
    public Chuyenxe getChuyenxeId(int id) {
         Session s = this.factory.getObject().getCurrentSession();
        return s.get(Chuyenxe.class, id);
    }

    @Override
    public boolean delCX(int id) {
        Chuyenxe cx = this.getChuyenxeId(id);
        Session s = this.factory.getObject().getCurrentSession();
        try {
            
            s.delete(cx);
            return true;
        } catch (HibernateException ex) {
            return false;
        }
    }
}
