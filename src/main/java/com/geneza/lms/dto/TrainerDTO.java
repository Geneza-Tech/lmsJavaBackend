package com.geneza.lms.dto;

public class TrainerDTO {

    private Integer id;
    private String name;
    private String email;

    public TrainerDTO(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // getters
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}