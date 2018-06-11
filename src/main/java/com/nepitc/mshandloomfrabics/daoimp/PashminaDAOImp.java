/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.PashminaDAO;
import com.nepitc.mshandloomfrabics.entity.Pashmina;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "pashminaDaoImp")
public class PashminaDAOImp extends GenericDAOImp<Pashmina> implements PashminaDAO{
    
}
