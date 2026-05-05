package com.geneza.lms.service;
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.dto.AssignmentResponseDTO;

import java.util.List;

public interface AssignmentService {
    public Assignment findById(Integer id);
    public void saveAssignment(Assignment assignment_1);
    public boolean deleteAssignment(Integer assignmentId);
    public List<Assignment> findAll();
    public List<Assignment> findAllByModuleId(Integer  module);
    public List<Assignment> findAssignmentsByPersonId(Integer personId);
    public List<AssignmentResponseDTO> getAssignmentsByModuleAndRole(Integer moduleId, String role);
    public List<AssignmentResponseDTO> getAssignmentsWithAllAttachments(Integer moduleId);
    Assignment saveAndReturn(Assignment assignment);
    public List<AssignmentResponseDTO> getAssignmentsByBatch(Integer batchId, String role);
    
}