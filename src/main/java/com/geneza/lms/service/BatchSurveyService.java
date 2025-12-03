package com.geneza.lms.service;
import com.geneza.lms.domain.BatchSurvey;
import java.util.List;
import com.geneza.lms.dto.BatchSurveyAssignAllDTO;


public interface BatchSurveyService {
    public BatchSurvey findById(Integer id);
    public void saveBatchSurvey(BatchSurvey batchSurvey_1);
    public boolean deleteBatchSurvey(Integer batchSurveyId);
    public List<BatchSurvey> findAll();
    public List<BatchSurvey> findAllByBatchId(Integer  batch);
    void assignSurveyToAll(BatchSurveyAssignAllDTO dto);

}