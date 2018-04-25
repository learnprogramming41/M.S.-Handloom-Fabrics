/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_ORDER", catalog = "", schema = "NISHAN")

@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "Orders.findBySoldOutStatus", query = "SELECT o FROM Orders o WHERE o.soldOutStatus = :soldOutStatus")
    , @NamedQuery(name = "Orders.findByShippedDate", query = "SELECT o FROM Orders o WHERE o.shippedDate = :shippedDate")
    , @NamedQuery(name = "Orders.findByQuantity", query = "SELECT o FROM Orders o WHERE o.quantity = :quantity")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "ORDER_ID", insertable = false)
    private int orderId;
    
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    
    @Column(name = "SOLD_OUT_STATUS")
    private boolean soldOutStatus;
    @Column(name = "SHIPPED_DATE", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippedDate;
    
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @JoinColumn(name = "PASHMINA_ID", referencedColumnName = "PASHMINA_ID")
    @ManyToOne
    private Pashmina pashminaId;
    @JoinColumn(name = "SHIPPING_ADDRESS_ID", referencedColumnName = "SHIPPING_ADDRESS_ID")
    @ManyToOne
    private ShippingAddress shippingAddressId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private User userId;

    public Orders() {
    }

    public Orders(int orderId) {
        this.orderId = orderId;
    }

    public Orders(int orderId, Date orderDate, boolean soldOutStatus, BigInteger quantity) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.soldOutStatus = soldOutStatus;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public Pashmina getPashminaId() {
        return pashminaId;
    }

    public void setPashminaId(Pashmina pashminaId) {
        this.pashminaId = pashminaId;
    }

    public ShippingAddress getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(ShippingAddress shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
