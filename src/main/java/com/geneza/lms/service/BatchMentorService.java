package com.geneza.lms.service;
import com.geneza.lms.domain.BatchMentor;
import java.util.List;

public interface BatchMentorService {
    public BatchMentor findById(Integer id);
    public void saveBatchMentor(BatchMentor batchMentor_1);
    public boolean deleteBatchMentor(Integer batchMentorId);
    public List<BatchMentor> findAll();
    public List<BatchMentor> findAllByBatchId(Integer  batch);
    public List<BatchMentor> findAllByMentorId(Integer  mentor);
    public List<BatchMentor> findByPersonId(Integer personId);

}