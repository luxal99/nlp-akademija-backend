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
 *
 * @author ThinkPad T480s
 */
@Entity
@Table(name = "online_check_in")

public class OnlineCheckIn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_check_in")
    private Integer idCheckIn;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne
    private Client idClient;

    public OnlineCheckIn() {
    }

    public OnlineCheckIn(Integer idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public Integer getIdCheckIn() {
        return idCheckIn;
    }

    public void setIdCheckIn(Integer idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCheckIn != null ? idCheckIn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnlineCheckIn)) {
            return false;
        }
        OnlineCheckIn other = (OnlineCheckIn) object;
        if ((this.idCheckIn == null && other.idCheckIn != null) || (this.idCheckIn != null && !this.idCheckIn.equals(other.idCheckIn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.OnlineCheckIn[ idCheckIn=" + idCheckIn + " ]";
    }
    
}
