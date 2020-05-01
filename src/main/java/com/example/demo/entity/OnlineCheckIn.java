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
@Table(name = "online_check_in")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "OnlineCheckIn.findAll", query = "SELECT o FROM OnlineCheckIn o")})
public class OnlineCheckIn extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne
    private Client idClient;

    public OnlineCheckIn() {
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

}
