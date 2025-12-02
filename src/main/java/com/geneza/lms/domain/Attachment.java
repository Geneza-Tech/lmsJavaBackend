package com.geneza.lms.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@Table(name = "attachment")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "GenezaRest/com/geneza/lms/domain", name = "attachment")
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XmlElement
    private Integer id;

    @Column(name = "name", nullable = false)
    @XmlElement
    private String name;

    @Column(name = "file_url", nullable = false)
    @XmlElement
    private String fileUrl;

    @Column(name = "link_id", nullable = false)
    @XmlElement
    private Integer linkId;   // <-- NEW FIELD

    public Attachment() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public Integer getLinkId() { return linkId; }
    public void setLinkId(Integer linkId) { this.linkId = linkId; }

    @Override
    public String toString() {
        return "Attachment{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", fileUrl='" + fileUrl + '\'' +
            ", linkId=" + linkId +
            '}';
    }
}
