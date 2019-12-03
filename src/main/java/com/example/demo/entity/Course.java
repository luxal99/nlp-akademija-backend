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

/**
 *
 * @author ThinkPad T470s
 */
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COURSE")
    private Integer idCourse;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @JoinColumn(name = "ID_CHECK_IN", referencedColumnName = "ID_CHECK_IN")
    @ManyToOne
    private OnlineCheckIn idCheckIn;

    public Course() {
    }

    public Course(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Course(Integer idCourse, String title) {
        this.idCourse = idCourse;
        this.title = title;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OnlineCheckIn getIdCheckIn() {
        return idCheckIn;
    }

    public void setIdCheckIn(OnlineCheckIn idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCourse != null ? idCourse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.idCourse == null && other.idCourse != null) || (this.idCourse != null && !this.idCourse.equals(other.idCourse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Course[ idCourse=" + idCourse + " ]";
    }
    
}
