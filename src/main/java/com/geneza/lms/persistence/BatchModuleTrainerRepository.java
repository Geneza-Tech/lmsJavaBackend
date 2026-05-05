package com.geneza.lms.persistence;

import com.geneza.lms.domain.BatchModuleTrainer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface BatchModuleTrainerRepository extends JpaRepository<BatchModuleTrainer, Long> {
    BatchModuleTrainer findById(Integer id);
    List<BatchModuleTrainer> findAll();
    List<BatchModuleTrainer> findByBatchModuleId(Integer batchModuleId);
    List<BatchModuleTrainer> findByBatchTrainerId(Integer batchTrainerId);
    List<BatchModuleTrainer> findByBatchModule_Batch_Id(Integer batchId);
    Page<BatchModuleTrainer> findAll(Pageable pageable);
        boolean existsByBatchModuleIdAndBatchTrainerId(Integer batchModuleId, Integer batchTrainerId);

}