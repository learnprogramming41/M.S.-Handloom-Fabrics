/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import com.nepitc.mshandloomfrabics.entity.Admin;
import com.nepitc.mshandloomfrabics.entity.Login;

/**
 *
 * @author Nishan Dhungana
 */
public interface AdminDAO extends GenericDAO<Admin>{
    Admin login(Login login) throws Exception;
}
