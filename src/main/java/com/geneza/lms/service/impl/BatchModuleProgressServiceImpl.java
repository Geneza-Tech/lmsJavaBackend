package com.geneza.lms.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geneza.lms.domain.BatchModuleProgress;
import com.geneza.lms.persistence.BatchModuleProgressRepository;
import com.geneza.lms.service.BatchModuleProgressService;

@Service
public class BatchModuleProgressServiceImpl implements BatchModuleProgressService {

    @Autowired
    private BatchModuleProgressRepository repository;

    @Override
    public List<BatchModuleProgress> saveAll(List<BatchModuleProgress> list) {
        return repository.saveAll(list);
    }

    @Override
    public List<BatchModuleProgress> findAllByEnrollmentId(Integer enrollmentId) {
        return repository.findAllByEnrollmentId(enrollmentId);
    }

    @Override
    public List<BatchModuleProgress> findAllByBatchModuleId(Integer batchModuleId) {
        return repository.findAllByBatchModuleId(batchModuleId);
    }

    @Override
public BatchModuleProgress create(BatchModuleProgress entity) {
    if (entity.getId() != null) {
        throw new IllegalArgumentException("New entity cannot already have an ID");
    }
    return repository.save(entity);
}

@Override
public BatchModuleProgress update(Integer id, BatchModuleProgress entity) {

    BatchModuleProgress existing = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));

    // 🔥 IMPORTANT: update only fields you allow
    existing.setStatus(entity.getStatus());
    existing.setBatchModule(entity.getBatchModule());
    existing.setEnrollment(entity.getEnrollment());
    existing.setUpdatedBy(entity.getUpdatedBy());

    return repository.save(existing);
}

@Override
public List<BatchModuleProgress> findAll() {
    return repository.findAll();
}

@Override
public BatchModuleProgress findById(Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Not found with id: " + id));
}

@Override
public boolean deleteById(Integer id) {
    if (repository.existsById(id)) {
        repository.deleteById(id);
        return true;
    }
    return false;
}

@Override
public List<BatchModuleProgress> findAllByBatchId(Integer batchId) {
    return repository.findAllByBatchModule_Batch_Id(batchId);
}
}
