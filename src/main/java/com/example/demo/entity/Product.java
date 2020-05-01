/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import org.docx4j.openpackaging.Base;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author luxal
 */
@Entity
@Table(name = "product")
public class Product extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @Column(name = "price")
    private long price;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price_eu")
    private Double priceEu;
    @JoinColumn(name = "id_image", referencedColumnName = "id")
    @ManyToOne
    private ImageTable idImage;

    public Product() {
    }


    public Product(String title, long price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Double getPriceEu() {
        return priceEu;
    }

    public void setPriceEu(Double priceEu) {
        this.priceEu = priceEu;
    }

    public ImageTable getIdImage() {
        return idImage;
    }

    public void setIdImage(ImageTable idImage) {
        this.idImage = idImage;
    }

}
