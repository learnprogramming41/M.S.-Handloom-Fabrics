/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.controller;

import com.nepitc.mshandloomfrabics.entity.UserModel;
import com.nepitc.mshandloomfrabics.entity.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nepitc.mshandloomfrabics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
@RequestMapping(value = "/authorization")
public class AuthorizationController {
    
    @Autowired
    UserService adminService;
    
    @RequestMapping(value = "admin/login", method = RequestMethod.GET)
    public ResponseEntity<UserModel> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        LoginModel login = new LoginModel(username, password);
        
        if (username.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            try {
                UserModel admin = adminService.login(login, "ROLE_ADMIN");
                return new ResponseEntity<>(admin, HttpStatus.OK);
            } catch (Exception ex) {
                System.out.println(ex);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
