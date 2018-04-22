/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.Admin;
import com.nepitc.mshandloomfrabics.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
@RequestMapping(value = "/api/admin")

public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @RequestMapping(value = "/getAllAdmin", method = RequestMethod.GET)
    public ResponseEntity<List<Admin>> getAll() {
        List<Admin> admin = null;
        try {
            admin = adminService.getAll();
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }  
    
    @RequestMapping(value = "/create-admin", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Admin admin) {
        try {
            adminService.insert(admin);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
