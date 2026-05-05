package com.geneza.lms.dto;

import com.geneza.lms.domain.Attachment;

public class AttachmentDTO {

    private String fileUrl;
    private String fileType;
    private String linkType;
    private Integer linkId;
    private String name;

    public AttachmentDTO(Attachment a) {
        this.fileUrl = a.getFileUrl();
        this.fileType = a.getType();
        this.linkType = a.getLinkType();
        this.linkId = a.getLinkId();
        this.name = a.getName();
    }

    // getters
    public String getFileUrl() {
        return fileUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public String getLinkType() {
        return linkType;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public String getName() {
        return name;
    }
}
