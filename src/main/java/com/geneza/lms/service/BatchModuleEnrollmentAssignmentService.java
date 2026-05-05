package com.geneza.lms.service;

import java.util.List;

import com.geneza.lms.domain.BatchModuleEnrollmentAssignment;

public interface BatchModuleEnrollmentAssignmentService {

    List<BatchModuleEnrollmentAssignment> saveAll(List<BatchModuleEnrollmentAssignment> list);

    void deleteAll(List<BatchModuleEnrollmentAssignment> list);

    List<BatchModuleEnrollmentAssignment> findAll();

    BatchModuleEnrollmentAssignment findById(Integer id);

    boolean deleteById(Integer id);

    List<BatchModuleEnrollmentAssignment> findAllByEnrollmentId(Integer enrollmentId);

    List<BatchModuleEnrollmentAssignment> findAllByBatchModuleId(Integer batchModuleId);

    BatchModuleEnrollmentAssignment create(BatchModuleEnrollmentAssignment entity);

    BatchModuleEnrollmentAssignment update(Integer id, BatchModuleEnrollmentAssignment entity);

    List<BatchModuleEnrollmentAssignment> findAllByBatchId(Integer batchId);

    List<BatchModuleEnrollmentAssignment> findAllByStudentId(Integer studentId);
}