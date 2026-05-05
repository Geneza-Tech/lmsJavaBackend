package com.geneza.lms.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.geneza.lms.domain.SessionBatchModule;
import com.geneza.lms.service.SessionBatchModuleService;

@RestController
@RequestMapping("/SessionBatchModule")
public class SessionBatchModuleRestController {

    @Autowired
    private SessionBatchModuleService service;

    // ✅ SINGLE CREATE
    @PostMapping
    public SessionBatchModule create(@RequestBody SessionBatchModule entity) {
        return service.create(entity);
    }

    // ✅ SINGLE UPDATE
    @PutMapping("/{id}")
    public SessionBatchModule update(
            @PathVariable Integer id,
            @RequestBody SessionBatchModule entity) {

        return service.update(id, entity);
    }

    // ✅ BULK CREATE
    @PostMapping("/bulk")
    public List<SessionBatchModule> bulkCreate(@RequestBody List<SessionBatchModule> list) {
        return service.saveAll(list);
    }

    // ✅ BULK UPDATE (UPSERT or strict depending on your service)
    @PutMapping("/bulk")
    public List<SessionBatchModule> bulkUpdate(@RequestBody List<SessionBatchModule> list) {
        return service.saveAll(list);
    }

    // ✅ GET ALL
    @GetMapping
    public List<SessionBatchModule> findAll() {
        return service.findAll();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public SessionBatchModule findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    // ✅ FILTERS
    @GetMapping("/Session/{sessionId}")
    public List<SessionBatchModule> getBySession(@PathVariable Integer sessionId) {
        return service.findAllBySessionId(sessionId);
    }

    @GetMapping("/BatchModule/{batchModuleId}")
    public List<SessionBatchModule> getByBatchModule(@PathVariable Integer batchModuleId) {
        return service.findAllByBatchModuleId(batchModuleId);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}