/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.UserDAOImp;
import com.nepitc.mshandloomfrabics.entity.User;
import com.nepitc.mshandloomfrabics.entity.Login;
import com.nepitc.mshandloomfrabics.entity.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service(value = "userService")
public class UserService implements GenericService<User> {

    @Autowired
    private UserDAOImp adminDaoImp;
    
    @Override
    public void insert(User t) throws Exception {
        try {
            adminDaoImp.insert(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public void update(User t) throws Exception {
        try {
            adminDaoImp.update(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public boolean delete(User t) throws Exception {
        try {
            return adminDaoImp.delete(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public User getById(int id) throws Exception {
        try {
            return adminDaoImp.getById(id);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public List<User> getAll() throws Exception {
        try {
            return adminDaoImp.getAll();
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
    
    public User login(Login login, String userType) throws Exception {
        try {
            return adminDaoImp.login(login, userType);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }    
    
    public boolean checkEmailAvailability(String email) throws Exception {
        try {
            return adminDaoImp.checkEmailAvailability(email);
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
}
