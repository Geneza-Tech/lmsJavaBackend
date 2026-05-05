package com.geneza.lms.persistence;

import com.geneza.lms.domain.SubmissionReview;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface SubmissionReviewRepository extends JpaRepository<SubmissionReview, Long> {
    SubmissionReview findById(Integer id);
    List<SubmissionReview> findAll();
    List<SubmissionReview> findByAssignmentSubmissionId(Integer assignmentSubmissionId);
    List<SubmissionReview> findByReviewedById(Integer batchModuleTrainerId);
    List<SubmissionReview> findByStatus(String status);
    List<SubmissionReview> findByReviewedBy_BatchModule_Batch_Id(Integer batchId);
    Page<SubmissionReview> findAll(Pageable pageable);
}