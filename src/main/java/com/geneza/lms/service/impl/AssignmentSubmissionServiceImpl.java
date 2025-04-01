package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.AssignmentSubmissionRepository;
import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.service.AssignmentSubmissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AssignmentSubmissionService")
@Transactional
public class AssignmentSubmissionServiceImpl implements AssignmentSubmissionService {

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
        AssignmentSubmission existingAssignmentSubmission = assignmentSubmissionRepository.findById(assignmentSubmission.getId());
        if (existingAssignmentSubmission != null) {
        if (existingAssignmentSubmission != assignmentSubmission) {      
        existingAssignmentSubmission.setId(assignmentSubmission.getId());
                existingAssignmentSubmission.setAssignment(assignmentSubmission.getAssignment());
                existingAssignmentSubmission.setEnrollment(assignmentSubmission.getEnrollment());
                existingAssignmentSubmission.setSubmissionContent(assignmentSubmission.getSubmissionContent());
                existingAssignmentSubmission.setSubmissionStatus(assignmentSubmission.getSubmissionStatus());
        }
        assignmentSubmission = assignmentSubmissionRepository.save(existingAssignmentSubmission);
    }else{
        assignmentSubmission = assignmentSubmissionRepository.save(assignmentSubmission);
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

    

}