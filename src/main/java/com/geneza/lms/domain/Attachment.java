package com.geneza.lms.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "link_type", nullable = false)
    @XmlElement
    private String linkType;       // discriminator: see AttachmentLinkType

    @Column(name = "type")
    @XmlElement
    private String type;           // optional sub-type e.g. "key" | "content" for assignments

    @Column(name = "created_at")
    @XmlElement
    private Date createdAt;

    public Attachment() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public Integer getLinkId() { return linkId; }
    public void setLinkId(Integer linkId) { this.linkId = linkId; }

    public String getLinkType() { return linkType; }
    public void setLinkType(String linkType) { this.linkType = linkType; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

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
