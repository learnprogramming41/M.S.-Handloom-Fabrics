/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.entity.*;
import com.nepitc.mshandloomfrabics.service.*;
import com.nepitc.mshandloomfrabics.service.PashminaService;
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

    @Async
    @RequestMapping(value = "/add-pashmina", method = RequestMethod.POST)
    public ResponseEntity<String> insertPashmina(@RequestBody Pashmina pashmina) {
        if (pashmina != null) {
            try {
                pashminaService.insert(pashmina);

                pashminaId = pashmina.getPashminaId();

                for (PashminaColour pash : pashmina.getPashminaColor()) {
                    pashminaColorService.insert(new PashminaColour(pash.getColor(), new Pashmina(pashminaId)));
                }

                for (Description desc : pashmina.getDescriptions()) {
                    descriptionService.insert(new Description(desc.getPashminaDescription(), new Pashmina(pashminaId)));
                }

                return new ResponseEntity<>(HttpStatus.OK);

            } catch (HibernateException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    
    @Async 
    @RequestMapping(value = "/get-all-pashmina", method = RequestMethod.GET)
    public ResponseEntity<List<Pashmina>> getAllPashmina() {
        try {
            List<Pashmina> pashmina = pashminaService.getAll();
            return new ResponseEntity<>(pashmina, HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
        
}
