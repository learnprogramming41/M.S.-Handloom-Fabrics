/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.OrderModel;
import com.nepitc.mshandloomfrabics.service.OrderService;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nishan Dhungana
 */
@Controller

public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/api/order-pashmina", method = RequestMethod.POST)
    public ResponseEntity orderPashmina(@RequestBody OrderModel orderModel) {
        try {
            if (orderModel == null) {
                return new ResponseEntity("Order can't be null.", HttpStatus.NO_CONTENT);
            } else {
                orderService.insert(orderModel);
                return new ResponseEntity(HttpStatus.CREATED);
            }
        } catch (HibernateException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/cancel-order/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity cancelOrder(@PathVariable Integer orderId) {
        if (orderId != 0) {
            try {
                orderService.delete(new OrderModel(orderId));
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Pashmina id id 0", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/api/update-order", method = RequestMethod.PUT)
    public ResponseEntity cancelOrder(@RequestBody OrderModel orderModel) {
        try {
            if (orderModel == null) {
                return new ResponseEntity("Order can't be null.", HttpStatus.NO_CONTENT);
            } else {
                orderService.update(orderModel);
                return new ResponseEntity(HttpStatus.OK);
            }
        } catch (HibernateException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/get-order-by-user/{id}", method = RequestMethod.GET)
    public ResponseEntity getOrderByUser(@PathVariable("id") int userId) {
        if (userId != 0) {
            try {
                List<OrderModel> list = orderService.getOrderByUserId(userId);
                return new ResponseEntity(list, HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("User doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/admin-api/get-order-count", method = RequestMethod.GET)
    public ResponseEntity getPashminaCount() {
        try {
            return new ResponseEntity(orderService.getPashminaCount(), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/admin-api/get-all-order", method = RequestMethod.GET)
    public ResponseEntity getAllOrders() {
        try {
            List<OrderModel> order = orderService.getAllOrders();
            return new ResponseEntity(order, HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/admin-api/get-order-by-order-id/{orderId}", method = RequestMethod.GET)
    public ResponseEntity getOrderByOrderId(@PathVariable("orderId") int orderId) {
        if (orderId != 0) {
            try {
                OrderModel order = orderService.getById(orderId);
                return new ResponseEntity(order, HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Order id cann't be null", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/admin-api/confirmed-order", method = RequestMethod.GET)
    public ResponseEntity getAllConfirmedOrders() {
        List<OrderModel> list = orderService.confirmedOrders();

        if (list.isEmpty()) {
            return new ResponseEntity("List of confirmed order is empty", HttpStatus.NO_CONTENT);
        } else {
            try {
                return new ResponseEntity(list, HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
    }

    @RequestMapping(value = "/admin-api/history", method = RequestMethod.GET)
    public ResponseEntity history() {
        List<OrderModel> orderModel = orderService.history();

        if (!orderModel.isEmpty()) {
            try {

                return new ResponseEntity(orderModel, HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("List of history is empty", HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/admin-api/shipped-order/{orderId}", method = RequestMethod.GET)
    public ResponseEntity shippedOrder(@PathVariable("orderId") int orderId) {
        if (orderId != 0) {
            try {
                orderService.shippedItem(orderId);
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Order Id cann't be null", HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/admin-api/delete-history/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteHistory(@PathVariable("orderId") int orderId){
        if (orderId != 0) {
            try {
                orderService.delete(new OrderModel(orderId));
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Order Id cann't be null", HttpStatus.BAD_REQUEST);
        }
    }
}
