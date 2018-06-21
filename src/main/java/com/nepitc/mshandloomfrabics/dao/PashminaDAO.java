/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import com.nepitc.mshandloomfrabics.entity.Pashmina;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Nishan Dhungana
 */
public interface PashminaDAO extends GenericDAO<Pashmina>{
    List<Pashmina> getAllPashmina(int pageSize, int pageNumber) throws HibernateException;
}
