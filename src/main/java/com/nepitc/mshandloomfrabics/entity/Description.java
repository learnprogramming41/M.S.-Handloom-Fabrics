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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_DESCRIPTION", catalog = "", schema = "NISHAN")

@NamedQueries({
    @NamedQuery(name = "Description.findAll", query = "SELECT d FROM Description d")
    , @NamedQuery(name = "Description.findByDescriptionId", query = "SELECT d FROM Description d WHERE d.descriptionId = :descriptionId")
    , @NamedQuery(name = "Description.findByPashminaDescription", query = "SELECT d FROM Description d WHERE d.pashminaDescription = :pashminaDescription")})
public class Description implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id

    @Column(name = "DESCRIPTION_ID")
    private int descriptionId;

    @Column(name = "PASHMINA_DESCRIPTION")
    private String pashminaDescription;

    @JoinColumn(name = "PASHMINA_ID", referencedColumnName = "PASHMINA_ID")
    @ManyToOne
    private Pashmina pashmina;

    public Description() {
    }

    public Description(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public Description(String pashminaDescription, Pashmina pashmina) {
        this.pashminaDescription = pashminaDescription;
        this.pashmina = pashmina;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getPashminaDescription() {
        return pashminaDescription;
    }

    public void setPashminaDescription(String pashminaDescription) {
        this.pashminaDescription = pashminaDescription;
    }
    
//    public Pashmina getPashmina() {
//        return pashmina;
//    }

    public void setPashmina(Pashmina pashmina) {
        this.pashmina = pashmina;
    }
}
