package com.geneza.lms.service;
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.domain.Enrollment;
import com.geneza.lms.dto.AssignmentSubmissionDTO;
import com.geneza.lms.dto.AssignmentSubmissionRequest;
import com.geneza.lms.dto.AssignmentSubmissionStatusDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface AssignmentSubmissionService {
    public AssignmentSubmission findById(Integer id);
    public AssignmentSubmission saveAssignmentSubmission(AssignmentSubmission assignmentSubmission);
    public boolean deleteAssignmentSubmission(Integer assignmentSubmissionId);
    public List<AssignmentSubmission> findAll();
    public List<AssignmentSubmission> findAllByAssignmentId(Integer  assignment);
    public List<AssignmentSubmission> findAllByEnrollmentId(Integer  enrollment);
    public List<AssignmentSubmission> findAllBySubmissionStatusId(Integer  submissionStatus);
    List<AssignmentSubmission> getSubmissionsByPersonId(Integer personId);
    List<AssignmentSubmissionStatusDTO> getSubmissionsByModuleAndStudentId(Integer batchId,Integer moduleId, Integer studentId);
    List<AssignmentSubmissionDTO> getSubmissionsWithAttachments(Integer assignmentId);

    AssignmentSubmission createSubmission(
    AssignmentSubmissionRequest request,
    List<MultipartFile> files
) throws Exception;
   
}