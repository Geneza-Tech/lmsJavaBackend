package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.AssignmentRepository;
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.service.AssignmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AssignmentService")
@Transactional
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;
    public AssignmentServiceImpl() {
    }

    @Transactional
    public Assignment findById(Integer id) {
        return assignmentRepository.findById(id);
    }

    @Transactional
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }
     
    @Transactional
    public void saveAssignment(Assignment assignment) {
        Assignment existingAssignment = assignmentRepository.findById(assignment.getId());
        if (existingAssignment != null) {
        if (existingAssignment != assignment) {      
        existingAssignment.setId(assignment.getId());
                existingAssignment.setAssignment(assignment.getAssignment());
                existingAssignment.setModule(assignment.getModule());
                existingAssignment.setAssignmentContent(assignment.getAssignmentContent());
                existingAssignment.setAssignmentKey(assignment.getAssignmentKey());
        }
        assignment = assignmentRepository.save(existingAssignment);
    }else{
        assignment = assignmentRepository.save(assignment);
        }
        assignmentRepository.flush();
    }

    public boolean deleteAssignment(Integer assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId);
        if(assignment!=null) {
            assignmentRepository.delete(assignment);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<Assignment> findAllByModuleId(Integer  moduleId) {
        return new java.util.ArrayList<Assignment>(assignmentRepository.findAllByModuleId(moduleId));
    }

    

}