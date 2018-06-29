/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.common.CloudinaryConfig;
import com.nepitc.mshandloomfrabics.entity.*;
import com.nepitc.mshandloomfrabics.service.*;
import com.nepitc.mshandloomfrabics.service.PashminaService;
import java.io.IOException;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
@RequestMapping(value = "/admin-api")
public class PashminaController {

    public static int pashminaId = 0;

    @Autowired
    PashminaService pashminaService;

    @Autowired
    PashminaColorService pashminaColorService;

    @Autowired
    DescriptionService descriptionService;
    
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/add-pashmina", method = RequestMethod.POST)
    public @Async ResponseEntity<String> insertPashmina(@RequestBody PashminaModel pashmina) {
        if (pashmina != null) {
            try {
                pashminaService.insert(pashmina);

                pashminaId = pashmina.getPashminaId();

                for (PashminaColourModel pash : pashmina.getPashminaColor()) {
                    pashminaColorService.insert(new PashminaColourModel(pash.getColor(), new PashminaModel(pashminaId)));
                }

                for (DescriptionModel desc : pashmina.getDescriptions()) {
                    descriptionService.insert(new DescriptionModel(desc.getPashminaDescription(), new PashminaModel(pashminaId)));
                }

                return new ResponseEntity<>(HttpStatus.OK);

            } catch (HibernateException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/get-all-pashmina/{pageSize}/{pageNumber}", method = RequestMethod.GET)
    public @Async ResponseEntity<List<PashminaModel>> getAllPashmina(@PathVariable int pageSize, @PathVariable int pageNumber) {
        try {
            Thread.sleep(1000);
            List<PashminaModel> pashmina = pashminaService.getAllPashmina(pageSize, pageNumber);
            return new ResponseEntity<>(pashmina, HttpStatus.OK);
        } catch (HibernateException | InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/get-pashmina-count", method = RequestMethod.GET)
    public @Async ResponseEntity<Long> getPashminaCount() {
        Long count = pashminaService.getPashminaCount();
        System.out.println(count);
        try {
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/delete-pashmina", method = RequestMethod.DELETE)
    public @Async ResponseEntity<Void> deletePashmina(@RequestParam("pashminaId") int pashminaId) {
        if(pashminaId != 0) {
            try {
                List<String> list = imageService.deleteImageFromPashminaId(pashminaId);
                for(String s : list) {
                    CloudinaryConfig.deleteImage(s);
                }
                pashminaService.delete(new PashminaModel(pashminaId));
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (HibernateException | IOException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
}
