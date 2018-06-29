/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.DescriptionDAOImp;
import com.nepitc.mshandloomfrabics.entity.Description;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service(value = "descriptionService")
public class DescriptionService implements GenericService<Description>{

    @Autowired
    DescriptionDAOImp descriptionDaoImp;
    
    @Override
    public void insert(Description t) throws HibernateException {
        try {
            descriptionDaoImp.insert(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public void update(Description t) throws HibernateException {
        try {
            descriptionDaoImp.update(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Description t) throws HibernateException {
        try {
            if(descriptionDaoImp.delete(t)) {
                return true;
            }
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
        
        return false;
    }

    @Override
    public Description getById(int id) throws HibernateException {
        try {
            return descriptionDaoImp.getById(id);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public List<Description> getAll() throws HibernateException {
        try {
            return descriptionDaoImp.getAll();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
}
