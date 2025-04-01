package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.SubmissionStatusRepository;
import com.geneza.lms.domain.SubmissionStatus;
import com.geneza.lms.service.SubmissionStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SubmissionStatusService")
@Transactional
public class SubmissionStatusServiceImpl implements SubmissionStatusService {

    @Autowired
    private SubmissionStatusRepository submissionStatusRepository;
    public SubmissionStatusServiceImpl() {
    }

    @Transactional
    public SubmissionStatus findById(Integer id) {
        return submissionStatusRepository.findById(id);
    }

    @Transactional
    public List<SubmissionStatus> findAll() {
        return submissionStatusRepository.findAll();
    }
     
    @Transactional
    public void saveSubmissionStatus(SubmissionStatus submissionStatus) {
        SubmissionStatus existingSubmissionStatus = submissionStatusRepository.findById(submissionStatus.getId());
        if (existingSubmissionStatus != null) {
        if (existingSubmissionStatus != submissionStatus) {      
        existingSubmissionStatus.setId(submissionStatus.getId());
                existingSubmissionStatus.setSubmissionStatus(submissionStatus.getSubmissionStatus());
        }
        submissionStatus = submissionStatusRepository.save(existingSubmissionStatus);
    }else{
        submissionStatus = submissionStatusRepository.save(submissionStatus);
        }
        submissionStatusRepository.flush();
    }

    public boolean deleteSubmissionStatus(Integer submissionStatusId) {
        SubmissionStatus submissionStatus = submissionStatusRepository.findById(submissionStatusId);
        if(submissionStatus!=null) {
            submissionStatusRepository.delete(submissionStatus);
            return true;
        }else {
            return false;
        }
    }

    

}