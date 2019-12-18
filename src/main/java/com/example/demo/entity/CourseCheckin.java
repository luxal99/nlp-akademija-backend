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
import javax.persistence.Table;

/**
 *
 * @author ThinkPad T470s
 */
@Entity
@Table(name = "course_checkin")
public class CourseCheckin implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_course_checkin")
    private Integer idCourseCheckin;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client idClient;

    public CourseCheckin() {
    }

    public CourseCheckin(Integer idCourseCheckin) {
        this.idCourseCheckin = idCourseCheckin;
    }

    public Integer getIdCourseCheckin() {
        return idCourseCheckin;
    }

    public void setIdCourseCheckin(Integer idCourseCheckin) {
        this.idCourseCheckin = idCourseCheckin;
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
        hash += (idCourseCheckin != null ? idCourseCheckin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseCheckin)) {
            return false;
        }
        CourseCheckin other = (CourseCheckin) object;
        if ((this.idCourseCheckin == null && other.idCourseCheckin != null) || (this.idCourseCheckin != null && !this.idCourseCheckin.equals(other.idCourseCheckin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication4.CourseCheckin[ idCourseCheckin=" + idCourseCheckin + " ]";
    }

}