/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.api;

import com.nepitc.mshandloomfrabics.common.CloudinaryConfig;
import com.nepitc.mshandloomfrabics.entity.Image;
import com.nepitc.mshandloomfrabics.entity.Pashmina;
import com.nepitc.mshandloomfrabics.service.ImageService;
import java.io.File;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
@RequestMapping(value = "/admin-api")
public class ImageController {

    @Autowired
    ImageService imageService;
    
    @Async
    @RequestMapping(value = "/image-upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile[] files) {
        if (files != null || PashminaController.pashminaId != 0) {
            for (MultipartFile f : files) {
                try {
                    File file = new File(f.getOriginalFilename());
                    f.transferTo(file);
                    String imageUrl = CloudinaryConfig.uploadImage(file);
                    Pashmina pashmina = new Pashmina(PashminaController.pashminaId);
                    imageService.insert(new Image(imageUrl, pashmina));
                } catch (IOException | HibernateException e) {
                    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
                }
            }

            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
