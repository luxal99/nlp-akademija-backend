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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author luxal
 */
@Entity
@Table(name = "testimonial_image")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TestimonialImage.findAll", query = "SELECT t FROM TestimonialImage t")})
public class TestimonialImage extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "url")
    private String url;
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @ManyToOne
    private Product idProduct;
    @Column(name = "name")
    private String name;

    public TestimonialImage() {
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
