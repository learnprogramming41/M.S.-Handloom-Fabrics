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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Temporal;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_ADMIN", catalog = "", schema = "NISHAN")

@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
    , @NamedQuery(name = "Admin.findByAdminId", query = "SELECT a FROM Admin a WHERE a.adminId = :adminId")
    , @NamedQuery(name = "Admin.findByUsername", query = "SELECT a FROM Admin a WHERE a.username = :username")
    , @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "ADMIN_ID", insertable = false)
    private int adminId;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORDS")
    private String password;

    @Column(name = "ENABLED", insertable = false)
    private boolean active;
    
    @Column(name = "CREATED_AT", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    
    @Column(name = "EMAIL")
    private String email;
    
    public Admin() {
    }

    public Admin(int adminId) {
        this.adminId = adminId;
    }

    public Admin(int adminId, String username, String password, boolean active, Date createdAt, String email) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.active = active;
        this.createdAt = createdAt;
        this.email = email;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
