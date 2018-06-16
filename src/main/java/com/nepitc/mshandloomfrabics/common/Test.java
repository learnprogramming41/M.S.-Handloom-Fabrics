/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.common;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nishan Dhungana
 */
public class Test {

    public static void main(String[] args) {
        try {
            Map config = new HashMap();
            config.put("cloud_name", "nishan");
            config.put("api_key", "783919866387176");
            config.put("api_secret", "pHP10qTSV58uvl71AikCLQmJV4Q");
            Cloudinary cloudinary = new Cloudinary(config);
            
            Map uploadResult = cloudinary.uploader().upload("C:\\Users\\Nishan Dhungana\\Pictures\\Screenshots\\Screenshot(3).png", ObjectUtils.emptyMap());
            
            System.out.println(uploadResult.get("url"));
            
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
}
