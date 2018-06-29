/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.DescriptionDAO;
import com.nepitc.mshandloomfrabics.entity.DescriptionModel;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "descriptionDAOImp")
public class DescriptionDAOImp extends GenericDAOImp<DescriptionModel> implements DescriptionDAO {
    
}
