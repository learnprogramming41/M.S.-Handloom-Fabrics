/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.AdminDAOImp;
import com.nepitc.mshandloomfrabics.entity.Admin;
import com.nepitc.mshandloomfrabics.entity.Login;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service(value = "adminService")
public class AdminService implements GenericService<Admin> {

    @Autowired
    private AdminDAOImp adminDaoImp;
    
    @Override
    public void insert(Admin t) throws Exception {
        try {
            adminDaoImp.insert(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public void update(Admin t) throws Exception {
        try {
            adminDaoImp.update(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public boolean delete(Admin t) throws Exception {
        try {
            return adminDaoImp.delete(t);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public Admin getById(int id) throws Exception {
        try {
            return adminDaoImp.getById(id);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public List<Admin> getAll() throws Exception {
        try {
            return adminDaoImp.getAll();
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }
    
    public Admin login(Login login) throws Exception {
        try {
            return adminDaoImp.login(login);
        } catch(HibernateException ex) {
            throw new HibernateException(ex);
        }
    }    
}
