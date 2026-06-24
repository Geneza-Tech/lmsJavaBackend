package com.geneza.lms.dto;

import java.util.List;

public class AssignmentResponseDTO {

    private Integer id;
    private String assignment;
    private String assignmentContent;
    private String assignmentKey;
    private Integer durationDays;
    private Boolean contentRequired;
    private Boolean attachmentRequired;
    private List<AttachmentDTO> attachments;

    // getters & setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAssignment() {
        return assignment;
    }
    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
    public String getAssignmentContent() {
        return assignmentContent;
    }
    public void setAssignmentContent(String assignmentContent) {
        this.assignmentContent = assignmentContent;
    }
    public String getAssignmentKey() {
        return assignmentKey;
    }
    public void setAssignmentKey(String assignmentKey) {
        this.assignmentKey = assignmentKey;
    }
    public Integer getDurationDays() {
        return durationDays;
    }
    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }
    public List<AttachmentDTO> getAttachments() {
        return attachments;
    }
    public void setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
    }
    public Boolean getContentRequired() {
        return contentRequired;
    }
    public void setContentRequired(Boolean contentRequired) {
        this.contentRequired = contentRequired;
    }
    public Boolean getAttachmentRequired() {
        return attachmentRequired;
    }
    public void setAttachmentRequired(Boolean attachmentRequired) {
        this.attachmentRequired = attachmentRequired;
    }
}
