package com.geneza.lms.domain;

import java.io.Serializable;
import java.util.Date;

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
    name = "session_batch_module",
    uniqueConstraints = @UniqueConstraint(columnNames = {"session_id", "batch_module_id"})
)
public class SessionBatchModule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_module_id")
    private BatchModule batchModule;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    // getters/setters

    public Integer getId() {
        return id;
    }  

    public void setId(Integer id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public BatchModule getBatchModule() {
        return batchModule;
    }

    public void setBatchModule(BatchModule batchModule) {
        this.batchModule = batchModule;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    
}