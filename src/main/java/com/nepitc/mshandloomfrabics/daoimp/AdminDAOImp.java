/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.AdminDAO;
import com.nepitc.mshandloomfrabics.entity.Admin;
import com.nepitc.mshandloomfrabics.entity.Login;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value="adminDaoImp")
public class AdminDAOImp extends GenericDAOImp<Admin> implements AdminDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;
    
    @Override
    public Admin login(Login login) throws Exception {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        Admin admin = null;
        final String sql = "SELECT a FROM Admin a WHERE username=:username AND password=:pass";
            
        try {
            Query query = session.createQuery(sql);
            query.setParameter("username", login.getUsername());
            query.setParameter("pass", login.getPassword());
            
            trans.commit();
            admin = (Admin) query.uniqueResult();
            return admin;
        } catch(HibernateException ex) {
            trans.rollback();
            throw new Exception(ex);
        } finally {
            session.close();
        }
    }
    
}
