/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.common.CloudinaryConfig;
import com.nepitc.mshandloomfrabics.entity.Description;
import com.nepitc.mshandloomfrabics.entity.Image;
import com.nepitc.mshandloomfrabics.entity.Pashmina;
import com.nepitc.mshandloomfrabics.entity.PashminaColour;
import com.nepitc.mshandloomfrabics.service.DescriptionService;
import com.nepitc.mshandloomfrabics.service.ImageService;
import com.nepitc.mshandloomfrabics.service.PashminaColorService;
import com.nepitc.mshandloomfrabics.service.PashminaService;
import java.io.IOException;
import java.util.Date;
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

    @Autowired
    PashminaService pashminaService;

    @Autowired
    PashminaColorService pashminaColorService;

    @Autowired
    DescriptionService descriptionService;

    @Autowired
    ImageService imageService;

    @Async
    @RequestMapping(value = "/add-pashmina", method = RequestMethod.POST)
    public ResponseEntity<String> insertPashmina(@RequestBody Pashmina pashmina) {
        if (pashmina != null) {
            try {
                pashminaService.insert(pashmina);

                int pashminaId = pashmina.getPashminaId();

                for (PashminaColour pash : pashmina.getPashminaColor()) {
                    pash.setPashminaId(pashminaId);
                    //pashminaColorService.insert(pash);
                }

                for (Description desc : pashmina.getDescriptions()) {
                    desc.setPashminaId(pashminaId);
                    descriptionService.insert(desc);
                }

                for (Image image : pashmina.getImages()) {
                    String imageUrl = image.getImageName();
                    String imageName = "";
                    try {
                        imageName = CloudinaryConfig.uploadImage(imageUrl);
                    } catch (IOException e) {
                        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
                    }
                    
                    image.setPashminaId(pashminaId);
                    image.setImageName(imageName);
                    imageService.insert(image);
                    
                }

                return new ResponseEntity<>(HttpStatus.OK);

            } catch (HibernateException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
