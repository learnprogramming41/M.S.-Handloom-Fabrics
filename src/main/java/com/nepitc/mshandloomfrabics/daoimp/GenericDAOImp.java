/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */

public abstract class GenericDAOImp<T> implements GenericDAO<T>{

    @Autowired
    protected SessionFactory sessionFactory;
    
    private final Class<T> persistClass;
    protected Session session;
    protected Transaction trans;
    
    public GenericDAOImp() {
        persistClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void insert(T t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        try {
            session.save(t);
            trans.commit();
        } catch (HibernateException  ex) {
            trans.rollback();
            throw new HibernateException(ex.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        try {
            session.update(t);
            trans.commit();
        } catch(HibernateException ex) {
            trans.rollback();
            throw new HibernateException(ex.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(T t) {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        boolean res = false;
        
        try {
            session.delete(t);
            trans.commit();
            res = true;
        } catch(HibernateException ex) {
            trans.rollback();
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
        
        return res;
    }

    @Override
    public T getById(int id) {
        session = sessionFactory.openSession();
        
        T t = null;
        
        try {
            t = (T) session.get(persistClass, id);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
        
        return t;
    }

    @Override
    public List<T> getAll() {
        session = sessionFactory.openSession();
        
        List<T> list = null;
        try {
            Criteria criteria = session.createCriteria(persistClass);
            list = criteria.list();
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        } finally {
            session.close();
        }
        
        return list;
    }
    
}
