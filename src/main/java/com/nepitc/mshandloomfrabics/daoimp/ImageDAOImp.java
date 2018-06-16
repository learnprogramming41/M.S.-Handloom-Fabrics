/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.daoimp;

import com.nepitc.mshandloomfrabics.dao.ImageDAO;
import com.nepitc.mshandloomfrabics.entity.Image;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "imageDaoImp")
public class ImageDAOImp extends GenericDAOImp<Image> implements ImageDAO{
    
}
