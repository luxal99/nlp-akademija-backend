/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ThinkPad T470s
 */
@Entity
@Table(name = "ONLINE_CHECK_IN")
public class OnlineCheckIn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CHECK_IN")
    private Integer idCheckIn;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;
    @OneToMany(mappedBy = "idCheckIn")
    private Collection<Course> courseCollection;
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT")
    @ManyToOne(optional = false)
    private Client idClient;

    public OnlineCheckIn() {
    }

    public OnlineCheckIn(Integer idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public OnlineCheckIn(Integer idCheckIn, Date date) {
        this.idCheckIn = idCheckIn;
        this.date = date;
    }

    public Integer getIdCheckIn() {
        return idCheckIn;
    }

    public void setIdCheckIn(Integer idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
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
