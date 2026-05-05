package com.geneza.lms.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@Table(name = "batch_module_trainer", uniqueConstraints = @UniqueConstraint(columnNames = {"batchModule", "batchTrainer"}))
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "GenezaRest/com/geneza/lms/domain", name = "batchModuleTrainer")
public class BatchModuleTrainer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XmlElement
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "batchModule", nullable = false)
    private BatchModule batchModule;

    @ManyToOne
    @JoinColumn(name = "batchTrainer", nullable = false)
    private BatchTrainer batchTrainer;

    public BatchModuleTrainer() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public BatchModule getBatchModule() { return batchModule; }
    public void setBatchModule(BatchModule batchModule) { this.batchModule = batchModule; }

    public BatchTrainer getBatchTrainer() { return batchTrainer; }
    public void setBatchTrainer(BatchTrainer batchTrainer) { this.batchTrainer = batchTrainer; }

    @Override
    public String toString() {
        return "BatchModuleTrainer{id=" + id + "}";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof BatchModuleTrainer)) return false;
        BatchModuleTrainer o = (BatchModuleTrainer) obj;
        if ((id == null && o.id != null) || (id != null && o.id == null)) return false;
        if (id != null && !id.equals(o.id)) return false;
        return true;
    }
}