/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import com.nepitc.mshandloomfrabics.entity.OrderModel;
import java.util.List;

/**
 *
 * @author Nishan Dhungana
 */
public interface OrderDAO extends GenericDAO<OrderModel>{
    List<OrderModel> getOrderByUserId(int userId);
    Long getPashminaCount();
    void updateOrderStatus(int orderId);
    List<OrderModel> getAllOrders();
    List<OrderModel> confirmedOrders();
    List<OrderModel> history();
    void shippedItem(int orderId);
}
