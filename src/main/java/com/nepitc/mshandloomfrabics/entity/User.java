/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_USER", catalog = "", schema = "NISHAN")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "USER_ID")
    private BigDecimal userId;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "CREATED_AT", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "ENABLED", insertable = false)
    private Character enabled;
    
    @Column(name = "USER_TYPE")
    private String userType;
    
    public User() {
    }

    public User(BigDecimal userId) {
        this.userId = userId;
    }

    public User(BigDecimal userId, String username, String password, Date createdAt, Character enabled, String userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.enabled = enabled;
        this.userType = userType;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
