package com.geneza.lms.service;
import com.geneza.lms.domain.SubmissionStatus;
import java.util.List;

public interface SubmissionStatusService {
    public SubmissionStatus findById(Integer id);
    public void saveSubmissionStatus(SubmissionStatus submissionStatus_1);
    public boolean deleteSubmissionStatus(Integer submissionStatusId);
    public List<SubmissionStatus> findAll();
}