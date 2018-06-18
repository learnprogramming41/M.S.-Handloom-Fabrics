/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.common;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nishan Dhungana
 */
public class CloudinaryConfig {

    public static String uploadImage(File imageUrl) throws IOException {
        Map config = new HashMap();
        config.put("cloud_name", "nishan");
        config.put("api_key", "783919866387176");
        config.put("api_secret", "pHP10qTSV58uvl71AikCLQmJV4Q");
        Cloudinary cloudinary = new Cloudinary(config);

        Map uploadResult = cloudinary.uploader().upload(imageUrl, ObjectUtils.emptyMap());

        return (String) uploadResult.get("url");
    }
}
