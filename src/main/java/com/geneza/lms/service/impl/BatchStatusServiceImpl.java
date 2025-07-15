package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.BatchStatusRepository;
import com.geneza.lms.domain.BatchStatus;
import com.geneza.lms.service.BatchStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BatchStatusService")
@Transactional
public class BatchStatusServiceImpl implements BatchStatusService {

    @Autowired
    private BatchStatusRepository batchStatusRepository;
    public BatchStatusServiceImpl() {
    }

    @Transactional
    public BatchStatus findById(Integer id) {
        return batchStatusRepository.findById(id);
    }

    @Transactional
    public List<BatchStatus> findAll() {
        return batchStatusRepository.findAll();
    }
     
    @Transactional
    public void saveBatchStatus(BatchStatus batchStatus) {
        BatchStatus existingBatchStatus = batchStatusRepository.findById(batchStatus.getId());
        if (existingBatchStatus != null) {
        if (existingBatchStatus != batchStatus) {      
        existingBatchStatus.setId(batchStatus.getId());
                existingBatchStatus.setBatchStatus(batchStatus.getBatchStatus());
        }
        batchStatus = batchStatusRepository.save(existingBatchStatus);
    }else{
        batchStatus = batchStatusRepository.save(batchStatus);
        }
        batchStatusRepository.flush();
    }

    public boolean deleteBatchStatus(Integer batchStatusId) {
        BatchStatus batchStatus = batchStatusRepository.findById(batchStatusId);
        if(batchStatus!=null) {
            batchStatusRepository.delete(batchStatus);
            return true;
        }else {
            return false;
        }
    }

    

}