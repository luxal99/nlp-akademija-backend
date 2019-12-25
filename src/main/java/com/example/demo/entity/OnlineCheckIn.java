/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author ThinkPad T470s   A
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "online_check_in")
public class OnlineCheckIn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_check_in", nullable = false)
    private Long idCheckIn;
    @Basic(optional = false)
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    @Column(name = "time", nullable = false)
    private String time;
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client idClient;

    public OnlineCheckIn() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public OnlineCheckIn(Long idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public OnlineCheckIn(Long idCheckIn, Date date) {
        this.idCheckIn = idCheckIn;
        this.date = date;
    }

    public Long getIdCheckIn() {
        return idCheckIn;
    }

    public void setIdCheckIn(Long idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
