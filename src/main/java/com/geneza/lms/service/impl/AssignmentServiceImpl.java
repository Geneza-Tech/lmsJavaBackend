package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.AssignmentRepository;
import com.geneza.lms.persistence.AttachmentRepository;
import com.geneza.lms.domain.Assignment;
import com.geneza.lms.domain.Attachment;
import com.geneza.lms.dto.AssignmentResponseDTO;
import com.geneza.lms.dto.AttachmentDTO;
import com.geneza.lms.service.AssignmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Transactional
    public Assignment findById(Integer id) {
        return assignmentRepository.findById(id);
    }

    @Transactional
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

     @Override
    public Assignment saveAndReturn(Assignment assignment) {
        return assignmentRepository.save(assignment);
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
            existingAssignment.setArchivedAt(assignment.getArchivedAt()); // ✅ NEW
            existingAssignment.setDurationDays(assignment.getDurationDays());
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
    }
    
    @Transactional
    public List<Assignment> findAllByModuleId(Integer  moduleId) {
        return new java.util.ArrayList<Assignment>(assignmentRepository.findAllByModuleId(moduleId));
    }

    public List<Assignment> findAssignmentsByPersonId(Integer personId) {
        return assignmentRepository.findAssignmentsByPersonId(personId);
    }

     @Override
    public List<AssignmentResponseDTO> getAssignmentsByModuleAndRole(Integer moduleId, String role) {

        List<Assignment> assignments = assignmentRepository.findAllByModuleId(moduleId);
        List<AssignmentResponseDTO> response = new ArrayList<>();

        for (Assignment assignment : assignments) {

            AssignmentResponseDTO dto = new AssignmentResponseDTO();
            dto.setId(assignment.getId());
            dto.setAssignment(assignment.getAssignment());
            dto.setAssignmentContent(assignment.getAssignmentContent());
            dto.setDurationDays(assignment.getDurationDays());

            List<Attachment> attachments =
                attachmentRepository.findByLinkTypeAndLinkId("ASSIGNMENT", assignment.getId());

            List<AttachmentDTO> attachmentDTOs = new ArrayList<>();

            for (Attachment a : attachments) {

                // ✅ Hide key for students
                if ("student".equalsIgnoreCase(role) &&
                    "assignmentKey".equalsIgnoreCase(a.getType())) {
                    continue;
                }

                attachmentDTOs.add(new AttachmentDTO(a));
            }

            dto.setAttachments(attachmentDTOs);
            response.add(dto);
        }

        return response;
    }

    @Override
    public List<AssignmentResponseDTO> getAssignmentsWithAllAttachments(Integer moduleId) {

        List<Assignment> assignments = assignmentRepository.findAllByModuleId(moduleId);

        return assignments.stream().map(assignment -> {

            AssignmentResponseDTO dto = new AssignmentResponseDTO();
            dto.setId(assignment.getId());
            dto.setAssignment(assignment.getAssignment());
            dto.setAssignmentContent(assignment.getAssignmentContent());
            dto.setAssignmentKey(assignment.getAssignmentKey());
            dto.setDurationDays(assignment.getDurationDays());

            List<AttachmentDTO> attachments =
                attachmentRepository.findByLinkTypeAndLinkId("ASSIGNMENT", assignment.getId())
                    .stream()
                    .map(AttachmentDTO::new)
                    .collect(Collectors.toList());

            dto.setAttachments(attachments);
            return dto;

        }).collect(Collectors.toList());
    }

    public List<Assignment> getAssignmentsByBatchId(Integer batchId) {
    return assignmentRepository.findAssignmentsByBatchId(batchId);
    }

    
public List<AssignmentResponseDTO> getAssignmentsByBatch(Integer batchId, String role) {

    List<Assignment> assignments =
            assignmentRepository.findAssignmentsByBatchId(batchId);

    List<AssignmentResponseDTO> response = new ArrayList<>();

    for (Assignment assignment : assignments) {

        AssignmentResponseDTO dto = new AssignmentResponseDTO();
        dto.setId(assignment.getId());
        dto.setAssignment(assignment.getAssignment());
        dto.setAssignmentContent(assignment.getAssignmentContent());
        dto.setDurationDays(assignment.getDurationDays());

        // ✅ Only include key for admin
        if (!"student".equalsIgnoreCase(role)) {
            dto.setAssignmentKey(assignment.getAssignmentKey());
        }

        List<Attachment> attachments =
            attachmentRepository.findByLinkTypeAndLinkId("ASSIGNMENT", assignment.getId());

        List<AttachmentDTO> attachmentDTOs = new ArrayList<>();

        for (Attachment a : attachments) {

            // ✅ Hide assignmentKey attachment for student
            if ("student".equalsIgnoreCase(role) &&
                "assignmentKey".equalsIgnoreCase(a.getType())) {
                continue;
            }

            attachmentDTOs.add(new AttachmentDTO(a));
        }

        dto.setAttachments(attachmentDTOs);
        response.add(dto);
    }

    return response;
}
}