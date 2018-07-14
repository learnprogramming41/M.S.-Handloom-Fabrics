/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import com.nepitc.mshandloomfrabics.entity.OrderModel;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Nishan Dhungana
 */
public interface OrderDAO extends GenericDAO<OrderModel>{
    List<OrderModel> getOrderByUserId(int userId) throws HibernateException;
}
