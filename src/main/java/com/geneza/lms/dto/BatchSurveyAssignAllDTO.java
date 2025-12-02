package com.geneza.lms.dto;

public class BatchSurveyAssignAllDTO {

    private Integer batchId;
    private Integer surveyId;
    private Boolean assignToAllRoles;

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public Boolean getAssignToAllRoles() {
        return assignToAllRoles;
    }

    public void setAssignToAllRoles(Boolean assignToAllRoles) {
        this.assignToAllRoles = assignToAllRoles;
    }
}
