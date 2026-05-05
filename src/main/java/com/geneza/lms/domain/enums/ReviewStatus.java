package com.geneza.lms.domain.enums;

public enum ReviewStatus {
    APPROVED("Accepted"),
    REJECTED("Redo"),
    PENDING("Submitted");

    private final String submissionStatus;

    ReviewStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }
}