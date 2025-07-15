package com.geneza.lms.service;
import com.geneza.lms.domain.BatchModule;
import java.util.List;

public interface BatchModuleService {
    public BatchModule findById(Integer id);
    public void saveBatchModule(BatchModule batchModule_1);
    public boolean deleteBatchModule(Integer batchModuleId);
    public List<BatchModule> findAll();
    public List<BatchModule> findAllByBatchId(Integer  batch);
    public List<BatchModule> findAllByModuleId(Integer  module);
}