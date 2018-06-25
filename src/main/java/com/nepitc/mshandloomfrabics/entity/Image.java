/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_IMAGE", catalog = "", schema = "NISHAN")
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")
    , @NamedQuery(name = "Image.findByImageId", query = "SELECT i FROM Image i WHERE i.imageId = :imageId")
    , @NamedQuery(name = "Image.findByImageName", query = "SELECT i FROM Image i WHERE i.imageName = :imageName")})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "IMAGE_ID")
    private int imageId;
    
    @Column(name = "IMAGE_NAME")
    private String imageName;
    
    @JoinColumn(name = "PASHMINA_ID", referencedColumnName = "PASHMINA_ID")
    @ManyToOne
    private Pashmina pashmina;

    public Image() {
    }

    public Image(int imageId) {
        this.imageId = imageId;
    }

    public Image(String imageName, Pashmina pashmina) {
        this.imageName = imageName;
        this.pashmina = pashmina;
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

    public void setPashmina(Pashmina pashmina) {
        this.pashmina = pashmina;
    }
}
