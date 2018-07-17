/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.OrderDAOImp;
import com.nepitc.mshandloomfrabics.entity.OrderModel;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service("orderService")
public class OrderService implements GenericService<OrderModel>{

    @Autowired
    private OrderDAOImp orderDaoImp;
    
    @Override
    public void insert(OrderModel t) throws HibernateException {
        try {
            orderDaoImp.insert(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public void update(OrderModel t) throws HibernateException {
        try {
            orderDaoImp.update(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public boolean delete(OrderModel t) throws HibernateException {
        try {
            orderDaoImp.delete(t);
            return true;
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public OrderModel getById(int id) throws HibernateException {
        try {
            return orderDaoImp.getById(id);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public List<OrderModel> getAll() throws HibernateException {
        try {
            return orderDaoImp.getAll();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public List<OrderModel> getOrderByUserId(int userId) throws HibernateException {
        try {
            return orderDaoImp.getOrderByUserId(userId);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public Long getPashminaCount() throws HibernateException {
        try {
            return orderDaoImp.getPashminaCount();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public List<OrderModel> getAllOrders() throws HibernateException {
        try {
            return orderDaoImp.getAllOrders();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public void updateOrderStatus(int orderId) throws HibernateException {
        try {
            orderDaoImp.updateOrderStatus(orderId);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public List<OrderModel> confirmedOrders() throws HibernateException {
        try {
            return orderDaoImp.confirmedOrders();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public List<OrderModel> history() throws HibernateException {
        try {
           return orderDaoImp.history();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public void shippedItem(int orderId) throws HibernateException {
        try {
            orderDaoImp.shippedItem(orderId);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

}
