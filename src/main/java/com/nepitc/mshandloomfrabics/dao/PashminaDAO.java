/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import com.nepitc.mshandloomfrabics.entity.PashminaModel;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Nishan Dhungana
 */

public interface PashminaDAO extends GenericDAO<PashminaModel>{
    List<PashminaModel> getAllPashmina(int pageSize, int pageNumber) throws HibernateException;
    Long getPashminaCount() throws HibernateException;
    List<PashminaModel> getPashminaByCategory(String category, int pageSize, int pageNo) throws HibernateException;
    List<PashminaModel> searchPashmina(String searchText) throws HibernateException;
}
