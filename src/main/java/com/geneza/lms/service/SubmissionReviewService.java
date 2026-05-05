package com.geneza.lms.service;

import com.geneza.lms.domain.SubmissionReview;
import java.util.List;

public interface SubmissionReviewService {
    public SubmissionReview findById(Integer id);
    public void saveSubmissionReview(SubmissionReview submissionReview);
    public boolean deleteSubmissionReview(Integer submissionReviewId);
    public List<SubmissionReview> findAll();
    public List<SubmissionReview> findAllByAssignmentSubmissionId(Integer assignmentSubmissionId);
    public List<SubmissionReview> findAllByReviewedById(Integer batchModuleTrainerId);
    public List<SubmissionReview> findAllByStatus(String status);
    public List<SubmissionReview> findAllByBatchId(Integer batchId);
}