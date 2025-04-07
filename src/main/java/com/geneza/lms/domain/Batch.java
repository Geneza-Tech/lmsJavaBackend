package com.geneza.lms.domain;
import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Date;
import java.math.*;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 * Batch Entity
 * 
 * Generated by Dunamis App Generator
 */

@Entity
@Table(name = "batch")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "GenezaRest/com/geneza/lms/domain", name = "batch")
public class Batch implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(name = "id")
    @Basic(fetch = FetchType.EAGER)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    private Integer id;  
    @Column(name = "batch")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    private String batch;@Column(name = "startDate")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    private Date startDate;
    @Column(name = "endDate")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    private Date endDate;
    @Column(name = "location")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    private String location;
    @ManyToOne
    @JoinColumn(name="course")
    private Course course;@ManyToOne
    @JoinColumn(name="country")
    private Country country;@ManyToOne
    @JoinColumn(name="batchStatus")
    private BatchStatus batchStatus;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

        
    public String getBatch() {
        return batch;
    }
    
    public void setBatch(String batch) {
        this.batch = batch;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Country getCountry() {
        return country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }
    
    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }


    public Batch() {
    }


    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("id=[").append(id).append("] ");
        return buffer.toString();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
        return result;
    }


    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Batch))
            return false;
        Batch equalCheck = (Batch) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }

}