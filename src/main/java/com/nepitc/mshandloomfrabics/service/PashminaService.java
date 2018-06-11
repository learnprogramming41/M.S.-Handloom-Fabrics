/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.PashminaDAOImp;
import com.nepitc.mshandloomfrabics.entity.Pashmina;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service(value = "pashminaService")
public class PashminaService implements GenericService<Pashmina> {

    @Autowired
    private PashminaDAOImp pashminaDaoImp;

    @Override
    public void insert(Pashmina t) throws HibernateException {
        try {
            pashminaDaoImp.insert(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public void update(Pashmina t) throws HibernateException {
        try {
            pashminaDaoImp.update(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Pashmina t) throws HibernateException {
        try {
            if(pashminaDaoImp.delete(t)) {
                return true;
            }
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
        
        return false;
    }

    @Override
    public Pashmina getById(int id) throws HibernateException {
        try {
            return pashminaDaoImp.getById(id);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public List<Pashmina> getAll() throws HibernateException {
        try {
            return pashminaDaoImp.getAll();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

}
