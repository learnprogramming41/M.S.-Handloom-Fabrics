/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_PASHMINA", catalog = "", schema = "NISHAN")
@NamedQueries({
    @NamedQuery(name = "Pashmina.findAll", query = "SELECT p FROM Pashmina p")
    , @NamedQuery(name = "Pashmina.findByPashminaId", query = "SELECT p FROM Pashmina p WHERE p.pashminaId = :pashminaId")
    , @NamedQuery(name = "Pashmina.findByPashminaName", query = "SELECT p FROM Pashmina p WHERE p.pashminaName = :pashminaName")
    , @NamedQuery(name = "Pashmina.findByPrice", query = "SELECT p FROM Pashmina p WHERE p.price = :price")
    , @NamedQuery(name = "Pashmina.findByAddedAt", query = "SELECT p FROM Pashmina p WHERE p.addedAt = :addedAt")
    , @NamedQuery(name = "Pashmina.findByEnabled", query = "SELECT p FROM Pashmina p WHERE p.enabled = :enabled")
    , @NamedQuery(name = "Pashmina.findByCategoryId", query = "SELECT p FROM Pashmina p WHERE p.categoryId = :categoryId")})
public class Pashmina implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "PASHMINA_ID")
    private int pashminaId;
    @Column(name = "PASHMINA_NAME")
    private String pashminaName;
    
    @Column(name = "PRICE")
    private double price;
    
    @Column(name = "ADDED_AT", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedAt;
    
    @Column(name = "ENABLED", insertable = false)
    private Character enabled;
    
    @Column(name = "CATEGORY_ID")
    private int categoryId;

    @OneToMany(mappedBy = "colourId")
    private List<PashminaColour> pashminaColor;
    
    @OneToMany(mappedBy = "imageId")
    private List<Image> images;
    
    @OneToMany(mappedBy = "descriptionId")
    private List<Description> descriptions;
    
    public Pashmina() {
    }

    public Pashmina(int pashminaId) {
        this.pashminaId = pashminaId;
    }

    public Pashmina(int pashminaId, double price, Date addedAt, Character enabled) {
        this.pashminaId = pashminaId;
        this.price = price;
        this.addedAt = addedAt;
        this.enabled = enabled;
    }

    public int getPashminaId() {
        return pashminaId;
    }

    public void setPashminaId(int pashminaId) {
        this.pashminaId = pashminaId;
    }

    public String getPashminaName() {
        return pashminaName;
    }

    public void setPashminaName(String pashminaName) {
        this.pashminaName = pashminaName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<PashminaColour> getPashminaColor() {
        return pashminaColor;
    }

    public void setPashminaColor(List<PashminaColour> pashminaColor) {
        this.pashminaColor = pashminaColor;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }
    
    

}
