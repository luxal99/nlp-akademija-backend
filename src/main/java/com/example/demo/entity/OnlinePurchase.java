/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author luxal
 */
@Entity
@Table(name = "online_purchase")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "OnlinePurchase.findAll", query = "SELECT o FROM OnlinePurchase o")})
public class OnlinePurchase extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "comment")
    private String comment;
    @Column(name = "social_link")
    private String socialLink;
    @Column(name = "country")
    private String country;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product idProduct;

    public OnlinePurchase() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSocialLink() {
        return socialLink;
    }

    public void setSocialLink(String socialLink) {
        this.socialLink = socialLink;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

}
