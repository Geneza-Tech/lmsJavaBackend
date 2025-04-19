package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.AssignmentRepository;
import com.geneza.lms.persistence.AssignmentSubmissionRepository;
import com.geneza.lms.persistence.EnrollmentRepository;
import com.geneza.lms.persistence.SubmissionStatusRepository;
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.domain.Enrollment;
import com.geneza.lms.domain.SubmissionStatus;
import com.geneza.lms.service.AssignmentSubmissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void saveAssignmentSubmission(AssignmentSubmission assignmentSubmission) {

        if (assignmentSubmission.getAssignment() != null && assignmentSubmission.getAssignment().getId() != null) {
            Assignment assignment = assignmentRepository.findById(assignmentSubmission.getAssignment().getId());
            if (assignment == null) throw new RuntimeException("Assignment not found");
            assignmentSubmission.setAssignment(assignment);
        }
    
        if (assignmentSubmission.getEnrollment() != null && assignmentSubmission.getEnrollment().getId() != null) {
            Enrollment enrollment = enrollmentRepository.findById(assignmentSubmission.getEnrollment().getId());
            if (enrollment == null) throw new RuntimeException("Enrollment not found");
            assignmentSubmission.setEnrollment(enrollment);
        }
    
        if (assignmentSubmission.getSubmissionStatus() != null && assignmentSubmission.getSubmissionStatus().getId() != null) {
            SubmissionStatus submissionStatus = submissionStatusRepository.findById(assignmentSubmission.getSubmissionStatus().getId());
            if (submissionStatus == null) throw new RuntimeException("SubmissionStatus not found");
            assignmentSubmission.setSubmissionStatus(submissionStatus);
        }

        AssignmentSubmission existingAssignmentSubmission = assignmentSubmissionRepository.findById(assignmentSubmission.getId());
    if (existingAssignmentSubmission != null) {
        if (existingAssignmentSubmission != assignmentSubmission) {
            existingAssignmentSubmission.setAssignment(assignmentSubmission.getAssignment());
            existingAssignmentSubmission.setEnrollment(assignmentSubmission.getEnrollment());
            existingAssignmentSubmission.setSubmissionContent(assignmentSubmission.getSubmissionContent());
            existingAssignmentSubmission.setComment(assignmentSubmission.getComment());
            existingAssignmentSubmission.setSubmissionStatus(assignmentSubmission.getSubmissionStatus());
            assignmentSubmissionRepository.save(existingAssignmentSubmission);
        }
    } else {
        assignmentSubmissionRepository.save(assignmentSubmission);
    }

    assignmentSubmissionRepository.flush();
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
    public List<AssignmentSubmission> getSubmissionsByModuleAndStudentName(Integer batchId,Integer moduleId, String studentName) {
        return assignmentSubmissionRepository.findByBatchAndOptionalModuleAndStudent(batchId ,moduleId, studentName);
    }
}