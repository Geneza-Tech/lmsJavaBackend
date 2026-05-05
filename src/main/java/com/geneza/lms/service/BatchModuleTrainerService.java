package com.geneza.lms.service;

import com.geneza.lms.domain.BatchModuleTrainer;
import com.geneza.lms.dto.BatchModuleTrainerUpdateRequest;
import com.geneza.lms.dto.BatchTrainerUpdateRequest;
import java.util.List;

public interface BatchModuleTrainerService {
    public BatchModuleTrainer findById(Integer id);
    public void saveBatchModuleTrainer(BatchModuleTrainer batchModuleTrainer);
    public boolean deleteBatchModuleTrainer(Integer batchModuleTrainerId);
    public List<BatchModuleTrainer> findAll();
    public List<BatchModuleTrainer> findAllByBatchModuleId(Integer batchModuleId);
    public List<BatchModuleTrainer> findAllByBatchTrainerId(Integer batchTrainerId);
    public List<BatchModuleTrainer> findAllByBatchId(Integer batchId);
    public void addBatchModuleTrainers(Integer batchModuleId, List<Integer> batchTrainerIds);
    public void updateBatchModuleTrainers(BatchModuleTrainerUpdateRequest request);
}