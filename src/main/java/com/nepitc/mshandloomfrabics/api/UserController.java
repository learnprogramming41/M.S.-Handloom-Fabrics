/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.UserModel;
import com.nepitc.mshandloomfrabics.service.UserService;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.nepitc.mshandloomfrabics.entity.UpdatePassword;
/**
 *
 * @author Nishan Dhungana
 */
@Controller
@RequestMapping(value = "/user")

public class UserController {

    @Autowired
    private UserService adminService;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAll() {
        List<UserModel> admin = null;
        try {
            admin = adminService.getAll();
            return new ResponseEntity(admin, HttpStatus.OK);
        } catch (HibernateException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody UserModel admin) {
        try {
            adminService.insert(admin);
            return new ResponseEntity(HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/check-email", method = RequestMethod.GET)
    public ResponseEntity<String> checkAdminEmail(@RequestParam("email") String email) {
        try {
            boolean res = adminService.checkEmailAvailability(email);

            if (res) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

        } catch (HibernateException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/change-password", method = RequestMethod.PUT)
    public ResponseEntity<String> changePassword(@RequestBody UpdatePassword upPass) {
        try {
            adminService.changePassword(upPass.getPassword(), upPass.getUsername());
            return new ResponseEntity(HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
}
