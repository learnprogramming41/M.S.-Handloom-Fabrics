/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.DescriptionModel;
import com.nepitc.mshandloomfrabics.service.DescriptionService;
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
public class DescriptionController {
    @Autowired
    DescriptionService descriptionService;

    @RequestMapping(value = "/add-description", method = RequestMethod.POST)
    public @Async ResponseEntity addDescription(@RequestBody DescriptionModel descriptionModel) {
        if (descriptionModel != null) {
            try {
                descriptionService.insert(descriptionModel);
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Empty model. Please send me some value", HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/delete-description/{id}", method = RequestMethod.DELETE)
    public @Async ResponseEntity deleteDescription(@PathVariable int id) {
        if (id != 0) {
            try {
                descriptionService.delete(new DescriptionModel(id));
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Id is 0", HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/update-description", method = RequestMethod.PUT)
    public @Async ResponseEntity updateDescription(@RequestBody DescriptionModel descriptionModel) {
        if (descriptionModel != null) {
            try {
                descriptionService.update(descriptionModel);
                return new ResponseEntity(HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Empty model. Please send me some value", HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(value = "/get-description-by-id/{id}", method = RequestMethod.GET)
    public @Async ResponseEntity updateDescription(@PathVariable int id) {
        if (id != 0) {
            try {
                DescriptionModel descriptionModel = descriptionService.getById(id);
                return new ResponseEntity(descriptionModel, HttpStatus.OK);
            } catch (HibernateException e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("Decription id is 0", HttpStatus.NO_CONTENT);
        }
    }
    
}
