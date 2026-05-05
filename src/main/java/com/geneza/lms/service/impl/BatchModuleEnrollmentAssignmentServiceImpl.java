package com.geneza.lms.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geneza.lms.domain.BatchModuleEnrollmentAssignment;
import com.geneza.lms.persistence.BatchModuleEnrollmentAssignmentRepository;
import com.geneza.lms.service.BatchModuleEnrollmentAssignmentService;

@Service
public class BatchModuleEnrollmentAssignmentServiceImpl 
        implements BatchModuleEnrollmentAssignmentService {

    @Autowired
    private BatchModuleEnrollmentAssignmentRepository repository;

    // ✅ BULK SAVE (CREATE / UPSERT)
    @Override
    public List<BatchModuleEnrollmentAssignment> saveAll(List<BatchModuleEnrollmentAssignment> list) {
        return repository.saveAll(list);
    }

    // ✅ BULK DELETE
    @Override
    public void deleteAll(List<BatchModuleEnrollmentAssignment> list) {
        repository.deleteAll(list);
    }

    // ✅ FIND ALL
    @Override
    public List<BatchModuleEnrollmentAssignment> findAll() {
        return repository.findAll();
    }

    // ✅ FIND BY ID
    @Override
    public BatchModuleEnrollmentAssignment findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));
    }

    // ✅ DELETE BY ID
    @Override
    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // ✅ FILTERS
    @Override
    public List<BatchModuleEnrollmentAssignment> findAllByEnrollmentId(Integer enrollmentId) {
        return repository.findAllByEnrollmentId(enrollmentId);
    }

    @Override
    public List<BatchModuleEnrollmentAssignment> findAllByBatchModuleId(Integer batchModuleId) {
        return repository.findAllByBatchModuleId(batchModuleId);
    }

    // ✅ CREATE (STRICT)
    @Override
    public BatchModuleEnrollmentAssignment create(BatchModuleEnrollmentAssignment entity) {
        if (entity.getId() != null) {
            throw new IllegalArgumentException("New entity cannot already have an ID");
        }
        return repository.save(entity);
    }

    // ✅ UPDATE (STRICT BY ID)
    @Override
    public BatchModuleEnrollmentAssignment update(Integer id, BatchModuleEnrollmentAssignment entity) {

        BatchModuleEnrollmentAssignment existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));

        // 🔥 Prevent ID tampering
        entity.setId(id);

        // 🔥 Update only allowed fields
        existing.setBatchModule(entity.getBatchModule());
        existing.setEnrollment(entity.getEnrollment());
        existing.setAssignment(entity.getAssignment());
        existing.setCreatedBy(entity.getCreatedBy());

        return repository.save(existing);
    }

    @Override
public List<BatchModuleEnrollmentAssignment> findAllByBatchId(Integer batchId) {
    return repository.findAllByBatchModule_Batch_Id(batchId);
}

@Override
public List<BatchModuleEnrollmentAssignment> findAllByStudentId(Integer studentId) {
    return repository.findAllByEnrollment_Student_Id(studentId);
}
}