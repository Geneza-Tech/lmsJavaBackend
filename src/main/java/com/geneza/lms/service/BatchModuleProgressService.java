package com.geneza.lms.service;

import java.util.List;

import com.geneza.lms.domain.BatchModuleProgress;

public interface BatchModuleProgressService {

    List<BatchModuleProgress> saveAll(List<BatchModuleProgress> list);

    List<BatchModuleProgress> findAllByEnrollmentId(Integer enrollmentId);

    List<BatchModuleProgress> findAllByBatchModuleId(Integer batchModuleId);

    BatchModuleProgress create(BatchModuleProgress entity);

    BatchModuleProgress update(Integer id, BatchModuleProgress entity);

    List<BatchModuleProgress> findAll();

    BatchModuleProgress findById(Integer id);

    boolean deleteById(Integer id);

    List<BatchModuleProgress> findAllByBatchId(Integer batchId);
}
