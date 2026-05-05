package com.geneza.lms.dto;

import java.util.List;

public class BatchModuleUpdateRequest {

    private Integer batchId;
    private List<Integer> moduleIds;

    // getters & setters
    public Integer getBatchId() {
        return batchId;
    }
    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }
    public List<Integer> getModuleIds() {
        return moduleIds;
    }
    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
    }
}