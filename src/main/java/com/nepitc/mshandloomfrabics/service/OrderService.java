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
    
    public OrderModel getOrderByUserId(int userId) throws HibernateException {
        try {
            return orderDaoImp.getOrderByUserId(userId);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
}
