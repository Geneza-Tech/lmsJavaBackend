package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.BatchTrainerRepository;
import com.geneza.lms.domain.BatchTrainer;
import com.geneza.lms.service.BatchTrainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BatchTrainerService")
@Transactional
public class BatchTrainerServiceImpl implements BatchTrainerService {

    @Autowired
    private BatchTrainerRepository batchTrainerRepository;
    public BatchTrainerServiceImpl() {
    }

    @Transactional
    public BatchTrainer findById(Integer id) {
        return batchTrainerRepository.findById(id);
    }

    @Transactional
    public List<BatchTrainer> findAll() {
        return batchTrainerRepository.findAll();
    }
     
    @Transactional
    public void saveBatchTrainer(BatchTrainer batchTrainer) {
        BatchTrainer existingBatchTrainer = batchTrainerRepository.findById(batchTrainer.getId());
        if (existingBatchTrainer != null) {
        if (existingBatchTrainer != batchTrainer) {      
        existingBatchTrainer.setId(batchTrainer.getId());
                existingBatchTrainer.setBatch(batchTrainer.getBatch());
                existingBatchTrainer.setTrainer(batchTrainer.getTrainer());
        }
        batchTrainer = batchTrainerRepository.save(existingBatchTrainer);
    }else{
        batchTrainer = batchTrainerRepository.save(batchTrainer);
        }
        batchTrainerRepository.flush();
    }

    public boolean deleteBatchTrainer(Integer batchTrainerId) {
        BatchTrainer batchTrainer = batchTrainerRepository.findById(batchTrainerId);
        if(batchTrainer!=null) {
            batchTrainerRepository.delete(batchTrainer);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<BatchTrainer> findAllByBatchId(Integer  batchId) {
        return new java.util.ArrayList<BatchTrainer>(batchTrainerRepository.findAllByBatchId(batchId));
    }@Transactional
    public List<BatchTrainer> findAllByTrainerId(Integer  trainerId) {
        return new java.util.ArrayList<BatchTrainer>(batchTrainerRepository.findAllByTrainerId(trainerId));
    }

    @Override
    public List<BatchTrainer> findByPersonId(Integer personId) {
        return batchTrainerRepository.findByPersonId(personId);
    }

}