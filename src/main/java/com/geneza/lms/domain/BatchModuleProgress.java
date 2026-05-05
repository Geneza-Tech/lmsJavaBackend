package com.geneza.lms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    name = "batch_module_progress",
    uniqueConstraints = @UniqueConstraint(columnNames = {"enrollment_id", "batch_module_id"})
)
public class BatchModuleProgress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_module_id")
    private BatchModule batchModule;

    @ManyToOne(optional = false)
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @Column(nullable = false)
    private String status; // "pending", "completed"

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private Person updatedBy; // trainer

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    // getters/setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BatchModule getBatchModule() {
        return batchModule;
    }

    public void setBatchModule(BatchModule batchModule) {
        this.batchModule = batchModule;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Person getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Person updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    
}
