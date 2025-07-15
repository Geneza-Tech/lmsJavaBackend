package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.BatchMentorRepository;
import com.geneza.lms.domain.BatchMentor;
import com.geneza.lms.service.BatchMentorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BatchMentorService")
@Transactional
public class BatchMentorServiceImpl implements BatchMentorService {

    @Autowired
    private BatchMentorRepository batchMentorRepository;
    public BatchMentorServiceImpl() {
    }

    @Transactional
    public BatchMentor findById(Integer id) {
        return batchMentorRepository.findById(id);
    }

    @Transactional
    public List<BatchMentor> findAll() {
        return batchMentorRepository.findAll();
    }
     
    @Transactional
    public void saveBatchMentor(BatchMentor batchMentor) {
        BatchMentor existingBatchMentor = batchMentorRepository.findById(batchMentor.getId());
        if (existingBatchMentor != null) {
        if (existingBatchMentor != batchMentor) {      
        existingBatchMentor.setId(batchMentor.getId());
                existingBatchMentor.setBatch(batchMentor.getBatch());
                existingBatchMentor.setMentor(batchMentor.getMentor());
        }
        batchMentor = batchMentorRepository.save(existingBatchMentor);
    }else{
        batchMentor = batchMentorRepository.save(batchMentor);
        }
        batchMentorRepository.flush();
    }

    public boolean deleteBatchMentor(Integer batchMentorId) {
        BatchMentor batchMentor = batchMentorRepository.findById(batchMentorId);
        if(batchMentor!=null) {
            batchMentorRepository.delete(batchMentor);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<BatchMentor> findAllByBatchId(Integer  batchId) {
        return new java.util.ArrayList<BatchMentor>(batchMentorRepository.findAllByBatchId(batchId));
    }@Transactional
    public List<BatchMentor> findAllByMentorId(Integer  mentorId) {
        return new java.util.ArrayList<BatchMentor>(batchMentorRepository.findAllByMentorId(mentorId));
    }

    @Override
    public List<BatchMentor> findByPersonId(Integer personId) {
        return batchMentorRepository.findByPersonId(personId);
    }

}