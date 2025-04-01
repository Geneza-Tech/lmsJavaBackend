package com.geneza.lms.service;
import com.geneza.lms.domain.BatchStatus;
import java.util.List;

public interface BatchStatusService {
    public BatchStatus findById(Integer id);
    public void saveBatchStatus(BatchStatus batchStatus_1);
    public boolean deleteBatchStatus(Integer batchStatusId);
    public List<BatchStatus> findAll();
}