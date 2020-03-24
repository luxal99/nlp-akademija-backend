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
 * @author luxal
 */
@Entity
@Table(name = "online_training_checkin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OnlineTrainingCheckin.findAll", query = "SELECT o FROM OnlineTrainingCheckin o"),
    @NamedQuery(name = "OnlineTrainingCheckin.findByIdOnlineTraining", query = "SELECT o FROM OnlineTrainingCheckin o WHERE o.idOnlineTraining = :idOnlineTraining"),
    @NamedQuery(name = "OnlineTrainingCheckin.findByTitle", query = "SELECT o FROM OnlineTrainingCheckin o WHERE o.title = :title")})
public class OnlineTrainingCheckin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_online_training")
    private Long idOnlineTraining;
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne
    private Client idClient;

    public OnlineTrainingCheckin() {
    }

    public Long getIdOnlineTraining() {
        return idOnlineTraining;
    }

    public void setIdOnlineTraining(Long idOnlineTraining) {
        this.idOnlineTraining = idOnlineTraining;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOnlineTraining != null ? idOnlineTraining.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnlineTrainingCheckin)) {
            return false;
        }
        OnlineTrainingCheckin other = (OnlineTrainingCheckin) object;
        if ((this.idOnlineTraining == null && other.idOnlineTraining != null) || (this.idOnlineTraining != null && !this.idOnlineTraining.equals(other.idOnlineTraining))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.OnlineTrainingCheckin[ idOnlineTraining=" + idOnlineTraining + " ]";
    }
    
}
