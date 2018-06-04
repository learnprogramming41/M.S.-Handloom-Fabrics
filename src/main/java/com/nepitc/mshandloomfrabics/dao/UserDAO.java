/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.dao;

import com.nepitc.mshandloomfrabics.entity.User;
import com.nepitc.mshandloomfrabics.entity.Login;

/**
 *
 * @author Nishan Dhungana
 */
public interface UserDAO extends GenericDAO<User>{
    User login(Login login, String userType) throws Exception;
}
