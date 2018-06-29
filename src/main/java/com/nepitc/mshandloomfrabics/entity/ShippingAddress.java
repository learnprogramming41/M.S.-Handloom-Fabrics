/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_SHIPPING_ADDRESS", catalog = "", schema = "NISHAN")

@NamedQueries({
    @NamedQuery(name = "ShippingAddress.findAll", query = "SELECT s FROM ShippingAddress s")
    , @NamedQuery(name = "ShippingAddress.findByShippingAddressId", query = "SELECT s FROM ShippingAddress s WHERE s.shippingAddressId = :shippingAddressId")
    , @NamedQuery(name = "ShippingAddress.findByAddress", query = "SELECT s FROM ShippingAddress s WHERE s.address = :address")})
public class ShippingAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "SHIPPING_ADDRESS_ID", insertable =false)
    private int shippingAddressId;
    
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(mappedBy = "shippingAddressId")
    private List<Orders> ordersList;

    public ShippingAddress() {
    }

    public ShippingAddress(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public ShippingAddress(int shippingAddressId, String address) {
        this.shippingAddressId = shippingAddressId;
        this.address = address;
    }

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
