package com.geneza.lms.dto;

import java.util.List;

public class BatchTrainerUpdateRequest {

    private Integer batchId;
    private List<Integer> trainerIds; // 👈 Trainer IDs (NOT BatchTrainer IDs)

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public List<Integer> getTrainerIds() {
        return trainerIds;
    }

    public void setTrainerIds(List<Integer> trainerIds) {
        this.trainerIds = trainerIds;
    }
}