package com.geneza.lms.service;
import com.geneza.lms.domain.Batch;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BatchService {
    public Batch findById(Integer id);
    public void saveBatch(Batch batch_1);
    public boolean deleteBatch(Integer batchId);
    public List<Batch> findAll();
    public List<Batch> findAllByCourseId(Integer  course);
    public List<Batch> findAllByCountryId(Integer  country);
    public List<Batch> findAllByBatchStatusId(Integer  batchStatus);
    List<Batch> getBatchesByFilters(Integer courseId, Integer countryId, Integer batchStatusId);
    Page<Batch> getBatchesByFilterPage(Integer courseId, Integer countryId, Integer batchStatusId, Pageable pageable);


}