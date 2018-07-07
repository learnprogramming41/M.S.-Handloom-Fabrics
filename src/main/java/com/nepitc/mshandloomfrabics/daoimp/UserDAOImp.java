/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.UserDAO;
import com.nepitc.mshandloomfrabics.entity.UserModel;
import com.nepitc.mshandloomfrabics.entity.Login;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value="adminDaoImp")
public class UserDAOImp extends GenericDAOImp<UserModel> implements UserDAO{

    @Override
    public UserModel login(Login login, String userType) throws HibernateException {
        session = sessionFactory.openSession();
        
        UserModel admin = null;
        final String hql = "SELECT u FROM User u, UserRole ur WHERE u.username = ur.username AND u.username = :username AND u.password = :password AND ur.userRole = :ust";
        
        try {
            Query query = session.createQuery(hql);
            query.setParameter("username", login.getUsername());
            query.setParameter("password", login.getPassword());
            query.setParameter("ust", userType);
            
            admin = (UserModel) query.uniqueResult();
            return admin;
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean checkEmailAvailability(String email) throws HibernateException {
        session = sessionFactory.openSession();
        final String hql = "SELECT u FROM User u WHERE email=:email";
        boolean res = false;
        
        try {
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            
            if(query.list().size() > 0) {
                res = true;
            }
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
        
        return res;
    }

    @Override
    public String getUsername(String email) throws HibernateException {
        session = sessionFactory.openSession();
        final String hql = "SELECT username FROM User u WHERE email=:email";
        
        try {
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            
            return (String) query.uniqueResult();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void changePassword(String password, String username) throws HibernateException {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        final String hql = "UPDATE User SET password=:password WHERE username=:username";
        
        try {
            Query query = session.createQuery(hql);
            query.setParameter("password", password);
            query.setParameter("username", username);
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            session.close();
        }
    }
    
}
