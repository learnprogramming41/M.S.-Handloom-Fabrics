/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_IMAGE", catalog = "", schema = "NISHAN")
public class ImageModel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "IMAGE_ID")
    private int imageId;
    
    @Column(name = "IMAGE_NAME")
    private String imageName;
    
    @JoinColumn(name = "PASHMINA_ID", referencedColumnName = "PASHMINA_ID")
    @ManyToOne
    private PashminaModel pashmina;
    
    @Column(name = "PUBLIC_ID")
    private String publicId;

    public ImageModel() {
    }

    public ImageModel(int imageId) {
        this.imageId = imageId;
    }

    public ImageModel(String imageName, PashminaModel pashmina, String publicId) {
        this.imageName = imageName;
        this.pashmina = pashmina;
        this.publicId = publicId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
//    public Pashmina getPashmina() {
//        return pashmina;
//    }

    public void setPashmina(PashminaModel pashmina) {
        this.pashmina = pashmina;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
}
