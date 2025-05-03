package com.geneza.lms.service;
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.domain.Enrollment;

import java.util.List;
import java.util.Optional;

public interface AssignmentSubmissionService {
    public AssignmentSubmission findById(Integer id);
    public void saveAssignmentSubmission(AssignmentSubmission assignmentSubmission_1);
    public boolean deleteAssignmentSubmission(Integer assignmentSubmissionId);
    public List<AssignmentSubmission> findAll();
    public List<AssignmentSubmission> findAllByAssignmentId(Integer  assignment);
    public List<AssignmentSubmission> findAllByEnrollmentId(Integer  enrollment);
    public List<AssignmentSubmission> findAllBySubmissionStatusId(Integer  submissionStatus);
    List<AssignmentSubmission> getSubmissionsByPersonId(Integer personId);
    List<AssignmentSubmission> getSubmissionsByModuleAndStudentId(Integer batchId,Integer moduleId, Integer studentId);
   
}