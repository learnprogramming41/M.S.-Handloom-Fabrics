/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.OrderModel;
import com.nepitc.mshandloomfrabics.service.OrderService;
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
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order-pashmina", method = RequestMethod.POST)
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

    @RequestMapping(value = "/cancel-order/{orderId}", method = RequestMethod.DELETE)
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

    @RequestMapping(value = "/update-order", method = RequestMethod.PUT)
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

    @RequestMapping(value = "/get-order-by-user/{id}", method = RequestMethod.GET)
    public ResponseEntity getOrderByUser(@PathVariable("id") int userId) {
        if (userId != 0) {
            try {
                return new ResponseEntity(orderService.getOrderByUserId(userId), HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("User doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}
