package com.geneza.lms.service;
import com.geneza.lms.domain.BatchTrainer;
import java.util.List;

public interface BatchTrainerService {
    public BatchTrainer findById(Integer id);
    public void saveBatchTrainer(BatchTrainer batchTrainer_1);
    public boolean deleteBatchTrainer(Integer batchTrainerId);
    public List<BatchTrainer> findAll();
    public List<BatchTrainer> findAllByBatchId(Integer  batch);
    public List<BatchTrainer> findAllByTrainerId(Integer  trainer);
    public List<BatchTrainer> findByPersonId(Integer personId);

}