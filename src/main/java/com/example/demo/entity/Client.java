/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ThinkPad T470s
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "client")
public class Client implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<OnlinePurchase> onlinePurchaseList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client",nullable = false)
    private Integer idClient;
    @Basic(optional = false)
    @Column(name = "name",nullable = false)
    private String name;
    @Basic(optional = false)
    @Column(name = "lastname",nullable = false)
    private String lastname;
    @Basic(optional = false)
    @Column(name = "mail",nullable = false)
    private String mail;
    @Basic(optional = false)
    @Column(name = "telephone_num")
    private String telephoneNum;
    @OneToMany(cascade = CascadeType.REFRESH,mappedBy = "idClient",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OnlineCheckIn> onlineCheckInList;


    public List<OnlineCheckIn> getOnlineCheckInList() {
        return onlineCheckInList;
    }

    public void setOnlineCheckInList(List<OnlineCheckIn> onlineCheckInList) {
        this.onlineCheckInList = onlineCheckInList;
    }



    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, String name, String lastname, String mail, String telephoneNum) {
        this.idClient = idClient;
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
        this.telephoneNum = telephoneNum;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication3.Client[ idClient=" + idClient + " ]";
    }

    @XmlTransient
    public List<OnlinePurchase> getOnlinePurchaseList() {
        return onlinePurchaseList;
    }

    public void setOnlinePurchaseList(List<OnlinePurchase> onlinePurchaseList) {
        this.onlinePurchaseList = onlinePurchaseList;
    }
    
}
