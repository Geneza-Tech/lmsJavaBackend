package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.AssignmentRepository;
import com.geneza.lms.persistence.AssignmentSubmissionRepository;
import com.geneza.lms.persistence.AttachmentRepository;
import com.geneza.lms.persistence.EnrollmentRepository;
import com.geneza.lms.persistence.SubmissionStatusRepository;
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.domain.Attachment;
import com.geneza.lms.domain.Enrollment;
import com.geneza.lms.domain.SubmissionStatus;
import com.geneza.lms.dto.AssignmentSubmissionDTO;
import com.geneza.lms.dto.AssignmentSubmissionRequest;
import com.geneza.lms.dto.AttachmentDTO;
import com.geneza.lms.service.AssignmentSubmissionService;
import com.geneza.lms.service.AttachmentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service("AssignmentSubmissionService")
@Transactional
public class AssignmentSubmissionServiceImpl implements AssignmentSubmissionService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private SubmissionStatusRepository submissionStatusRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
private AttachmentService attachmentService;

    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;
    public AssignmentSubmissionServiceImpl() {
    }

    @Transactional
    public AssignmentSubmission findById(Integer id) {
        return assignmentSubmissionRepository.findById(id);
    }

    @Transactional
    public List<AssignmentSubmission> findAll() {
        return assignmentSubmissionRepository.findAll();
    }
     
    @Transactional
public AssignmentSubmission saveAssignmentSubmission(AssignmentSubmission submission) {

    // ✅ Validate Assignment
    if (submission.getAssignment() != null && submission.getAssignment().getId() != null) {
        Assignment assignment = assignmentRepository.findById(submission.getAssignment().getId());
        if (assignment == null) {
            throw new RuntimeException("Assignment not found");
        }
        submission.setAssignment(assignment);
    }

    // ✅ Validate Enrollment
    if (submission.getEnrollment() != null && submission.getEnrollment().getId() != null) {
        Enrollment enrollment = enrollmentRepository.findById(submission.getEnrollment().getId());
        if (enrollment == null) {
            throw new RuntimeException("Enrollment not found");
        }
        submission.setEnrollment(enrollment);
    }

    // ✅ Validate Submission Status
    if (submission.getSubmissionStatus() != null && submission.getSubmissionStatus().getId() != null) {
        SubmissionStatus submissionStatus = submissionStatusRepository.findById(submission.getSubmissionStatus().getId());
        if (submissionStatus == null) {
            throw new RuntimeException("SubmissionStatus not found");
        }
        submission.setSubmissionStatus(submissionStatus);
    }

    // ✅ Prevent duplicate submission (same assignment + enrollment)
    Optional<AssignmentSubmission> existing = assignmentSubmissionRepository
            .findByAssignmentAndEnrollment(
                    submission.getAssignment(),
                    submission.getEnrollment()
            );

    if (existing.isPresent()) {
        if (submission.getId() == null ||
            !existing.get().getId().equals(submission.getId())) {

            throw new IllegalStateException(
                "A submission already exists for this assignment and enrollment."
            );
        }
    }

    // ✅ Save submission FIRST (important to get ID)
    AssignmentSubmission saved = assignmentSubmissionRepository.save(submission);

    return saved;
}


    public boolean deleteAssignmentSubmission(Integer assignmentSubmissionId) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionRepository.findById(assignmentSubmissionId);
        if(assignmentSubmission!=null) {
            assignmentSubmissionRepository.delete(assignmentSubmission);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<AssignmentSubmission> findAllByAssignmentId(Integer  assignmentId) {
        return new java.util.ArrayList<AssignmentSubmission>(assignmentSubmissionRepository.findAllByAssignmentId(assignmentId));
    }@Transactional
    public List<AssignmentSubmission> findAllByEnrollmentId(Integer  enrollmentId) {
        return new java.util.ArrayList<AssignmentSubmission>(assignmentSubmissionRepository.findAllByEnrollmentId(enrollmentId));
    }@Transactional
    public List<AssignmentSubmission> findAllBySubmissionStatusId(Integer  submissionStatusId) {
        return new java.util.ArrayList<AssignmentSubmission>(assignmentSubmissionRepository.findAllBySubmissionStatusId(submissionStatusId));
    }

    @Override
    public List<AssignmentSubmission> getSubmissionsByPersonId(Integer personId) {
        return assignmentSubmissionRepository.findByPersonId(personId);
    }
    
    @Override
    public List<AssignmentSubmission> getSubmissionsByModuleAndStudentId(Integer batchId,Integer moduleId, Integer studentId) {
        return assignmentSubmissionRepository.findByBatchAndOptionalModuleAndStudent(batchId ,moduleId, studentId);
    }

    public List<Attachment> getSubmissionAttachments(Integer submissionId) {
    return attachmentRepository.findByLinkTypeAndLinkId("assignment_submission", submissionId);
}

public List<AssignmentSubmissionDTO> getSubmissionsWithAttachments(Integer assignmentId) {

    List<AssignmentSubmission> submissions =
        assignmentSubmissionRepository.findAllByAssignmentId(assignmentId);

    List<AssignmentSubmissionDTO> response = new ArrayList<>();

    for (AssignmentSubmission sub : submissions) {

        AssignmentSubmissionDTO dto = new AssignmentSubmissionDTO();
        dto.setId(sub.getId());
        dto.setSubmissionContent(sub.getSubmissionContent());
        dto.setComment(sub.getComment());

        // ✅ fetch attachments
        List<Attachment> attachments =
            attachmentRepository.findByLinkTypeAndLinkId(
                "assignment_submission", sub.getId()
            );

        List<AttachmentDTO> attachmentDTOs = attachments.stream()
                .map(AttachmentDTO::new)
                .collect(Collectors.toList());

        dto.setAttachments(attachmentDTOs);

        response.add(dto);
    }

    return response;
}


public AssignmentSubmission createSubmission(
        AssignmentSubmissionRequest request,
        List<MultipartFile> files) throws Exception {

    AssignmentSubmission submission = new AssignmentSubmission();

    // ✅ Set assignment
    Assignment assignment = assignmentRepository.findById(request.getAssignmentId());
    if (assignment == null) throw new RuntimeException("Assignment not found");
    submission.setAssignment(assignment);

    // ✅ Set enrollment
    Enrollment enrollment = enrollmentRepository.findById(request.getEnrollmentId());
    if (enrollment == null) throw new RuntimeException("Enrollment not found");
    submission.setEnrollment(enrollment);

    // ✅ Set content
    submission.setSubmissionContent(request.getSubmissionContent());
    submission.setComment(request.getComment());

    // ✅ timestamps
    submission.setCreatedAt(new Date());
    submission.setSubmittedAt(new Date());

    // ✅ default status
    SubmissionStatus status =
        submissionStatusRepository.findBySubmissionStatus("Submitted");

    submission.setSubmissionStatus(status);

    // ✅ save first
    AssignmentSubmission saved = assignmentSubmissionRepository.save(submission);

    // ✅ upload files
    if (files != null) {
        for (MultipartFile file : files) {
            attachmentService.upload(file, saved.getId(),
                "assignment_submission", "submission");
        }
    }

    return saved;
}
    
}