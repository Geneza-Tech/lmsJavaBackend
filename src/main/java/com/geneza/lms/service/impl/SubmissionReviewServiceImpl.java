package com.geneza.lms.service.impl;

import com.geneza.lms.persistence.AssignmentSubmissionRepository;
import com.geneza.lms.persistence.SubmissionReviewRepository;
import com.geneza.lms.persistence.SubmissionStatusRepository;
import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.domain.SubmissionReview;
import com.geneza.lms.domain.SubmissionStatus;
import com.geneza.lms.domain.enums.ReviewStatus;
import com.geneza.lms.domain.enums.ValidationStatus;
import com.geneza.lms.service.SubmissionReviewService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SubmissionReviewService")
@Transactional
public class SubmissionReviewServiceImpl implements SubmissionReviewService {

    @Autowired
    private SubmissionReviewRepository submissionReviewRepository;

    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Autowired
private SubmissionStatusRepository submissionStatusRepository;

    public SubmissionReviewServiceImpl() {
    }

    @Transactional
    public SubmissionReview findById(Integer id) {
        return submissionReviewRepository.findById(id);
    }

    @Transactional
    public List<SubmissionReview> findAll() {
        return submissionReviewRepository.findAll();
    }

    private String mapReviewStatus(ReviewStatus reviewStatus) {

    if (reviewStatus == null) return "Submitted";

    switch (reviewStatus) {
        case APPROVED:
            return "Accepted";

        case REJECTED:
            return "Redo";

        case PENDING:
            return "Submitted";

        default:
            return "Submitted";
    }
}

    @Transactional
public void saveSubmissionReview(SubmissionReview submissionReview) {

    SubmissionReview existing = submissionReviewRepository.findById(submissionReview.getId());

    if (existing != null) {
        if (existing != submissionReview) {
            existing.setId(submissionReview.getId());
            existing.setAssignmentSubmission(submissionReview.getAssignmentSubmission());
            existing.setReviewedBy(submissionReview.getReviewedBy());
            existing.setScore(submissionReview.getScore());
            existing.setComments(submissionReview.getComments());
            existing.setStatus(submissionReview.getStatus());
        }

        submissionReview = submissionReviewRepository.save(existing);

    } else {
        submissionReview.setCreatedAt(new Date());
        submissionReview = submissionReviewRepository.save(submissionReview);
    }

    // 🔥🔥 ADD THIS BLOCK (IMPORTANT)
    AssignmentSubmission submission = submissionReview.getAssignmentSubmission();

if (submission != null) {

    AssignmentSubmission dbSubmission =
        assignmentSubmissionRepository.findById(submission.getId());

    if (dbSubmission != null) {

        String mappedStatus = mapReviewStatus(submissionReview.getStatus());

        SubmissionStatus statusEntity =
            submissionStatusRepository.findBySubmissionStatus(mappedStatus);

        if (statusEntity != null) {
            dbSubmission.setSubmissionStatus(statusEntity);
            assignmentSubmissionRepository.save(dbSubmission);
        } else {
            throw new RuntimeException("Status not found in DB: " + mappedStatus);
        }
    }
}

    submissionReviewRepository.flush();
}

    public boolean deleteSubmissionReview(Integer submissionReviewId) {
        SubmissionReview submissionReview = submissionReviewRepository.findById(submissionReviewId);
        if (submissionReview != null) {
            submissionReviewRepository.delete(submissionReview);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public List<SubmissionReview> findAllByAssignmentSubmissionId(Integer assignmentSubmissionId) {
        return new java.util.ArrayList<SubmissionReview>(submissionReviewRepository.findByAssignmentSubmissionId(assignmentSubmissionId));
    }

    @Transactional
    public List<SubmissionReview> findAllByReviewedById(Integer batchModuleTrainerId) {
        return new java.util.ArrayList<SubmissionReview>(submissionReviewRepository.findByReviewedById(batchModuleTrainerId));
    }

    @Transactional
    public List<SubmissionReview> findAllByStatus(String status) {
        return new java.util.ArrayList<SubmissionReview>(submissionReviewRepository.findByStatus(status));
    }

    @Override
    public List<SubmissionReview> findAllByBatchId(Integer batchId) {
        return submissionReviewRepository.findByReviewedBy_BatchModule_Batch_Id(batchId);
    }
}