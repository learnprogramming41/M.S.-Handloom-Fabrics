/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.PashminaDAO;
import com.nepitc.mshandloomfrabics.entity.Pashmina;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "pashminaDaoImp")
public class PashminaDAOImp extends GenericDAOImp<Pashmina> implements PashminaDAO {

    @Override
    public List<Pashmina> getAllPashmina(int pageSize, int pageNumber) throws HibernateException {
        session = sessionFactory.openSession();

        try {
            String hql = "FROM Pashmina P ORDER BY P.pashminaId ASC";
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
    public Long getPashminaCount() throws HibernateException {
        session = sessionFactory.openSession();
        String hql = "SELECT COUNT(*) FROM Pashmina";
        
        try {
            Query query = session.createQuery(hql);
            return (Long) query.uniqueResult();
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

}
