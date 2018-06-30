/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.DescriptionDAOImp;
import com.nepitc.mshandloomfrabics.entity.DescriptionModel;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service(value = "descriptionService")
public class DescriptionService implements GenericService<DescriptionModel>{

    @Autowired
    DescriptionDAOImp descriptionDaoImp;
    
    @Override
    public void insert(DescriptionModel t) throws HibernateException {
        try {
            descriptionDaoImp.insert(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public void update(DescriptionModel t) throws HibernateException {
        try {
            descriptionDaoImp.update(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public boolean delete(DescriptionModel t) throws HibernateException {
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
    public DescriptionModel getById(int id) throws HibernateException {
        try {
            return descriptionDaoImp.getById(id);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public List<DescriptionModel> getAll() throws HibernateException {
        try {
            return descriptionDaoImp.getAll();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
}
