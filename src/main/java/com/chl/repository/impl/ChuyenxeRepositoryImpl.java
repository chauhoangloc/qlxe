/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chl.repository.impl;

import com.chl.pojo.Chuyenxe;
import static com.chl.pojo.Chuyenxe_.idchuyenxe;
import com.chl.repository.ChuyenxeReposity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
@PropertySource("classpath:mesages.properties")
public class ChuyenxeRepositoryImpl implements ChuyenxeReposity {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Override
    public List<Chuyenxe> getChuyenXes(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Chuyenxe> q = b.createQuery(Chuyenxe.class);
        Root root = q.from(Chuyenxe.class);
        q.select(root);

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

        String idchuyenxe = params.get("idchuyenxe");
        if (idchuyenxe != null) {
            Predicate p = b.lessThanOrEqualTo(root.get("idchuyenxe"), Integer.parseInt(idchuyenxe));
            predicates.add(p);
        }

        q.where(predicates.toArray(new Predicate[predicates.size()]));



        q.orderBy(b.desc(root.get("idchuyenxe")));
        Query query = s.createQuery(q);
        

        return query.getResultList();
    }
}