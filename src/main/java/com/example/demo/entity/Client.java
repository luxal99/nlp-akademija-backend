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

@Table(name = "client")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    @JsonIgnore
    private List<CourseCheckin> courseCheckinList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    @JsonIgnore
    private List<OnlinePurchase> onlinePurchaseList;
    @OneToMany(mappedBy = "idClient")
    @JsonIgnore
    private List<OnlineCheckIn> onlineCheckInList;
    @OneToMany(mappedBy = "idClient")
    @JsonIgnore
    private List<OnlineTrainingCheckin> onlineTrainingCheckinList;

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
    public List<CourseCheckin> getCourseCheckinList() {
        return courseCheckinList;
    }

    public void setCourseCheckinList(List<CourseCheckin> courseCheckinList) {
        this.courseCheckinList = courseCheckinList;
    }

    @XmlTransient
    public List<OnlinePurchase> getOnlinePurchaseList() {
        return onlinePurchaseList;
    }

    public void setOnlinePurchaseList(List<OnlinePurchase> onlinePurchaseList) {
        this.onlinePurchaseList = onlinePurchaseList;
    }

    @XmlTransient
    public List<OnlineCheckIn> getOnlineCheckInList() {
        return onlineCheckInList;
    }

    public void setOnlineCheckInList(List<OnlineCheckIn> onlineCheckInList) {
        this.onlineCheckInList = onlineCheckInList;
    }

    @XmlTransient
    public List<OnlineTrainingCheckin> getOnlineTrainingCheckinList() {
        return onlineTrainingCheckinList;
    }

    public void setOnlineTrainingCheckinList(List<OnlineTrainingCheckin> onlineTrainingCheckinList) {
        this.onlineTrainingCheckinList = onlineTrainingCheckinList;
    }

}
