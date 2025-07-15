package com.geneza.lms.dto;

public class ResponseParticipant {
    private Integer id;

    public ResponseParticipant() {}

    public ResponseParticipant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
