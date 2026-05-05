package com.geneza.lms.dto;

import java.util.List;

public class ModuleTrainerRequest {

    private Integer moduleId;
    private List<Integer> trainers;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public List<Integer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Integer> trainers) {
        this.trainers = trainers;
    }
}