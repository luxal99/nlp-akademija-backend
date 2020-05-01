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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "image_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImageTable.findAll", query = "SELECT i FROM ImageTable i"),
    @NamedQuery(name = "ImageTable.findById", query = "SELECT i FROM ImageTable i WHERE i.id = :id"),
    @NamedQuery(name = "ImageTable.findByName", query = "SELECT i FROM ImageTable i WHERE i.name = :name"),
    @NamedQuery(name = "ImageTable.findByType", query = "SELECT i FROM ImageTable i WHERE i.type = :type")})
public class ImageTable extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Lob
    @Column(name = "pic_byte")
    private byte[] picByte;
    @OneToMany(mappedBy = "idImage")
    @JsonIgnore
    private List<Product> productList;

    public ImageTable() {
    }

    public ImageTable(String name, String type, byte[] picByte) {

        this.name = name;

        this.type = type;

        this.picByte = picByte;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
