/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.User;
import com.nepitc.mshandloomfrabics.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nishan Dhungana & Barik Ansari
 */
@Controller
@RequestMapping(value = "/user")

public class UserController {
    
    @Autowired
    private UserService adminService;
    
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        List<User> admin = null;
        try {
            admin = adminService.getAll();
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }  
    
    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody User admin) {
        try {
            adminService.insert(admin);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
