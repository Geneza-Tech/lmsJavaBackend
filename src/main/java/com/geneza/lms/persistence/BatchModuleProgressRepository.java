package com.geneza.lms.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geneza.lms.domain.BatchModuleProgress;

@Repository
public interface BatchModuleProgressRepository extends JpaRepository<BatchModuleProgress, Integer> {

    List<BatchModuleProgress> findAllByEnrollmentId(Integer enrollmentId);

    List<BatchModuleProgress> findAllByBatchModuleId(Integer batchModuleId);

    List<BatchModuleProgress> findAllByBatchModule_Batch_Id(Integer batchId);
}
