/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    , @NamedQuery(name = "Pashmina.findByEnabled", query = "SELECT p FROM Pashmina p WHERE p.enabled = :enabled")})
public class Pashmina implements Serializable {

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

    @OneToMany(mappedBy = "colourId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private Set<PashminaColour> pashminaColor  = new HashSet<PashminaColour>();

    @OneToMany(mappedBy = "imageId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private Set<Image> images  = new HashSet<Image>();

    @OneToMany(mappedBy = "descriptionId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private Set<Description> descriptions  = new HashSet<Description>();

    public Pashmina() {
    }

    public Pashmina(int pashminaId) {
        this.pashminaId = pashminaId;
    }

    public Pashmina(int pashminaId, double price, Date addedAt, Character enabled, String category) {
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

    @JsonManagedReference
    public Set<PashminaColour> getPashminaColor() {
        return pashminaColor;
    }

    public void setPashminaColor(Set<PashminaColour> pashminaColor) {
        this.pashminaColor = pashminaColor;
    }

    @JsonManagedReference
    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @JsonManagedReference
    public Set<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Set<Description> descriptions) {
        this.descriptions = descriptions;
    }

}
