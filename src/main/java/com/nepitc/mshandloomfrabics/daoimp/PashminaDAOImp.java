/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.PashminaDAO;
import com.nepitc.mshandloomfrabics.entity.PashminaModel;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "pashminaDAO")
public class PashminaDAOImp extends GenericDAOImp<PashminaModel> implements PashminaDAO {

    @Override
    public List<PashminaModel> getAllPashmina(int pageSize, int pageNumber) {
        session = sessionFactory.openSession();

        try {
            String hql = "FROM PashminaModel P ORDER BY P.addedAt DESC";
            Query query = session.createQuery(hql);
            query.setFirstResult(pageNumber);
            query.setMaxResults(pageSize);

            return query.list();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public Long getPashminaCount() {
        session = sessionFactory.openSession();
        String hql = "SELECT COUNT(*) FROM PashminaModel";
        
        try {
            Query query = session.createQuery(hql);
            return (Long) query.uniqueResult();
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public List<PashminaModel> getPashminaByCategory(String category, int pageSize, int pageNo) {
        Session sess = sessionFactory.openSession();
        final String hql = "FROM PashminaModel WHERE category=:category";
        try {
            Query query = sess.createQuery(hql);
            query.setParameter("category", category);
            query.setFirstResult(pageSize);
            query.setMaxResults(pageNo);

            return query.list();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        } finally {
            sess.close();
        }
    }

    @Override
    public List<PashminaModel> searchPashmina(String searchText) {
        session = sessionFactory.openSession();
        
        try {
            final String hql = "FROM PashminaModel WHERE pashminaName LIKE %:pashminaName%";
            
            Query query = session.createQuery(hql);
            query.setParameter("pashminaName", searchText);
            
            return query.list();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

}
