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
@Table(name = "TBL_PASHMINA_COLOUR", catalog = "", schema = "NISHAN")

public class PashminaColourModel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "COLOUR_ID", insertable = false)
    private int colourId;
    @Column(name = "COLOR")
    private String color;
    
    @JoinColumn(name = "PASHMINA_ID", referencedColumnName = "PASHMINA_ID")
    @ManyToOne
    private PashminaModel pashmina;

    public PashminaColourModel() {
    }

    public PashminaColourModel(int colourId) {
        this.colourId = colourId;
    }

    public PashminaColourModel(String color, PashminaModel pashmina) {
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
    
//    public Pashmina getPashmina() {
//        return pashmina;
//    }

    public void setPashmina(PashminaModel pashmina) {
        this.pashmina = pashmina;
    }
}
