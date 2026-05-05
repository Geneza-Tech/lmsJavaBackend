package com.geneza.lms.dto;

import java.util.List;

public class BatchModuleTrainerUpdateRequest {

    private Integer batchId;
    private List<ModuleTrainerRequest> modules;

    // getters/setters
    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public List<ModuleTrainerRequest> getModules() {
        return modules;
    }

    public void setModules(List<ModuleTrainerRequest> modules) {
        this.modules = modules;
    }
}
