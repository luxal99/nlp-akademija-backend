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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author luxal
 */
@Entity
@Table(name = "client", catalog = "nlp_akademija", schema = "")
@XmlRootElement
public class Client extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Column(name = "telephone_num")
    private String telephoneNum;
    @Column(name = "date")
    private String date;
    @OneToMany(mappedBy = "idClient")
    @JsonIgnore
    private List<FlirtingMaster> flirtingMasterList;

    public Client() {
    }


    public Client( String name, String lastname, String mail) {
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlTransient
    public List<FlirtingMaster> getFlirtingMasterList() {
        return flirtingMasterList;
    }

    public void setFlirtingMasterList(List<FlirtingMaster> flirtingMasterList) {
        this.flirtingMasterList = flirtingMasterList;
    }
}
