/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ThinkPad T470s
 */
@Entity
@Table(name = "online_purchase")
public class OnlinePurchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_online_purchase")
    private Integer idOnlinePurchase;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne(optional = false)
    private Product idProduct;

    public OnlinePurchase() {
    }

    public OnlinePurchase(Integer idOnlinePurchase) {
        this.idOnlinePurchase = idOnlinePurchase;
    }

    public Integer getIdOnlinePurchase() {
        return idOnlinePurchase;
    }

    public void setIdOnlinePurchase(Integer idOnlinePurchase) {
        this.idOnlinePurchase = idOnlinePurchase;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOnlinePurchase != null ? idOnlinePurchase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnlinePurchase)) {
            return false;
        }
        OnlinePurchase other = (OnlinePurchase) object;
        if ((this.idOnlinePurchase == null && other.idOnlinePurchase != null) || (this.idOnlinePurchase != null && !this.idOnlinePurchase.equals(other.idOnlinePurchase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.OnlinePurchase[ idOnlinePurchase=" + idOnlinePurchase + " ]";
    }
    
}
