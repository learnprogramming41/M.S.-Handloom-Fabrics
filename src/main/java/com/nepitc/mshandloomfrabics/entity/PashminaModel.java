/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_PASHMINA", catalog = "", schema = "NISHAN")
public class PashminaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_pashmina_id")
    @SequenceGenerator(name = "sq_pashmina_id", sequenceName = "sq_pashmina_id")
    @Column(name = "PASHMINA_ID")
    private int pashminaId;

    @Column(name = "PASHMINA_NAME")
    private String pashminaName;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "ADDED_AT", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedAt;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "ENABLED", insertable = false)
    private Character enabled;

    @OneToMany(mappedBy = "pashmina", fetch = FetchType.EAGER)
    private List<PashminaColourModel> pashminaColor;
    
    @OneToMany(mappedBy = "pashmina", fetch = FetchType.EAGER)
    private List<ImageModel> images;
    
    @OneToMany(mappedBy = "pashmina", fetch = FetchType.EAGER)
    private List<DescriptionModel> descriptions;

    public PashminaModel() {
    }

    public PashminaModel(int pashminaId) {
        this.pashminaId = pashminaId;
    }

    public PashminaModel(int pashminaId, double price, Date addedAt, Character enabled, String category) {
        this.pashminaId = pashminaId;
        this.price = price;
        this.addedAt = addedAt;
        this.enabled = enabled;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<PashminaColourModel> getPashminaColor() {
        return pashminaColor;
    }

    public void setPashminaColor(List<PashminaColourModel> pashminaColor) {
        this.pashminaColor = pashminaColor;
    }

    public List<ImageModel> getImages() {
        return images;
    }

    public void setImages(List<ImageModel> images) {
        this.images = images;
    }

    public List<DescriptionModel> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<DescriptionModel> descriptions) {
        this.descriptions = descriptions;
    }
    
}
