/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.OrderDAO;
import com.nepitc.mshandloomfrabics.entity.OrderModel;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository("orderDaoImp")
public class OrderDAOImp extends GenericDAOImp<OrderModel> implements OrderDAO{

    @Override
    public List<OrderModel> getOrderByUserId(int userId) throws HibernateException {
        session = sessionFactory.openSession();
        
        try {
            final String hql = "FROM OrderModel WHERE userId.userId =:userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", userId);
            
            return query.list();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public Long getPashminaCount() throws HibernateException {
        session = sessionFactory.openSession();
        
        try {
            final String hql = "SELECT COUNT(*) FROM OrderModel WHERE status=0";
            
            Query query = session.createQuery(hql);
            return (Long) query.uniqueResult();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public List<OrderModel> getAllOrders() throws HibernateException {
        session = sessionFactory.openSession();
        
        try {
            final String hql = "FROM OrderModel WHERE status=:status";
            Query query = session.createQuery(hql);
            query.setParameter("status", "0");
            
            return query.list();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public void updateOrderStatus(int orderId) throws HibernateException {
        session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        try {
            final String hql = "UPDATE OrderModel SET status=:status WHERE orderId=:orderId";
            Query query = session.createQuery(hql);
            query.setParameter("status", "1");
            query.setParameter("orderId", orderId);
            query.executeUpdate();
            
            trans.commit();
        } catch (HibernateException e) {
            trans.rollback();
            throw new HibernateException(e.getMessage());
        }
    }
    
}
