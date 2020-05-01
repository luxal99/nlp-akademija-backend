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
@Table(name = "online_training_checkin")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "OnlineTrainingCheckin.findAll", query = "SELECT o FROM OnlineTrainingCheckin o")})
public class OnlineTrainingCheckin extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "title")
    private String title;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne
    private Client idClient;

    public OnlineTrainingCheckin() {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

}
