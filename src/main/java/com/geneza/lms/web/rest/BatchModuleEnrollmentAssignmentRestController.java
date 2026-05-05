package com.geneza.lms.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.geneza.lms.domain.BatchModuleEnrollmentAssignment;
import com.geneza.lms.service.BatchModuleEnrollmentAssignmentService;

@RestController
@RequestMapping("/BatchModuleEnrollmentAssignment")
public class BatchModuleEnrollmentAssignmentRestController {

    @Autowired
    private BatchModuleEnrollmentAssignmentService service;

    // ✅ SINGLE CREATE
    @PostMapping
    public BatchModuleEnrollmentAssignment create(@RequestBody BatchModuleEnrollmentAssignment entity) {
        return service.create(entity);
    }

    // ✅ SINGLE UPDATE
    @PutMapping("/{id}")
    public BatchModuleEnrollmentAssignment update(
            @PathVariable Integer id,
            @RequestBody BatchModuleEnrollmentAssignment entity) {

        return service.update(id, entity);
    }

    // ✅ BULK CREATE
    @PostMapping("/bulk")
    public List<BatchModuleEnrollmentAssignment> bulkCreate(
            @RequestBody List<BatchModuleEnrollmentAssignment> list) {

        return service.saveAll(list);
    }

    // ✅ BULK DELETE
    @PostMapping("/bulk-delete")
    public void bulkDelete(
            @RequestBody List<BatchModuleEnrollmentAssignment> list) {

        service.deleteAll(list);
    }

    // ✅ GET ALL
    @GetMapping
    public List<BatchModuleEnrollmentAssignment> findAll() {
        return service.findAll();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public BatchModuleEnrollmentAssignment findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    // ✅ FILTERS
    @GetMapping("/Enrollment/{enrollmentId}")
    public List<BatchModuleEnrollmentAssignment> getByEnrollment(@PathVariable Integer enrollmentId) {
        return service.findAllByEnrollmentId(enrollmentId);
    }

    @GetMapping("/BatchModule/{batchModuleId}")
    public List<BatchModuleEnrollmentAssignment> getByBatchModule(@PathVariable Integer batchModuleId) {
        return service.findAllByBatchModuleId(batchModuleId);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @GetMapping("/Batch/{batchId}")
public List<BatchModuleEnrollmentAssignment> getByBatch(@PathVariable Integer batchId) {
    return service.findAllByBatchId(batchId);
}

@GetMapping("/Student/{studentId}")
public List<BatchModuleEnrollmentAssignment> getByStudent(@PathVariable Integer studentId) {
    return service.findAllByStudentId(studentId);
}
}