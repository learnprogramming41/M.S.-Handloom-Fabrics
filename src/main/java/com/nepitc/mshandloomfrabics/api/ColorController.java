/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.PashminaColourModel;
import com.nepitc.mshandloomfrabics.service.PashminaColorService;
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
@RequestMapping(value = "/admin-api")
public class ColorController {

    @Autowired
    PashminaColorService pashminaColorService;

    @RequestMapping(value = "/add-color", method = RequestMethod.POST)
    public @Async ResponseEntity addDescription(@RequestBody PashminaColourModel pashminaColourModel) {
        if (pashminaColourModel != null) {
            try {
                pashminaColorService.insert(pashminaColourModel);
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Empty model. Please send me some value", HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/delete-color/{id}", method = RequestMethod.DELETE)
    public @Async ResponseEntity deleteDescription(@PathVariable int id) {
        if (id != 0) {
            try {
                pashminaColorService.delete(new PashminaColourModel(id));
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Id is 0", HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/update-color", method = RequestMethod.PUT)
    public @Async ResponseEntity updateDescription(@RequestBody PashminaColourModel pashminaColourModel) {
        if (pashminaColourModel != null) {
            try {
                pashminaColorService.update(pashminaColourModel);
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Empty model. Please send me some value", HttpStatus.NO_CONTENT);
        }
    }
    
    
}
