/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_ORDER", catalog = "", schema = "NISHAN")
public class OrderModel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "ORDER_ID", insertable = false)
    private Integer orderId;
    
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    
    @Column(name = "SOLD_OUT_STATUS")
    private boolean soldOutStatus;
    
    @Column(name = "SHIPPED_DATE", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippedDate;
    
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "PASHMINA_ID", referencedColumnName = "PASHMINA_ID")
    @ManyToOne
    private PashminaModel pashminaId;
    
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UserModel userId;

    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;
    
    @Column(name = "CONTACT")
    private String contact;
    
    public OrderModel() {
    }

    public OrderModel(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderModel(Integer orderId, Date orderDate, boolean soldOutStatus, Integer quantity, String shippingAddress, String contact) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.soldOutStatus = soldOutStatus;
        this.quantity = quantity;
        this.shippingAddress = shippingAddress;
        this.contact = contact;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean getSoldOutStatus() {
        return soldOutStatus;
    }

    public void setSoldOutStatus(boolean soldOutStatus) {
        this.soldOutStatus = soldOutStatus;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PashminaModel getPashminaId() {
        return pashminaId;
    }

    public void setPashminaId(PashminaModel pashminaId) {
        this.pashminaId = pashminaId;
    }

//    public UserModel getUserId() {
//        return userId;
//    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }
}
