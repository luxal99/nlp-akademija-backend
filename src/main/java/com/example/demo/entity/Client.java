/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ThinkPad T470s
 */
@Entity
@Table(name = "CLIENT")

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLIENT")
    private Integer idClient;
    @Basic(optional = false)
    @Column(name = "IME")
    private String ime;
    @Basic(optional = false)
    @Column(name = "PREZIME")
    private String prezime;
    @Basic(optional = false)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @Column(name = "TELEPHONE_NUM")
    private String telephoneNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<OnlinePurchase> onlinePurchaseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<Session> sessionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<OnlineCheckIn> onlineCheckInCollection;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, String ime, String prezime, String mail, String telephoneNum) {
        this.idClient = idClient;
        this.ime = ime;
        this.prezime = prezime;
        this.mail = mail;
        this.telephoneNum = telephoneNum;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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

    public Collection<OnlinePurchase> getOnlinePurchaseCollection() {
        return onlinePurchaseCollection;
    }

    public void setOnlinePurchaseCollection(Collection<OnlinePurchase> onlinePurchaseCollection) {
        this.onlinePurchaseCollection = onlinePurchaseCollection;
    }

    public Collection<Session> getSessionCollection() {
        return sessionCollection;
    }

    public void setSessionCollection(Collection<Session> sessionCollection) {
        this.sessionCollection = sessionCollection;
    }

    public Collection<OnlineCheckIn> getOnlineCheckInCollection() {
        return onlineCheckInCollection;
    }

    public void setOnlineCheckInCollection(Collection<OnlineCheckIn> onlineCheckInCollection) {
        this.onlineCheckInCollection = onlineCheckInCollection;
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
        return "javaapplication2.Client[ idClient=" + idClient + " ]";
    }
    
}
