package com.geneza.lms.service;
import com.geneza.lms.domain.Assignment;
import java.util.List;

public interface AssignmentService {
    public Assignment findById(Integer id);
    public void saveAssignment(Assignment assignment_1);
    public boolean deleteAssignment(Integer assignmentId);
    public List<Assignment> findAll();
    public List<Assignment> findAllByModuleId(Integer  module);
}