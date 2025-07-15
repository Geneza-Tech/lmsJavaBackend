package com.geneza.lms.web.rest;

import com.geneza.lms.domain.Session;
import com.geneza.lms.persistence.SessionRepository;
import com.geneza.lms.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@Controller("SessionRestController")
public class SessionRestController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SessionRepository sessionRepository;

    @RequestMapping(value = "/Session", method = RequestMethod.PUT)
    @ResponseBody
    public Session updateSession(@RequestBody Session session) {
        sessionService.save(session);
        return sessionRepository.findById(session.getId()).orElse(null);
    }

    @RequestMapping(value = "/Session", method = RequestMethod.POST)
    @ResponseBody
    public Session createSession(@RequestBody Session session) {
        sessionService.save(session);
        return sessionRepository.findById(session.getId()).orElse(null);
    }
    

    @RequestMapping(value = "/Session", method = RequestMethod.GET)
    @ResponseBody
    public List<Session> listSessions() {
        return sessionService.findAll();
    }

    @RequestMapping(value = "/Session/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Session getSessionById(@PathVariable Integer id) {
        return sessionService.findById(id);
    }

    @RequestMapping(value = "/Session/Delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteSession(@PathVariable Integer id) {
        return sessionService.deleteById(id);
    }

    @RequestMapping(value = "/Session/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Session> getPaged(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Direction.DESC, "id"));
        return sessionService.findAll(pageable);
    }

    @RequestMapping(value = "/Session/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Session> getPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction) {
        Sort sort = (direction == 1) ? Sort.by(sortField).descending() : Sort.by(sortField).ascending();
        Pageable pageable = PageRequest.of(page, 10, sort);
        return sessionService.findAll(pageable);
    }

    @RequestMapping(value = "/Session/Batch/{batchId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Session> getByBatchId(@PathVariable Integer batchId) {
        return sessionService.findAllByBatchId(batchId);
    }

    @RequestMapping(value = "/Session/BatchModule/{batchModuleId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Session> getByBatchModuleId(@PathVariable Integer batchModuleId) {
        return sessionService.findAllByBatchModuleId(batchModuleId);
    }
}