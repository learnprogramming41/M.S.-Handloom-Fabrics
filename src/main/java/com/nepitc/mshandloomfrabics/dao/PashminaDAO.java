/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import com.nepitc.mshandloomfrabics.entity.PashminaModel;
import java.util.List;

/**
 *
 * @author Nishan Dhungana
 */

public interface PashminaDAO extends GenericDAO<PashminaModel>{
    List<PashminaModel> getAllPashmina(int pageSize, int pageNumber);
    Long getPashminaCount();
    List<PashminaModel> getPashminaByCategory(String category, int pageSize, int pageNo);
    List<PashminaModel> searchPashmina(String searchText);
}
