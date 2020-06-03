/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author luxal
 */
@Entity
@Table(name = "flirting_master", catalog = "nlp_akademija", schema = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "FlirtingMaster.findAll", query = "SELECT f FROM FlirtingMaster f"),
        @NamedQuery(name = "FlirtingMaster.findById", query = "SELECT f FROM FlirtingMaster f WHERE f.id = :id")})
public class FlirtingMaster extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne
    private Client idClient;

    public FlirtingMaster() {
    }


    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

}
