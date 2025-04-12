package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.BatchRepository;
import com.geneza.lms.domain.Batch;
import com.geneza.lms.service.BatchService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BatchService")
@Transactional
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;
    public BatchServiceImpl() {
    }

    @Transactional
    public Batch findById(Integer id) {
        return batchRepository.findById(id);
    }

    @Transactional
    public List<Batch> findAll() {
        return batchRepository.findAll();
    }
     
    @Transactional
    public void saveBatch(Batch batch) {
        Batch existingBatch = batchRepository.findById(batch.getId());
        if (existingBatch != null) {
        if (existingBatch != batch) {      
        existingBatch.setId(batch.getId());
                existingBatch.setBatch(batch.getBatch());
                existingBatch.setStartDate(batch.getStartDate());
                existingBatch.setEndDate(batch.getEndDate());
                existingBatch.setCourse(batch.getCourse());
                existingBatch.setCountry(batch.getCountry());
                existingBatch.setLocation(batch.getLocation());
                existingBatch.setBatchStatus(batch.getBatchStatus());
        }
        batch = batchRepository.save(existingBatch);
    }else{
        batch = batchRepository.save(batch);
        }
        batchRepository.flush();
    }

    public boolean deleteBatch(Integer batchId) {
        Batch batch = batchRepository.findById(batchId);
        if(batch!=null) {
            batchRepository.delete(batch);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<Batch> findAllByCourseId(Integer  courseId) {
        return new java.util.ArrayList<Batch>(batchRepository.findAllByCourseId(courseId));
    }@Transactional
    public List<Batch> findAllByCountryId(Integer  countryId) {
        return new java.util.ArrayList<Batch>(batchRepository.findAllByCountryId(countryId));
    }@Transactional
    public List<Batch> findAllByBatchStatusId(Integer  batchStatusId) {
        return new java.util.ArrayList<Batch>(batchRepository.findAllByBatchStatusId(batchStatusId));
    }

    @Override
public List<Batch> getBatchesByFilters(Integer courseId, Integer countryId, Integer batchStatusId) {
    Specification<Batch> specification = (root, query, criteriaBuilder) -> {
        List<Predicate> predicates = new ArrayList<>();

        if (courseId != null) {
            predicates.add(criteriaBuilder.equal(root.get("course").get("id"), courseId));
        }
        if (countryId != null) {
            predicates.add(criteriaBuilder.equal(root.get("country").get("id"), countryId));
        }
        if (batchStatusId != null) {
            predicates.add(criteriaBuilder.equal(root.get("batchStatus").get("id"), batchStatusId));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };

    return batchRepository.findAll(specification); // Now works correctly!
}

@Override
public Page<Batch> getBatchesByFilterPage(Integer courseId, Integer countryId, Integer batchStatusId, Pageable pageable) {
    Specification<Batch> specification = (root, query, criteriaBuilder) -> {
        List<Predicate> predicates = new ArrayList<>();

        if (courseId != null) {
            predicates.add(criteriaBuilder.equal(root.get("course").get("id"), courseId));
        }
        if (countryId != null) {
            predicates.add(criteriaBuilder.equal(root.get("country").get("id"), countryId));
        }
        if (batchStatusId != null) {
            predicates.add(criteriaBuilder.equal(root.get("batchStatus").get("id"), batchStatusId));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };

    return batchRepository.findAll(specification, pageable);
}




}