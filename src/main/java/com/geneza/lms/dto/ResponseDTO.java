package com.geneza.lms.dto;

public class ResponseDTO {
    private ResponseSurvey survey;
    private ResponseParticipant participant;
    private Integer linkId;
    private Integer batchId;
    private String linkType;
    private String linkcomment;
    private String role;

    public ResponseSurvey getSurvey() {
        return survey;
    }

    public void setSurvey(ResponseSurvey survey) {
        this.survey = survey;
    }

    public ResponseParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(ResponseParticipant participant) {
        this.participant = participant;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkcomment() {
        return linkcomment;
    }

    public void setLinkcomment(String linkcomment) {
        this.linkcomment = linkcomment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
