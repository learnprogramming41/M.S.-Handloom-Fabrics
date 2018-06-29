/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.service;

import com.nepitc.mshandloomfrabics.daoimp.ImageDAOImp;
import com.nepitc.mshandloomfrabics.entity.Image;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nishan Dhungana
 */
@Service(value = "imageService")
public class ImageService implements GenericService<Image>{

    @Autowired
    private ImageDAOImp imageDaoImp;
    
    @Override
    public void insert(Image t) throws HibernateException {
        try {
            imageDaoImp.insert(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public void update(Image t) throws HibernateException {
        try {
            imageDaoImp.update(t);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Image t) throws HibernateException {
        try {
            if(imageDaoImp.delete(t)) {
                return true;
            }
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
        return false;
    }

    @Override
    public Image getById(int id) throws HibernateException {
        try {
            return imageDaoImp.getById(id);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public List<Image> getAll() throws HibernateException {
        try {
            return imageDaoImp.getAll();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
    public List<String> deleteImageFromPashminaId(int pashminaId) throws HibernateException{
        try {
            return imageDaoImp.deleteImageFromPashminaId(pashminaId);
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage());
        }
    }
    
}
