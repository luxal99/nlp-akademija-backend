/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luxal
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "Product.findByTitle", query = "SELECT p FROM Product p WHERE p.title = :title"),
    @NamedQuery(name = "Product.findByText", query = "SELECT p FROM Product p WHERE p.text = :text"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product")
    private Long idProduct;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @Column(name = "price")
    private long price;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    private List<OnlinePurchase> onlinePurchaseList;
    @JoinColumn(name = "id_image", referencedColumnName = "id_image")
    @ManyToOne
    private ImageTable idImage;
    @Basic(optional = false)
    @Column(name = "price_eu")
    private long priceEu;

    public Product() {
    }


    public Product(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Product(Long idProduct, String title, long price) {
        this.idProduct = idProduct;
        this.title = title;
        this.price = price;
    }

    public long getPriceEu() {
        return priceEu;
    }

    public void setPriceEu(long priceEu) {
        this.priceEu = priceEu;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
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

    @XmlTransient
    public List<OnlinePurchase> getOnlinePurchaseList() {
        return onlinePurchaseList;
    }

    public void setOnlinePurchaseList(List<OnlinePurchase> onlinePurchaseList) {
        this.onlinePurchaseList = onlinePurchaseList;
    }

    public ImageTable getIdImage() {
        return idImage;
    }

    public void setIdImage(ImageTable idImage) {
        this.idImage = idImage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Product[ idProduct=" + idProduct + " ]";
    }
    
}
