/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name = "TBL_PASHMINA_COLOUR", catalog = "", schema = "NISHAN")

@NamedQueries({
    @NamedQuery(name = "PashminaColour.findAll", query = "SELECT p FROM PashminaColour p")
    , @NamedQuery(name = "PashminaColour.findByColourId", query = "SELECT p FROM PashminaColour p WHERE p.colourId = :colourId")
    , @NamedQuery(name = "PashminaColour.findByColor", query = "SELECT p FROM PashminaColour p WHERE p.color = :color")})
public class PashminaColour implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "COLOUR_ID", insertable = false)
    private int colourId;
    @Column(name = "COLOR")
    private String color;
    
    @JoinColumn(name = "PASHMINA_ID", referencedColumnName = "PASHMINA_ID")
    @ManyToOne
    @JsonBackReference
    private Pashmina pashmina;

    public PashminaColour() {
    }

    public PashminaColour(int colourId) {
        this.colourId = colourId;
    }

    public PashminaColour(String color, Pashmina pashmina) {
        this.color = color;
        this.pashmina = pashmina;
    }

    public int getColourId() {
        return colourId;
    }

    public void setColourId(int colourId) {
        this.colourId = colourId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    public Pashmina getPashmina() {
        return pashmina;
    }

    public void setPashmina(Pashmina pashmina) {
        this.pashmina = pashmina;
    }
}
