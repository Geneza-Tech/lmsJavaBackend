package com.geneza.lms.dto;

public class ResponseSurvey {
    private Integer id;

    public ResponseSurvey() {}

    public ResponseSurvey(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
