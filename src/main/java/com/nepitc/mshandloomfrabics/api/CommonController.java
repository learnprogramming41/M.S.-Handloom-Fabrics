/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.PashminaModel;
import com.nepitc.mshandloomfrabics.entity.UserModel;
import com.nepitc.mshandloomfrabics.service.PashminaService;
import com.nepitc.mshandloomfrabics.service.UserService;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
@RequestMapping(value = "/pashmina")
public class CommonController {

    @Autowired
    PashminaService pashminaService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/get-pashmina/{pageSize}/{pageNumber}", method = RequestMethod.GET)
    public @Async
    ResponseEntity getAllPashmina(@PathVariable int pageSize, @PathVariable int pageNumber) {
        try {
            Thread.sleep(1000);
            List<PashminaModel> pashmina = pashminaService.getAllPashmina(pageSize, pageNumber);
            return new ResponseEntity<>(pashmina, HttpStatus.OK);
        } catch (HibernateException | InterruptedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/get-pashmina-by-id/{pashminaId}", method = RequestMethod.GET)
    public @Async
    ResponseEntity<PashminaModel> getPashminaById(@PathVariable int pashminaId) {
        try {
            return new ResponseEntity<>(pashminaService.getById(pashminaId), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/create-account", method = RequestMethod.POST)
    public @Async
    ResponseEntity createAccount(@RequestBody UserModel user) {
        user.setUserType("user");
        if (user.getEmail() == null || user.getUsername() == null || user.getPassword() == null) {
            return new ResponseEntity("Email, username and password cann't be empty", HttpStatus.NO_CONTENT);
        } else {
            try {
                userService.insert(user);
                return new ResponseEntity(HttpStatus.CREATED);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
    }
}
