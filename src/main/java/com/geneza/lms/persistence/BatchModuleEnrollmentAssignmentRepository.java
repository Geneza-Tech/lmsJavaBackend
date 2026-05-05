package com.geneza.lms.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geneza.lms.domain.BatchModuleEnrollmentAssignment;

@Repository
public interface BatchModuleEnrollmentAssignmentRepository extends JpaRepository<BatchModuleEnrollmentAssignment, Integer> {

    List<BatchModuleEnrollmentAssignment> findAllByEnrollmentId(Integer enrollmentId);

    List<BatchModuleEnrollmentAssignment> findAllByBatchModuleId(Integer batchModuleId);

    List<BatchModuleEnrollmentAssignment> findAllByBatchModule_Batch_Id(Integer batchId);

    List<BatchModuleEnrollmentAssignment> findAllByEnrollment_Student_Id(Integer studentId);
}