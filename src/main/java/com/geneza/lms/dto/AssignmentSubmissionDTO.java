package com.geneza.lms.dto;

import java.util.List;

public class AssignmentSubmissionDTO {

    private Integer id;
    private String submissionContent;
    private String comment;
    private List<AttachmentDTO> attachments;

    // getters & setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSubmissionContent() {
        return submissionContent;
    }   
    public void setSubmissionContent(String submissionContent) {
        this.submissionContent = submissionContent;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public List<AttachmentDTO> getAttachments() {
        return attachments;
    }   
    public void setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
    }
    

}
