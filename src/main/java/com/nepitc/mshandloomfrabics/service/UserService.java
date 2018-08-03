/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.UserDAOImp;
import com.nepitc.mshandloomfrabics.entity.UserModel;
import com.nepitc.mshandloomfrabics.entity.LoginModel;
import com.nepitc.mshandloomfrabics.entity.UserModel;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service(value = "userService")
public class UserService implements GenericService<UserModel> {

    @Autowired
    private UserDAOImp adminDaoImp;
    
    @Override
    public void insert(UserModel t) {
        try {
            adminDaoImp.insert(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public void update(UserModel t) {
        try {
            adminDaoImp.update(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public boolean delete(UserModel t) {
        try {
            return adminDaoImp.delete(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public UserModel getById(int id) {
        try {
            return adminDaoImp.getById(id);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public List<UserModel> getAll() {
        try {
            return adminDaoImp.getAll();
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
    
    public UserModel login(LoginModel login, String userType) {
        try {
            return adminDaoImp.login(login, userType);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }    
    
    public boolean checkEmailAvailability(String email) {
        try {
            return adminDaoImp.checkEmailAvailability(email);
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
    
    public String getUsername(String email) {
        try {
            return adminDaoImp.getUsername(email);
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
    
    public void changePassword(String password, String username) {
        try {
            adminDaoImp.changePassword(password, username);
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
}
