package com.geneza.lms.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.geneza.lms.domain.BatchModuleProgress;
import com.geneza.lms.service.BatchModuleProgressService;

@RestController
@RequestMapping("/BatchModuleProgress")
public class BatchModuleProgressRestController {

    @Autowired
    private BatchModuleProgressService service;

    // ✅ SINGLE CREATE
    @PostMapping
    public BatchModuleProgress create(@RequestBody BatchModuleProgress entity) {
        return service.create(entity);
    }

    // ✅ SINGLE UPDATE
    @PutMapping("/{id}")
    public BatchModuleProgress update(
            @PathVariable Integer id,
            @RequestBody BatchModuleProgress entity) {
        return service.update(id, entity);
    }

    // ✅ BULK CREATE
    @PostMapping("/bulk")
    public List<BatchModuleProgress> bulkCreate(@RequestBody List<BatchModuleProgress> list) {
        return service.saveAll(list);
    }

    // ✅ BULK UPDATE
    @PutMapping("/bulk")
    public List<BatchModuleProgress> bulkUpdate(@RequestBody List<BatchModuleProgress> list) {
        return service.saveAll(list);
    }

    // ✅ GET ALL
    @GetMapping
    public List<BatchModuleProgress> findAll() {
        return service.findAll();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public BatchModuleProgress findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    // ✅ FILTERS
    @GetMapping("/Enrollment/{enrollmentId}")
    public List<BatchModuleProgress> getByEnrollment(@PathVariable Integer enrollmentId) {
        return service.findAllByEnrollmentId(enrollmentId);
    }

    @GetMapping("/BatchModule/{batchModuleId}")
    public List<BatchModuleProgress> getByBatchModule(@PathVariable Integer batchModuleId) {
        return service.findAllByBatchModuleId(batchModuleId);
    }

    @GetMapping("/Batch/{batchId}")
public List<BatchModuleProgress> getByBatch(@PathVariable Integer batchId) {
    return service.findAllByBatchId(batchId);
}
}