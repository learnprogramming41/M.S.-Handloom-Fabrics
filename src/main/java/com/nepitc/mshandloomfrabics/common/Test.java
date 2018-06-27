/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.common;

import java.io.IOException;



/**
 *
 * @author Nishan Dhungana
 */
public class Test {

    public static void main(String[] args) {
        String imageUrl = "mydxdavmbhkam2mmuumj";
        
        try {
            CloudinaryConfig.deleteImage(imageUrl);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
