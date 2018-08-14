/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.PashminaDAOImp;
import com.nepitc.mshandloomfrabics.entity.PashminaModel;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service(value = "pashminaService")
public class PashminaService implements GenericService<PashminaModel> {

    @Autowired
    private PashminaDAOImp pashminaDaoImp;

    @Override
    public void insert(PashminaModel t) {
        try {
            pashminaDaoImp.insert(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public void update(PashminaModel t) {
        try {
            pashminaDaoImp.update(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public boolean delete(PashminaModel t) {
        try {
            if (pashminaDaoImp.delete(t)) {
                return true;
            }
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }

        return false;
    }

    @Override
    public PashminaModel getById(int id) {
        try {
            return pashminaDaoImp.getById(id);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public List<PashminaModel> getAll() {
        try {
            return pashminaDaoImp.getAll();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    public List<PashminaModel> getAllPashmina(int pageSize, int pageNumber) {
        try {
            return pashminaDaoImp.getAllPashmina(pageSize, pageNumber);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    public Long getPashminaCount() {
        try {
            return pashminaDaoImp.getPashminaCount();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    public List<PashminaModel> getPashminaByCategory(String category, int pageSize, int pageNo) {
        try {
            return pashminaDaoImp.getPashminaByCategory(category, pageSize, pageNo);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public List<PashminaModel> searchPashmina(String searchText) {
        try {
            return pashminaDaoImp.searchPashmina(searchText);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
}
